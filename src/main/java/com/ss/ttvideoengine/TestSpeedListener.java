package com.ss.ttvideoengine;

public interface TestSpeedListener {
    void onNotify(int i, long j, long j2, String str, String str2, String str3);

    void onNotify(int i, String str);

    void onNotifyGlobalSpeed(long j, long j2, int i);
}
