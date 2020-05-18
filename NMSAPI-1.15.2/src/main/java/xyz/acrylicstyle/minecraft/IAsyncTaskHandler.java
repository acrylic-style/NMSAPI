package xyz.acrylicstyle.minecraft;

import com.google.common.util.concurrent.ListenableFuture;

public interface IAsyncTaskHandler {
    ListenableFuture<Object> postToMainThread(Runnable paramRunnable);

    boolean isMainThread();

    Object getHandle();
}
