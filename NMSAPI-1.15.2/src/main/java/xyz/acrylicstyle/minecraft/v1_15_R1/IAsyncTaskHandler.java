package xyz.acrylicstyle.minecraft.v1_15_R1;

import com.google.common.util.concurrent.ListenableFuture;

public interface IAsyncTaskHandler {
    ListenableFuture<Object> postToMainThread(Runnable paramRunnable);

    boolean isMainThread();

    Object getHandle();
}
