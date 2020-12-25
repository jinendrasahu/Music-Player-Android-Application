package com.google.firebase.storage;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.DeleteNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;

class DeleteStorageTask implements Runnable {
    private static final String TAG = "DeleteStorageTask";
    private TaskCompletionSource<Void> mPendingResult;
    private ExponentialBackoffSender mSender;
    private StorageReference mStorageRef;

    public DeleteStorageTask(StorageReference storageRef, TaskCompletionSource<Void> pendingResult) {
        Preconditions.checkNotNull(storageRef);
        Preconditions.checkNotNull(pendingResult);
        this.mStorageRef = storageRef;
        this.mPendingResult = pendingResult;
        FirebaseStorage storage = this.mStorageRef.getStorage();
        this.mSender = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), storage.getAuthProvider(), storage.getMaxDownloadRetryTimeMillis());
    }

    public void run() {
        NetworkRequest request = new DeleteNetworkRequest(this.mStorageRef.getStorageUri(), this.mStorageRef.getApp());
        this.mSender.sendWithExponentialBackoff(request);
        request.completeTask(this.mPendingResult, null);
    }
}
