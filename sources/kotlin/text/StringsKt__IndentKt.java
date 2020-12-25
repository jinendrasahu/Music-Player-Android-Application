package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\b¢\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\u0002*\u00020\u0002\u001a\u0014\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002¨\u0006\u0015"}, d2 = {"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, xi = 1, xs = "kotlin/text/StringsKt")
/* compiled from: Indent.kt */
class StringsKt__IndentKt {
    public static /* synthetic */ String trimMargin$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return StringsKt.trimMargin(str, str2);
    }

    public static final String trimMargin(String $this$trimMargin, String marginPrefix) {
        Intrinsics.checkParameterIsNotNull($this$trimMargin, "$this$trimMargin");
        Intrinsics.checkParameterIsNotNull(marginPrefix, "marginPrefix");
        return StringsKt.replaceIndentByMargin($this$trimMargin, "", marginPrefix);
    }

    public static /* synthetic */ String replaceIndentByMargin$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        if ((i & 2) != 0) {
            str3 = "|";
        }
        return StringsKt.replaceIndentByMargin(str, str2, str3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0101, code lost:
        r0 = (java.lang.String) r12.invoke(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String replaceIndentByMargin(java.lang.String r36, java.lang.String r37, java.lang.String r38) {
        /*
            r0 = r36
            r7 = r38
            java.lang.String r1 = "$this$replaceIndentByMargin"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r1)
            java.lang.String r1 = "newIndent"
            r8 = r37
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r1)
            java.lang.String r1 = "marginPrefix"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r1)
            r1 = r7
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x0156
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.util.List r9 = kotlin.text.StringsKt.lines(r1)
            int r1 = r36.length()
            int r2 = r37.length()
            int r3 = r9.size()
            int r2 = r2 * r3
            int r10 = r1 + r2
            kotlin.jvm.functions.Function1 r1 = getIndentFunction$StringsKt__IndentKt(r37)
            r11 = r9
            r12 = r1
            r13 = 0
            int r14 = kotlin.collections.CollectionsKt.getLastIndex(r11)
            r15 = r11
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            r16 = 0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            r17 = r15
            r6 = r1
            r18 = 0
            r19 = r17
            r20 = 0
            r1 = 0
            java.util.Iterator r21 = r19.iterator()
        L_0x005f:
            boolean r2 = r21.hasNext()
            if (r2 == 0) goto L_0x0122
            java.lang.Object r22 = r21.next()
            int r23 = r1 + 1
            if (r1 >= 0) goto L_0x0070
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0070:
            r24 = r1
            r25 = r22
            r26 = 0
            r27 = r25
            java.lang.String r27 = (java.lang.String) r27
            r5 = r24
            r28 = 0
            r29 = 0
            if (r5 == 0) goto L_0x0084
            if (r5 != r14) goto L_0x0091
        L_0x0084:
            r1 = r27
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            if (r1 == 0) goto L_0x0091
            r7 = r6
            goto L_0x010e
        L_0x0091:
            r4 = r27
            r30 = 0
            r1 = r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 0
            int r3 = r1.length()
            r0 = 0
        L_0x009e:
            r31 = r2
            r2 = -1
            if (r0 >= r3) goto L_0x00b8
            char r32 = r1.charAt(r0)
            r33 = 0
            boolean r34 = kotlin.text.CharsKt.isWhitespace(r32)
            r32 = r34 ^ 1
            if (r32 == 0) goto L_0x00b2
            goto L_0x00b9
        L_0x00b2:
            int r0 = r0 + 1
            r2 = r31
            goto L_0x009e
        L_0x00b8:
            r0 = r2
        L_0x00b9:
            if (r0 != r2) goto L_0x00c4
            r2 = r4
            r31 = r5
            r7 = r6
            r1 = r29
            goto L_0x00fe
        L_0x00c4:
            r31 = 0
            r32 = 4
            r33 = 0
            r1 = r4
            r2 = r38
            r3 = r0
            r35 = r4
            r4 = r31
            r31 = r5
            r5 = r32
            r7 = r6
            r6 = r33
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r1, r2, r3, r4, r5, r6)
            if (r1 == 0) goto L_0x00fa
            int r1 = r38.length()
            int r1 = r1 + r0
            r2 = r35
            if (r2 == 0) goto L_0x00f2
            java.lang.String r1 = r2.substring(r1)
            java.lang.String r3 = "(this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
            goto L_0x00fe
        L_0x00f2:
            kotlin.TypeCastException r1 = new kotlin.TypeCastException
            java.lang.String r3 = "null cannot be cast to non-null type java.lang.String"
            r1.<init>(r3)
            throw r1
        L_0x00fa:
            r2 = r35
            r1 = r29
        L_0x00fe:
            if (r1 == 0) goto L_0x010c
            java.lang.Object r0 = r12.invoke(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x010c
            r29 = r0
            goto L_0x010e
        L_0x010c:
            r29 = r27
        L_0x010e:
            if (r29 == 0) goto L_0x0118
            r0 = r29
            r1 = 0
            r7.add(r0)
            goto L_0x0119
        L_0x0118:
        L_0x0119:
            r0 = r36
            r6 = r7
            r1 = r23
            r7 = r38
            goto L_0x005f
        L_0x0122:
            r7 = r6
            r0 = r7
            java.util.List r0 = (java.util.List) r0
            r15 = r0
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r10)
            r16 = r0
            java.lang.Appendable r16 = (java.lang.Appendable) r16
            java.lang.String r0 = "\n"
            r17 = r0
            java.lang.CharSequence r17 = (java.lang.CharSequence) r17
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 124(0x7c, float:1.74E-43)
            r24 = 0
            java.lang.Appendable r0 = kotlin.collections.CollectionsKt.joinTo$default(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            java.lang.StringBuilder r0 = (java.lang.StringBuilder) r0
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "mapIndexedNotNull { inde…\"\\n\")\n        .toString()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            return r0
        L_0x0156:
            r0 = 0
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "marginPrefix must be non-blank string."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__IndentKt.replaceIndentByMargin(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static final String trimIndent(String $this$trimIndent) {
        Intrinsics.checkParameterIsNotNull($this$trimIndent, "$this$trimIndent");
        return StringsKt.replaceIndent($this$trimIndent, "");
    }

    public static /* synthetic */ String replaceIndent$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        return StringsKt.replaceIndent(str, str2);
    }

    public static final String replaceIndent(String $this$replaceIndent, String newIndent) {
        String it$iv$iv$iv;
        String str = $this$replaceIndent;
        Intrinsics.checkParameterIsNotNull(str, "$this$replaceIndent");
        Intrinsics.checkParameterIsNotNull(newIndent, "newIndent");
        List $this$filter$iv = StringsKt.lines(str);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (!StringsKt.isBlank((String) element$iv$iv)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable<String> $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (String p1 : $this$map$iv) {
            destination$iv$iv2.add(Integer.valueOf(indentWidth$StringsKt__IndentKt(p1)));
        }
        Integer num = (Integer) CollectionsKt.min((List) destination$iv$iv2);
        int minCommonIndent = num != null ? num.intValue() : 0;
        int resultSizeEstimate$iv = $this$replaceIndent.length() + (newIndent.length() * $this$filter$iv.size());
        Function1 indentAddFunction$iv = getIndentFunction$StringsKt__IndentKt(newIndent);
        List $this$reindent$iv = $this$filter$iv;
        int lastIndex$iv = CollectionsKt.getLastIndex($this$reindent$iv);
        Collection destination$iv$iv$iv = new ArrayList();
        int index$iv$iv$iv$iv = 0;
        for (Object item$iv$iv$iv$iv : $this$reindent$iv) {
            int index$iv$iv$iv$iv2 = index$iv$iv$iv$iv + 1;
            if (index$iv$iv$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String value$iv = (String) item$iv$iv$iv$iv;
            int index$iv = index$iv$iv$iv$iv;
            if ((index$iv == 0 || index$iv == lastIndex$iv) && StringsKt.isBlank(value$iv)) {
                it$iv$iv$iv = null;
            } else {
                int i = index$iv;
                String line = StringsKt.drop(value$iv, minCommonIndent);
                if (line == null || (it$iv$iv$iv = (String) indentAddFunction$iv.invoke(line)) == null) {
                    it$iv$iv$iv = value$iv;
                }
            }
            if (it$iv$iv$iv != null) {
                destination$iv$iv$iv.add(it$iv$iv$iv);
            }
            String str2 = $this$replaceIndent;
            index$iv$iv$iv$iv = index$iv$iv$iv$iv2;
        }
        String sb = ((StringBuilder) CollectionsKt.joinTo$default((List) destination$iv$iv$iv, new StringBuilder(resultSizeEstimate$iv), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null)).toString();
        Intrinsics.checkExpressionValueIsNotNull(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    public static /* synthetic */ String prependIndent$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "    ";
        }
        return StringsKt.prependIndent(str, str2);
    }

    public static final String prependIndent(String $this$prependIndent, String indent) {
        Intrinsics.checkParameterIsNotNull($this$prependIndent, "$this$prependIndent");
        Intrinsics.checkParameterIsNotNull(indent, "indent");
        return SequencesKt.joinToString$default(SequencesKt.map(StringsKt.lineSequence($this$prependIndent), new StringsKt__IndentKt$prependIndent$1(indent)), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    private static final int indentWidth$StringsKt__IndentKt(String $this$indentWidth) {
        CharSequence $this$indexOfFirst$iv = $this$indentWidth;
        int length = $this$indexOfFirst$iv.length();
        int index$iv = 0;
        while (true) {
            if (index$iv >= length) {
                index$iv = -1;
                break;
            } else if ((CharsKt.isWhitespace($this$indexOfFirst$iv.charAt(index$iv)) ^ 1) != 0) {
                break;
            } else {
                index$iv++;
            }
        }
        int it = index$iv;
        return it == -1 ? $this$indentWidth.length() : it;
    }

    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(String indent) {
        if (indent.length() == 0) {
            return StringsKt__IndentKt$getIndentFunction$1.INSTANCE;
        }
        return new StringsKt__IndentKt$getIndentFunction$2(indent);
    }

    private static final String reindent$StringsKt__IndentKt(List<String> $this$reindent, int resultSizeEstimate, Function1<? super String, String> indentAddFunction, Function1<? super String, String> indentCutFunction) {
        int lastIndex;
        int $i$f$reindent$StringsKt__IndentKt = 0;
        int lastIndex2 = CollectionsKt.getLastIndex($this$reindent);
        Collection destination$iv$iv = new ArrayList();
        int index$iv$iv = 0;
        for (Object item$iv$iv$iv : $this$reindent) {
            int index$iv$iv$iv = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            Object value = (String) item$iv$iv$iv;
            int $i$f$reindent$StringsKt__IndentKt2 = $i$f$reindent$StringsKt__IndentKt;
            int index = index$iv$iv;
            if ((index == 0 || index == lastIndex2) && StringsKt.isBlank((CharSequence) value)) {
                lastIndex = lastIndex2;
                value = null;
                Function1<? super String, String> function1 = indentAddFunction;
            } else {
                int i = index;
                String invoke = indentCutFunction.invoke(value);
                if (invoke != null) {
                    lastIndex = lastIndex2;
                    String invoke2 = indentAddFunction.invoke(invoke);
                    if (invoke2 != null) {
                        value = invoke2;
                    }
                } else {
                    lastIndex = lastIndex2;
                    Function1<? super String, String> function12 = indentAddFunction;
                }
            }
            if (value != null) {
                destination$iv$iv.add(value);
            }
            index$iv$iv = index$iv$iv$iv;
            $i$f$reindent$StringsKt__IndentKt = $i$f$reindent$StringsKt__IndentKt2;
            lastIndex2 = lastIndex;
        }
        String sb = ((StringBuilder) CollectionsKt.joinTo$default((List) destination$iv$iv, new StringBuilder(resultSizeEstimate), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null)).toString();
        Intrinsics.checkExpressionValueIsNotNull(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }
}
