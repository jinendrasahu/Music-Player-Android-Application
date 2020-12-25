package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

final class DiskLruCache implements Closeable {
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,64}");
    static final String MAGIC = "libcore.io.DiskLruCache";
    /* access modifiers changed from: private */
    public static final OutputStream NULL_OUTPUT_STREAM = new OutputStream() {
        public void write(int b) throws IOException {
        }
    };
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Callable<Void> cleanupCallable = new Callable<Void>() {
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r4 = this;
                com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache r0 = com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.this
                monitor-enter(r0)
                com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache r1 = com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.this     // Catch:{ all -> 0x002d }
                java.io.Writer r1 = r1.journalWriter     // Catch:{ all -> 0x002d }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                return r2
            L_0x000e:
                com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache r1 = com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.this     // Catch:{ all -> 0x002d }
                r1.trimToSize()     // Catch:{ all -> 0x002d }
                com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache r1 = com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.this     // Catch:{ all -> 0x002d }
                r1.trimToFileCount()     // Catch:{ all -> 0x002d }
                com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache r1 = com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.this     // Catch:{ all -> 0x002d }
                boolean r1 = r1.journalRebuildRequired()     // Catch:{ all -> 0x002d }
                if (r1 == 0) goto L_0x002b
                com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache r1 = com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.this     // Catch:{ all -> 0x002d }
                r1.rebuildJournal()     // Catch:{ all -> 0x002d }
                com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache r1 = com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.this     // Catch:{ all -> 0x002d }
                r3 = 0
                int unused = r1.redundantOpCount = r3     // Catch:{ all -> 0x002d }
            L_0x002b:
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                return r2
            L_0x002d:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.AnonymousClass1.call():java.lang.Void");
        }
    };
    /* access modifiers changed from: private */
    public final File directory;
    final ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private int fileCount = 0;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    /* access modifiers changed from: private */
    public Writer journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private int maxFileCount;
    private long maxSize;
    private long nextSequenceNumber = 0;
    /* access modifiers changed from: private */
    public int redundantOpCount;
    private long size = 0;
    /* access modifiers changed from: private */
    public final int valueCount;

    private DiskLruCache(File directory2, int appVersion2, int valueCount2, long maxSize2, int maxFileCount2) {
        File file = directory2;
        this.directory = file;
        this.appVersion = appVersion2;
        this.journalFile = new File(file, JOURNAL_FILE);
        this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
        this.valueCount = valueCount2;
        this.maxSize = maxSize2;
        this.maxFileCount = maxFileCount2;
    }

    public static DiskLruCache open(File directory2, int appVersion2, int valueCount2, long maxSize2, int maxFileCount2) throws IOException {
        File file = directory2;
        if (maxSize2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (maxFileCount2 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
        } else if (valueCount2 > 0) {
            File backupFile = new File(directory2, JOURNAL_FILE_BACKUP);
            if (backupFile.exists()) {
                File journalFile2 = new File(directory2, JOURNAL_FILE);
                if (journalFile2.exists()) {
                    backupFile.delete();
                } else {
                    renameTo(backupFile, journalFile2, false);
                }
            }
            DiskLruCache cache = new DiskLruCache(directory2, appVersion2, valueCount2, maxSize2, maxFileCount2);
            if (cache.journalFile.exists()) {
                try {
                    cache.readJournal();
                    cache.processJournal();
                    cache.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(cache.journalFile, true), Util.US_ASCII));
                    return cache;
                } catch (IOException journalIsCorrupt) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + directory2 + " is corrupt: " + journalIsCorrupt.getMessage() + ", removing");
                    cache.delete();
                }
            }
            directory2.mkdirs();
            DiskLruCache diskLruCache = new DiskLruCache(directory2, appVersion2, valueCount2, maxSize2, maxFileCount2);
            diskLruCache.rebuildJournal();
            return diskLruCache;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private void readJournal() throws IOException {
        int lineCount;
        StrictLineReader reader = new StrictLineReader(new FileInputStream(this.journalFile), Util.US_ASCII);
        try {
            String magic = reader.readLine();
            String version = reader.readLine();
            String appVersionString = reader.readLine();
            String valueCountString = reader.readLine();
            String blank = reader.readLine();
            if (!MAGIC.equals(magic) || !VERSION_1.equals(version) || !Integer.toString(this.appVersion).equals(appVersionString) || !Integer.toString(this.valueCount).equals(valueCountString) || !"".equals(blank)) {
                throw new IOException("unexpected journal header: [" + magic + ", " + version + ", " + valueCountString + ", " + blank + "]");
            }
            lineCount = 0;
            while (true) {
                readJournalLine(reader.readLine());
                lineCount++;
            }
        } catch (EOFException e) {
            this.redundantOpCount = lineCount - this.lruEntries.size();
            Util.closeQuietly(reader);
        } catch (Throwable th) {
            Util.closeQuietly(reader);
            throw th;
        }
    }

    private void readJournalLine(String line) throws IOException {
        String key;
        int firstSpace = line.indexOf(32);
        if (firstSpace != -1) {
            int keyBegin = firstSpace + 1;
            int secondSpace = line.indexOf(32, keyBegin);
            if (secondSpace == -1) {
                key = line.substring(keyBegin);
                if (firstSpace == REMOVE.length() && line.startsWith(REMOVE)) {
                    this.lruEntries.remove(key);
                    return;
                }
            } else {
                key = line.substring(keyBegin, secondSpace);
            }
            Entry entry = this.lruEntries.get(key);
            if (entry == null) {
                entry = new Entry(key);
                this.lruEntries.put(key, entry);
            }
            if (secondSpace != -1 && firstSpace == CLEAN.length() && line.startsWith(CLEAN)) {
                String[] parts = line.substring(secondSpace + 1).split(" ");
                boolean unused = entry.readable = true;
                Editor unused2 = entry.currentEditor = null;
                entry.setLengths(parts);
            } else if (secondSpace == -1 && firstSpace == DIRTY.length() && line.startsWith(DIRTY)) {
                Editor unused3 = entry.currentEditor = new Editor(entry);
            } else if (secondSpace != -1 || firstSpace != READ.length() || !line.startsWith(READ)) {
                throw new IOException("unexpected journal line: " + line);
            }
        } else {
            throw new IOException("unexpected journal line: " + line);
        }
    }

    private void processJournal() throws IOException {
        deleteIfExists(this.journalFileTmp);
        Iterator<Entry> i = this.lruEntries.values().iterator();
        while (i.hasNext()) {
            Entry entry = i.next();
            if (entry.currentEditor == null) {
                for (int t = 0; t < this.valueCount; t++) {
                    this.size += entry.lengths[t];
                    this.fileCount++;
                }
            } else {
                Editor unused = entry.currentEditor = null;
                for (int t2 = 0; t2 < this.valueCount; t2++) {
                    deleteIfExists(entry.getCleanFile(t2));
                    deleteIfExists(entry.getDirtyFile(t2));
                }
                i.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public synchronized void rebuildJournal() throws IOException {
        if (this.journalWriter != null) {
            this.journalWriter.close();
        }
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.US_ASCII));
        try {
            writer.write(MAGIC);
            writer.write("\n");
            writer.write(VERSION_1);
            writer.write("\n");
            writer.write(Integer.toString(this.appVersion));
            writer.write("\n");
            writer.write(Integer.toString(this.valueCount));
            writer.write("\n");
            writer.write("\n");
            for (Entry entry : this.lruEntries.values()) {
                if (entry.currentEditor != null) {
                    writer.write("DIRTY " + entry.key + 10);
                } else {
                    writer.write("CLEAN " + entry.key + entry.getLengths() + 10);
                }
            }
            writer.close();
            if (this.journalFile.exists()) {
                renameTo(this.journalFile, this.journalFileBackup, true);
            }
            renameTo(this.journalFileTmp, this.journalFile, false);
            this.journalFileBackup.delete();
            this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
        } catch (Throwable th) {
            writer.close();
            throw th;
        }
    }

    private static void deleteIfExists(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void renameTo(File from, File to, boolean deleteDestination) throws IOException {
        if (deleteDestination) {
            deleteIfExists(to);
        }
        if (!from.renameTo(to)) {
            throw new IOException();
        }
    }

    public synchronized Snapshot get(String key) throws IOException {
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (entry == null) {
            return null;
        }
        if (!entry.readable) {
            return null;
        }
        File[] files = new File[this.valueCount];
        InputStream[] ins = new InputStream[this.valueCount];
        int i = 0;
        int i2 = 0;
        while (i2 < this.valueCount) {
            try {
                File file = entry.getCleanFile(i2);
                files[i2] = file;
                ins[i2] = new FileInputStream(file);
                i2++;
            } catch (FileNotFoundException e) {
                while (i < this.valueCount && ins[i] != null) {
                    Util.closeQuietly(ins[i]);
                    i++;
                }
                return null;
            }
        }
        this.redundantOpCount++;
        this.journalWriter.append("READ " + key + 10);
        if (journalRebuildRequired()) {
            this.executorService.submit(this.cleanupCallable);
        }
        return new Snapshot(key, entry.sequenceNumber, files, ins, entry.lengths);
    }

    public Editor edit(String key) throws IOException {
        return edit(key, -1);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.Editor edit(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.checkNotClosed()     // Catch:{ all -> 0x0062 }
            r5.validateKey(r6)     // Catch:{ all -> 0x0062 }
            java.util.LinkedHashMap<java.lang.String, com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$Entry> r0 = r5.lruEntries     // Catch:{ all -> 0x0062 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0062 }
            com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$Entry r0 = (com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0062 }
            r1 = -1
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            r2 = 0
            if (r1 == 0) goto L_0x0022
            if (r0 == 0) goto L_0x0020
            long r3 = r0.sequenceNumber     // Catch:{ all -> 0x0062 }
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0022
        L_0x0020:
            monitor-exit(r5)
            return r2
        L_0x0022:
            if (r0 != 0) goto L_0x0030
            com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$Entry r1 = new com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$Entry     // Catch:{ all -> 0x0062 }
            r1.<init>(r6)     // Catch:{ all -> 0x0062 }
            r0 = r1
            java.util.LinkedHashMap<java.lang.String, com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$Entry> r1 = r5.lruEntries     // Catch:{ all -> 0x0062 }
            r1.put(r6, r0)     // Catch:{ all -> 0x0062 }
            goto L_0x0038
        L_0x0030:
            com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$Editor r1 = r0.currentEditor     // Catch:{ all -> 0x0062 }
            if (r1 == 0) goto L_0x0038
            monitor-exit(r5)
            return r2
        L_0x0038:
            com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$Editor r1 = new com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$Editor     // Catch:{ all -> 0x0062 }
            r1.<init>(r0)     // Catch:{ all -> 0x0062 }
            com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.Editor unused = r0.currentEditor = r1     // Catch:{ all -> 0x0062 }
            java.io.Writer r2 = r5.journalWriter     // Catch:{ all -> 0x0062 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0062 }
            r3.<init>()     // Catch:{ all -> 0x0062 }
            java.lang.String r4 = "DIRTY "
            r3.append(r4)     // Catch:{ all -> 0x0062 }
            r3.append(r6)     // Catch:{ all -> 0x0062 }
            r4 = 10
            r3.append(r4)     // Catch:{ all -> 0x0062 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0062 }
            r2.write(r3)     // Catch:{ all -> 0x0062 }
            java.io.Writer r2 = r5.journalWriter     // Catch:{ all -> 0x0062 }
            r2.flush()     // Catch:{ all -> 0x0062 }
            monitor-exit(r5)
            return r1
        L_0x0062:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.edit(java.lang.String, long):com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$Editor");
    }

    public File getDirectory() {
        return this.directory;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized int getMaxFileCount() {
        return this.maxFileCount;
    }

    public synchronized void setMaxSize(long maxSize2) {
        this.maxSize = maxSize2;
        this.executorService.submit(this.cleanupCallable);
    }

    public synchronized long size() {
        return this.size;
    }

    public synchronized long fileCount() {
        return (long) this.fileCount;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0115, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void completeEdit(com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.Editor r12, boolean r13) throws java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$Entry r0 = r12.entry     // Catch:{ all -> 0x011c }
            com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$Editor r1 = r0.currentEditor     // Catch:{ all -> 0x011c }
            if (r1 != r12) goto L_0x0116
            r1 = 0
            if (r13 == 0) goto L_0x004d
            boolean r2 = r0.readable     // Catch:{ all -> 0x011c }
            if (r2 != 0) goto L_0x004d
            r2 = r1
        L_0x0015:
            int r3 = r11.valueCount     // Catch:{ all -> 0x011c }
            if (r2 >= r3) goto L_0x004d
            boolean[] r3 = r12.written     // Catch:{ all -> 0x011c }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x011c }
            if (r3 == 0) goto L_0x0033
            java.io.File r3 = r0.getDirtyFile(r2)     // Catch:{ all -> 0x011c }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x011c }
            if (r3 != 0) goto L_0x0030
            r12.abort()     // Catch:{ all -> 0x011c }
            monitor-exit(r11)
            return
        L_0x0030:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0033:
            r12.abort()     // Catch:{ all -> 0x011c }
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x011c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x011c }
            r3.<init>()     // Catch:{ all -> 0x011c }
            java.lang.String r4 = "Newly created entry didn't create value for index "
            r3.append(r4)     // Catch:{ all -> 0x011c }
            r3.append(r2)     // Catch:{ all -> 0x011c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x011c }
            r1.<init>(r3)     // Catch:{ all -> 0x011c }
            throw r1     // Catch:{ all -> 0x011c }
        L_0x004d:
        L_0x004e:
            int r2 = r11.valueCount     // Catch:{ all -> 0x011c }
            r3 = 1
            if (r1 >= r2) goto L_0x0088
            java.io.File r2 = r0.getDirtyFile(r1)     // Catch:{ all -> 0x011c }
            if (r13 == 0) goto L_0x0082
            boolean r4 = r2.exists()     // Catch:{ all -> 0x011c }
            if (r4 == 0) goto L_0x0085
            java.io.File r4 = r0.getCleanFile(r1)     // Catch:{ all -> 0x011c }
            r2.renameTo(r4)     // Catch:{ all -> 0x011c }
            long[] r5 = r0.lengths     // Catch:{ all -> 0x011c }
            r5 = r5[r1]     // Catch:{ all -> 0x011c }
            long r7 = r4.length()     // Catch:{ all -> 0x011c }
            long[] r9 = r0.lengths     // Catch:{ all -> 0x011c }
            r9[r1] = r7     // Catch:{ all -> 0x011c }
            long r9 = r11.size     // Catch:{ all -> 0x011c }
            long r9 = r9 - r5
            long r9 = r9 + r7
            r11.size = r9     // Catch:{ all -> 0x011c }
            int r9 = r11.fileCount     // Catch:{ all -> 0x011c }
            int r9 = r9 + r3
            r11.fileCount = r9     // Catch:{ all -> 0x011c }
            goto L_0x0085
        L_0x0082:
            deleteIfExists(r2)     // Catch:{ all -> 0x011c }
        L_0x0085:
            int r1 = r1 + 1
            goto L_0x004e
        L_0x0088:
            int r1 = r11.redundantOpCount     // Catch:{ all -> 0x011c }
            int r1 = r1 + r3
            r11.redundantOpCount = r1     // Catch:{ all -> 0x011c }
            r1 = 0
            com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.Editor unused = r0.currentEditor = r1     // Catch:{ all -> 0x011c }
            boolean r1 = r0.readable     // Catch:{ all -> 0x011c }
            r1 = r1 | r13
            r2 = 10
            if (r1 == 0) goto L_0x00ce
            boolean unused = r0.readable = r3     // Catch:{ all -> 0x011c }
            java.io.Writer r1 = r11.journalWriter     // Catch:{ all -> 0x011c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x011c }
            r3.<init>()     // Catch:{ all -> 0x011c }
            java.lang.String r4 = "CLEAN "
            r3.append(r4)     // Catch:{ all -> 0x011c }
            java.lang.String r4 = r0.key     // Catch:{ all -> 0x011c }
            r3.append(r4)     // Catch:{ all -> 0x011c }
            java.lang.String r4 = r0.getLengths()     // Catch:{ all -> 0x011c }
            r3.append(r4)     // Catch:{ all -> 0x011c }
            r3.append(r2)     // Catch:{ all -> 0x011c }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x011c }
            r1.write(r2)     // Catch:{ all -> 0x011c }
            if (r13 == 0) goto L_0x00f4
            long r1 = r11.nextSequenceNumber     // Catch:{ all -> 0x011c }
            r3 = 1
            long r3 = r3 + r1
            r11.nextSequenceNumber = r3     // Catch:{ all -> 0x011c }
            long unused = r0.sequenceNumber = r1     // Catch:{ all -> 0x011c }
            goto L_0x00f4
        L_0x00ce:
            java.util.LinkedHashMap<java.lang.String, com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$Entry> r1 = r11.lruEntries     // Catch:{ all -> 0x011c }
            java.lang.String r3 = r0.key     // Catch:{ all -> 0x011c }
            r1.remove(r3)     // Catch:{ all -> 0x011c }
            java.io.Writer r1 = r11.journalWriter     // Catch:{ all -> 0x011c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x011c }
            r3.<init>()     // Catch:{ all -> 0x011c }
            java.lang.String r4 = "REMOVE "
            r3.append(r4)     // Catch:{ all -> 0x011c }
            java.lang.String r4 = r0.key     // Catch:{ all -> 0x011c }
            r3.append(r4)     // Catch:{ all -> 0x011c }
            r3.append(r2)     // Catch:{ all -> 0x011c }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x011c }
            r1.write(r2)     // Catch:{ all -> 0x011c }
        L_0x00f4:
            java.io.Writer r1 = r11.journalWriter     // Catch:{ all -> 0x011c }
            r1.flush()     // Catch:{ all -> 0x011c }
            long r1 = r11.size     // Catch:{ all -> 0x011c }
            long r3 = r11.maxSize     // Catch:{ all -> 0x011c }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x010d
            int r1 = r11.fileCount     // Catch:{ all -> 0x011c }
            int r2 = r11.maxFileCount     // Catch:{ all -> 0x011c }
            if (r1 > r2) goto L_0x010d
            boolean r1 = r11.journalRebuildRequired()     // Catch:{ all -> 0x011c }
            if (r1 == 0) goto L_0x0114
        L_0x010d:
            java.util.concurrent.ThreadPoolExecutor r1 = r11.executorService     // Catch:{ all -> 0x011c }
            java.util.concurrent.Callable<java.lang.Void> r2 = r11.cleanupCallable     // Catch:{ all -> 0x011c }
            r1.submit(r2)     // Catch:{ all -> 0x011c }
        L_0x0114:
            monitor-exit(r11)
            return
        L_0x0116:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x011c }
            r1.<init>()     // Catch:{ all -> 0x011c }
            throw r1     // Catch:{ all -> 0x011c }
        L_0x011c:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.completeEdit(com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$Editor, boolean):void");
    }

    /* access modifiers changed from: private */
    public boolean journalRebuildRequired() {
        int i = this.redundantOpCount;
        return i >= 2000 && i >= this.lruEntries.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0096, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0098, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean remove(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.checkNotClosed()     // Catch:{ all -> 0x0099 }
            r8.validateKey(r9)     // Catch:{ all -> 0x0099 }
            java.util.LinkedHashMap<java.lang.String, com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$Entry> r0 = r8.lruEntries     // Catch:{ all -> 0x0099 }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x0099 }
            com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$Entry r0 = (com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0099 }
            r1 = 0
            if (r0 == 0) goto L_0x0097
            com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$Editor r2 = r0.currentEditor     // Catch:{ all -> 0x0099 }
            if (r2 == 0) goto L_0x001a
            goto L_0x0097
        L_0x001a:
        L_0x001b:
            int r2 = r8.valueCount     // Catch:{ all -> 0x0099 }
            r3 = 1
            if (r1 >= r2) goto L_0x0063
            java.io.File r2 = r0.getCleanFile(r1)     // Catch:{ all -> 0x0099 }
            boolean r4 = r2.exists()     // Catch:{ all -> 0x0099 }
            if (r4 == 0) goto L_0x0048
            boolean r4 = r2.delete()     // Catch:{ all -> 0x0099 }
            if (r4 == 0) goto L_0x0031
            goto L_0x0048
        L_0x0031:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x0099 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0099 }
            r4.<init>()     // Catch:{ all -> 0x0099 }
            java.lang.String r5 = "failed to delete "
            r4.append(r5)     // Catch:{ all -> 0x0099 }
            r4.append(r2)     // Catch:{ all -> 0x0099 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0099 }
            r3.<init>(r4)     // Catch:{ all -> 0x0099 }
            throw r3     // Catch:{ all -> 0x0099 }
        L_0x0048:
            long r4 = r8.size     // Catch:{ all -> 0x0099 }
            long[] r6 = r0.lengths     // Catch:{ all -> 0x0099 }
            r6 = r6[r1]     // Catch:{ all -> 0x0099 }
            long r4 = r4 - r6
            r8.size = r4     // Catch:{ all -> 0x0099 }
            int r4 = r8.fileCount     // Catch:{ all -> 0x0099 }
            int r4 = r4 - r3
            r8.fileCount = r4     // Catch:{ all -> 0x0099 }
            long[] r3 = r0.lengths     // Catch:{ all -> 0x0099 }
            r4 = 0
            r3[r1] = r4     // Catch:{ all -> 0x0099 }
            int r1 = r1 + 1
            goto L_0x001b
        L_0x0063:
            int r1 = r8.redundantOpCount     // Catch:{ all -> 0x0099 }
            int r1 = r1 + r3
            r8.redundantOpCount = r1     // Catch:{ all -> 0x0099 }
            java.io.Writer r1 = r8.journalWriter     // Catch:{ all -> 0x0099 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0099 }
            r2.<init>()     // Catch:{ all -> 0x0099 }
            java.lang.String r4 = "REMOVE "
            r2.append(r4)     // Catch:{ all -> 0x0099 }
            r2.append(r9)     // Catch:{ all -> 0x0099 }
            r4 = 10
            r2.append(r4)     // Catch:{ all -> 0x0099 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0099 }
            r1.append(r2)     // Catch:{ all -> 0x0099 }
            java.util.LinkedHashMap<java.lang.String, com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$Entry> r1 = r8.lruEntries     // Catch:{ all -> 0x0099 }
            r1.remove(r9)     // Catch:{ all -> 0x0099 }
            boolean r1 = r8.journalRebuildRequired()     // Catch:{ all -> 0x0099 }
            if (r1 == 0) goto L_0x0095
            java.util.concurrent.ThreadPoolExecutor r1 = r8.executorService     // Catch:{ all -> 0x0099 }
            java.util.concurrent.Callable<java.lang.Void> r2 = r8.cleanupCallable     // Catch:{ all -> 0x0099 }
            r1.submit(r2)     // Catch:{ all -> 0x0099 }
        L_0x0095:
            monitor-exit(r8)
            return r3
        L_0x0097:
            monitor-exit(r8)
            return r1
        L_0x0099:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.remove(java.lang.String):boolean");
    }

    public synchronized boolean isClosed() {
        return this.journalWriter == null;
    }

    private void checkNotClosed() {
        if (this.journalWriter == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void flush() throws IOException {
        checkNotClosed();
        trimToSize();
        trimToFileCount();
        this.journalWriter.flush();
    }

    public synchronized void close() throws IOException {
        if (this.journalWriter != null) {
            Iterator i$ = new ArrayList(this.lruEntries.values()).iterator();
            while (i$.hasNext()) {
                Entry entry = (Entry) i$.next();
                if (entry.currentEditor != null) {
                    entry.currentEditor.abort();
                }
            }
            trimToSize();
            trimToFileCount();
            this.journalWriter.close();
            this.journalWriter = null;
        }
    }

    /* access modifiers changed from: private */
    public void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            remove(this.lruEntries.entrySet().iterator().next().getKey());
        }
    }

    /* access modifiers changed from: private */
    public void trimToFileCount() throws IOException {
        while (this.fileCount > this.maxFileCount) {
            remove(this.lruEntries.entrySet().iterator().next().getKey());
        }
    }

    public void delete() throws IOException {
        close();
        Util.deleteContents(this.directory);
    }

    private void validateKey(String key) {
        if (!LEGAL_KEY_PATTERN.matcher(key).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + key + "\"");
        }
    }

    /* access modifiers changed from: private */
    public static String inputStreamToString(InputStream in) throws IOException {
        return Util.readFully(new InputStreamReader(in, Util.UTF_8));
    }

    public final class Snapshot implements Closeable {
        private File[] files;
        private final InputStream[] ins;
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;

        private Snapshot(String key2, long sequenceNumber2, File[] files2, InputStream[] ins2, long[] lengths2) {
            this.key = key2;
            this.sequenceNumber = sequenceNumber2;
            this.files = files2;
            this.ins = ins2;
            this.lengths = lengths2;
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public File getFile(int index) {
            return this.files[index];
        }

        public InputStream getInputStream(int index) {
            return this.ins[index];
        }

        public String getString(int index) throws IOException {
            return DiskLruCache.inputStreamToString(getInputStream(index));
        }

        public long getLength(int index) {
            return this.lengths[index];
        }

        public void close() {
            for (InputStream in : this.ins) {
                Util.closeQuietly(in);
            }
        }
    }

    public final class Editor {
        private boolean committed;
        /* access modifiers changed from: private */
        public final Entry entry;
        /* access modifiers changed from: private */
        public boolean hasErrors;
        /* access modifiers changed from: private */
        public final boolean[] written;

        private Editor(Entry entry2) {
            this.entry = entry2;
            this.written = entry2.readable ? null : new boolean[DiskLruCache.this.valueCount];
        }

        public InputStream newInputStream(int index) throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                } else if (!this.entry.readable) {
                    return null;
                } else {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(this.entry.getCleanFile(index));
                        return fileInputStream;
                    } catch (FileNotFoundException e) {
                        return null;
                    }
                }
            }
        }

        public String getString(int index) throws IOException {
            InputStream in = newInputStream(index);
            if (in != null) {
                return DiskLruCache.inputStreamToString(in);
            }
            return null;
        }

        public OutputStream newOutputStream(int index) throws IOException {
            FileOutputStream outputStream;
            FaultHidingOutputStream faultHidingOutputStream;
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor == this) {
                    if (!this.entry.readable) {
                        this.written[index] = true;
                    }
                    File dirtyFile = this.entry.getDirtyFile(index);
                    try {
                        outputStream = new FileOutputStream(dirtyFile);
                    } catch (FileNotFoundException e) {
                        DiskLruCache.this.directory.mkdirs();
                        try {
                            outputStream = new FileOutputStream(dirtyFile);
                        } catch (FileNotFoundException e2) {
                            return DiskLruCache.NULL_OUTPUT_STREAM;
                        }
                    }
                    faultHidingOutputStream = new FaultHidingOutputStream(outputStream);
                } else {
                    throw new IllegalStateException();
                }
            }
            return faultHidingOutputStream;
        }

        public void set(int index, String value) throws IOException {
            Writer writer = null;
            try {
                writer = new OutputStreamWriter(newOutputStream(index), Util.UTF_8);
                writer.write(value);
            } finally {
                Util.closeQuietly(writer);
            }
        }

        public void commit() throws IOException {
            if (this.hasErrors) {
                DiskLruCache.this.completeEdit(this, false);
                DiskLruCache.this.remove(this.entry.key);
            } else {
                DiskLruCache.this.completeEdit(this, true);
            }
            this.committed = true;
        }

        public void abort() throws IOException {
            DiskLruCache.this.completeEdit(this, false);
        }

        public void abortUnlessCommitted() {
            if (!this.committed) {
                try {
                    abort();
                } catch (IOException e) {
                }
            }
        }

        private class FaultHidingOutputStream extends FilterOutputStream {
            private FaultHidingOutputStream(OutputStream out) {
                super(out);
            }

            public void write(int oneByte) {
                try {
                    this.out.write(oneByte);
                } catch (IOException e) {
                    boolean unused = Editor.this.hasErrors = true;
                }
            }

            public void write(byte[] buffer, int offset, int length) {
                try {
                    this.out.write(buffer, offset, length);
                } catch (IOException e) {
                    boolean unused = Editor.this.hasErrors = true;
                }
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    boolean unused = Editor.this.hasErrors = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    boolean unused = Editor.this.hasErrors = true;
                }
            }
        }
    }

    private final class Entry {
        /* access modifiers changed from: private */
        public Editor currentEditor;
        /* access modifiers changed from: private */
        public final String key;
        /* access modifiers changed from: private */
        public final long[] lengths;
        /* access modifiers changed from: private */
        public boolean readable;
        /* access modifiers changed from: private */
        public long sequenceNumber;

        private Entry(String key2) {
            this.key = key2;
            this.lengths = new long[DiskLruCache.this.valueCount];
        }

        public String getLengths() throws IOException {
            StringBuilder result = new StringBuilder();
            for (long size : this.lengths) {
                result.append(' ');
                result.append(size);
            }
            return result.toString();
        }

        /* access modifiers changed from: private */
        public void setLengths(String[] strings) throws IOException {
            if (strings.length == DiskLruCache.this.valueCount) {
                int i = 0;
                while (i < strings.length) {
                    try {
                        this.lengths[i] = Long.parseLong(strings[i]);
                        i++;
                    } catch (NumberFormatException e) {
                        throw invalidLengths(strings);
                    }
                }
                return;
            }
            throw invalidLengths(strings);
        }

        private IOException invalidLengths(String[] strings) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strings));
        }

        public File getCleanFile(int i) {
            File access$2000 = DiskLruCache.this.directory;
            return new File(access$2000, this.key + "" + i);
        }

        public File getDirtyFile(int i) {
            File access$2000 = DiskLruCache.this.directory;
            return new File(access$2000, this.key + "" + i + ".tmp");
        }
    }
}
