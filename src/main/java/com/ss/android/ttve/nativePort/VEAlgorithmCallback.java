package com.ss.android.ttve.nativePort;

import com.ss.android.ttve.model.VEAlgorithmResult;

public interface VEAlgorithmCallback {
    void onFailed(int i);

    void onResult(VEAlgorithmResult vEAlgorithmResult);
}
