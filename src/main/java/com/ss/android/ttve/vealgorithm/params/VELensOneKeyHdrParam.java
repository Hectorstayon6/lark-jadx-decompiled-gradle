package com.ss.android.ttve.vealgorithm.params;

public class VELensOneKeyHdrParam extends VEAlgorithmParam {
    public boolean bUseHardwareDecoder;
    public int frameCount;
    public int frameSize;
    public String path;
    public int threadNum;

    public VELensOneKeyHdrParam() {
        this.type = VEAlgorithmType.VE_ALGORITHM_TYPE_ONE_KEY_HDR;
    }
}
