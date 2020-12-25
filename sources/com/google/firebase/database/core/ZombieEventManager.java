package com.google.firebase.database.core;

import com.google.firebase.database.core.view.QuerySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ZombieEventManager implements EventRegistrationZombieListener {
    private static ZombieEventManager defaultInstance = new ZombieEventManager();
    final HashMap<EventRegistration, List<EventRegistration>> globalEventRegistrations = new HashMap<>();

    private ZombieEventManager() {
    }

    public static ZombieEventManager getInstance() {
        return defaultInstance;
    }

    public void recordEventRegistration(EventRegistration registration) {
        synchronized (this.globalEventRegistrations) {
            List<EventRegistration> registrationList = this.globalEventRegistrations.get(registration);
            if (registrationList == null) {
                registrationList = new ArrayList<>();
                this.globalEventRegistrations.put(registration, registrationList);
            }
            registrationList.add(registration);
            if (!registration.getQuerySpec().isDefault()) {
                EventRegistration defaultRegistration = registration.clone(QuerySpec.defaultQueryAtPath(registration.getQuerySpec().getPath()));
                List<EventRegistration> registrationList2 = this.globalEventRegistrations.get(defaultRegistration);
                if (registrationList2 == null) {
                    registrationList2 = new ArrayList<>();
                    this.globalEventRegistrations.put(defaultRegistration, registrationList2);
                }
                registrationList2.add(registration);
            }
            registration.setIsUserInitiated(true);
            registration.setOnZombied(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0078 A[EDGE_INSN: B:42:0x0078->B:32:0x0078 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void unRecordEventRegistration(com.google.firebase.database.core.EventRegistration r7) {
        /*
            r6 = this;
            java.util.HashMap<com.google.firebase.database.core.EventRegistration, java.util.List<com.google.firebase.database.core.EventRegistration>> r0 = r6.globalEventRegistrations
            monitor-enter(r0)
            r1 = 0
            java.util.HashMap<com.google.firebase.database.core.EventRegistration, java.util.List<com.google.firebase.database.core.EventRegistration>> r2 = r6.globalEventRegistrations     // Catch:{ all -> 0x0085 }
            java.lang.Object r2 = r2.get(r7)     // Catch:{ all -> 0x0085 }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x0085 }
            r3 = 0
            if (r2 == 0) goto L_0x002f
            r4 = r3
        L_0x0010:
            int r5 = r2.size()     // Catch:{ all -> 0x0085 }
            if (r4 >= r5) goto L_0x0024
            java.lang.Object r5 = r2.get(r4)     // Catch:{ all -> 0x0085 }
            if (r5 != r7) goto L_0x0021
            r1 = 1
            r2.remove(r4)     // Catch:{ all -> 0x0085 }
            goto L_0x0024
        L_0x0021:
            int r4 = r4 + 1
            goto L_0x0010
        L_0x0024:
            boolean r4 = r2.isEmpty()     // Catch:{ all -> 0x0085 }
            if (r4 == 0) goto L_0x002f
            java.util.HashMap<com.google.firebase.database.core.EventRegistration, java.util.List<com.google.firebase.database.core.EventRegistration>> r4 = r6.globalEventRegistrations     // Catch:{ all -> 0x0085 }
            r4.remove(r7)     // Catch:{ all -> 0x0085 }
        L_0x002f:
            if (r1 != 0) goto L_0x003a
            boolean r4 = r7.isUserInitiated()     // Catch:{ all -> 0x0085 }
            if (r4 != 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r4 = r3
            goto L_0x003b
        L_0x003a:
            r4 = 1
        L_0x003b:
            com.google.firebase.database.core.utilities.Utilities.hardAssert(r4)     // Catch:{ all -> 0x0085 }
            com.google.firebase.database.core.view.QuerySpec r4 = r7.getQuerySpec()     // Catch:{ all -> 0x0085 }
            boolean r4 = r4.isDefault()     // Catch:{ all -> 0x0085 }
            if (r4 != 0) goto L_0x0083
            com.google.firebase.database.core.view.QuerySpec r4 = r7.getQuerySpec()     // Catch:{ all -> 0x0085 }
            com.google.firebase.database.core.Path r4 = r4.getPath()     // Catch:{ all -> 0x0085 }
            com.google.firebase.database.core.view.QuerySpec r4 = com.google.firebase.database.core.view.QuerySpec.defaultQueryAtPath(r4)     // Catch:{ all -> 0x0085 }
            com.google.firebase.database.core.EventRegistration r4 = r7.clone(r4)     // Catch:{ all -> 0x0085 }
            java.util.HashMap<com.google.firebase.database.core.EventRegistration, java.util.List<com.google.firebase.database.core.EventRegistration>> r5 = r6.globalEventRegistrations     // Catch:{ all -> 0x0085 }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ all -> 0x0085 }
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x0085 }
            r2 = r5
            if (r2 == 0) goto L_0x0083
        L_0x0065:
            int r5 = r2.size()     // Catch:{ all -> 0x0085 }
            if (r3 >= r5) goto L_0x0078
            java.lang.Object r5 = r2.get(r3)     // Catch:{ all -> 0x0085 }
            if (r5 != r7) goto L_0x0075
            r2.remove(r3)     // Catch:{ all -> 0x0085 }
            goto L_0x0078
        L_0x0075:
            int r3 = r3 + 1
            goto L_0x0065
        L_0x0078:
            boolean r3 = r2.isEmpty()     // Catch:{ all -> 0x0085 }
            if (r3 == 0) goto L_0x0083
            java.util.HashMap<com.google.firebase.database.core.EventRegistration, java.util.List<com.google.firebase.database.core.EventRegistration>> r3 = r6.globalEventRegistrations     // Catch:{ all -> 0x0085 }
            r3.remove(r4)     // Catch:{ all -> 0x0085 }
        L_0x0083:
            monitor-exit(r0)     // Catch:{ all -> 0x0085 }
            return
        L_0x0085:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0085 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.core.ZombieEventManager.unRecordEventRegistration(com.google.firebase.database.core.EventRegistration):void");
    }

    public void zombifyForRemove(EventRegistration registration) {
        synchronized (this.globalEventRegistrations) {
            List<EventRegistration> registrationList = this.globalEventRegistrations.get(registration);
            if (registrationList != null && !registrationList.isEmpty()) {
                if (registration.getQuerySpec().isDefault()) {
                    HashSet<QuerySpec> zombiedQueries = new HashSet<>();
                    for (int i = registrationList.size() - 1; i >= 0; i--) {
                        EventRegistration currentRegistration = registrationList.get(i);
                        if (!zombiedQueries.contains(currentRegistration.getQuerySpec())) {
                            zombiedQueries.add(currentRegistration.getQuerySpec());
                            currentRegistration.zombify();
                        }
                    }
                } else {
                    registrationList.get(0).zombify();
                }
            }
        }
    }

    public void onZombied(EventRegistration zombiedInstance) {
        unRecordEventRegistration(zombiedInstance);
    }
}
