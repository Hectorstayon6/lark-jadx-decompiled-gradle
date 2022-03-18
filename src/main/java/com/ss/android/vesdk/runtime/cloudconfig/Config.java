package com.ss.android.vesdk.runtime.cloudconfig;

public class Config<T> {
    public final T defaultValue;
    public final String key;
    public final int type;

    public Config(String str, int i, T t) {
        this.key = str;
        this.type = i;
        this.defaultValue = t;
    }
}
