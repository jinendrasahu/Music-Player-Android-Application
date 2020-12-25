package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IGmsServiceBroker extends IInterface {
    void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest) throws RemoteException;

    public static abstract class Stub extends Binder implements IGmsServiceBroker {
        public Stub() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        private static class zza implements IGmsServiceBroker {
            private final IBinder zza;

            zza(IBinder iBinder) {
                this.zza = iBinder;
            }

            public final IBinder asBinder() {
                return this.zza;
            }

            public final void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(iGmsCallbacks != null ? iGmsCallbacks.asBinder() : null);
                    if (getServiceRequest != null) {
                        obtain.writeInt(1);
                        getServiceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zza.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX WARNING: type inference failed for: r1v2, types: [android.os.IInterface] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 16777215(0xffffff, float:2.3509886E-38)
                if (r4 <= r0) goto L_0x000a
                boolean r4 = super.onTransact(r4, r5, r6, r7)
                return r4
            L_0x000a:
                java.lang.String r7 = "com.google.android.gms.common.internal.IGmsServiceBroker"
                r5.enforceInterface(r7)
                android.os.IBinder r7 = r5.readStrongBinder()
                r0 = 0
                if (r7 != 0) goto L_0x0018
                r7 = r0
                goto L_0x002c
            L_0x0018:
                java.lang.String r1 = "com.google.android.gms.common.internal.IGmsCallbacks"
                android.os.IInterface r1 = r7.queryLocalInterface(r1)
                boolean r2 = r1 instanceof com.google.android.gms.common.internal.IGmsCallbacks
                if (r2 == 0) goto L_0x0026
                r7 = r1
                com.google.android.gms.common.internal.IGmsCallbacks r7 = (com.google.android.gms.common.internal.IGmsCallbacks) r7
                goto L_0x002c
            L_0x0026:
                com.google.android.gms.common.internal.zzl r1 = new com.google.android.gms.common.internal.zzl
                r1.<init>(r7)
                r7 = r1
            L_0x002c:
                r1 = 46
                r2 = 1
                if (r4 != r1) goto L_0x004a
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x0042
                android.os.Parcelable$Creator<com.google.android.gms.common.internal.GetServiceRequest> r4 = com.google.android.gms.common.internal.GetServiceRequest.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r0 = r4
                com.google.android.gms.common.internal.GetServiceRequest r0 = (com.google.android.gms.common.internal.GetServiceRequest) r0
            L_0x0042:
                r3.getService(r7, r0)
                r6.writeNoException()
                return r2
            L_0x004a:
                r6 = 47
                if (r4 != r6) goto L_0x005f
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x0059
                android.os.Parcelable$Creator<com.google.android.gms.common.internal.zzr> r4 = com.google.android.gms.common.internal.zzr.CREATOR
                r4.createFromParcel(r5)
            L_0x0059:
                java.lang.UnsupportedOperationException r4 = new java.lang.UnsupportedOperationException
                r4.<init>()
                throw r4
            L_0x005f:
                r5.readInt()
                r6 = 4
                if (r4 == r6) goto L_0x0068
                r5.readString()
            L_0x0068:
                if (r4 == r2) goto L_0x00e8
                r6 = 2
                if (r4 == r6) goto L_0x00dc
                r6 = 23
                if (r4 == r6) goto L_0x00dc
                r6 = 25
                if (r4 == r6) goto L_0x00dc
                r6 = 27
                if (r4 == r6) goto L_0x00dc
                r6 = 30
                if (r4 == r6) goto L_0x00ca
                r6 = 34
                if (r4 == r6) goto L_0x00c6
                r6 = 41
                if (r4 == r6) goto L_0x00dc
                r6 = 43
                if (r4 == r6) goto L_0x00dc
                r6 = 37
                if (r4 == r6) goto L_0x00dc
                r6 = 38
                if (r4 == r6) goto L_0x00dc
                switch(r4) {
                    case 5: goto L_0x00dc;
                    case 6: goto L_0x00dc;
                    case 7: goto L_0x00dc;
                    case 8: goto L_0x00dc;
                    case 9: goto L_0x00ab;
                    case 10: goto L_0x00a4;
                    case 11: goto L_0x00dc;
                    case 12: goto L_0x00dc;
                    case 13: goto L_0x00dc;
                    case 14: goto L_0x00dc;
                    case 15: goto L_0x00dc;
                    case 16: goto L_0x00dc;
                    case 17: goto L_0x00dc;
                    case 18: goto L_0x00dc;
                    case 19: goto L_0x0095;
                    case 20: goto L_0x00ca;
                    default: goto L_0x0094;
                }
            L_0x0094:
                goto L_0x00fc
            L_0x0095:
                r5.readStrongBinder()
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x00fc
                android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
                r4.createFromParcel(r5)
                goto L_0x00fc
            L_0x00a4:
                r5.readString()
                r5.createStringArray()
                goto L_0x00fc
            L_0x00ab:
                r5.readString()
                r5.createStringArray()
                r5.readString()
                r5.readStrongBinder()
                r5.readString()
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x00fc
                android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
                r4.createFromParcel(r5)
                goto L_0x00fc
            L_0x00c6:
                r5.readString()
                goto L_0x00fc
            L_0x00ca:
                r5.createStringArray()
                r5.readString()
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x00fc
                android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
                r4.createFromParcel(r5)
                goto L_0x00fc
            L_0x00dc:
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x00fc
                android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
                r4.createFromParcel(r5)
                goto L_0x00fc
            L_0x00e8:
                r5.readString()
                r5.createStringArray()
                r5.readString()
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x00fc
                android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
                r4.createFromParcel(r5)
            L_0x00fc:
                java.lang.UnsupportedOperationException r4 = new java.lang.UnsupportedOperationException
                r4.<init>()
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.IGmsServiceBroker.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }
}
