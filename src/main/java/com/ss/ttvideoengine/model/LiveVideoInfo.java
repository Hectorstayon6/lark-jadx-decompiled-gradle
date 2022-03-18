package com.ss.ttvideoengine.model;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONObject;

public class LiveVideoInfo {
    public String mBackupUrl;
    public String mMainUrl;
    public String[] mURLs;

    public void extractFields(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        String optString = jSONObject.optString("main_play_url");
        this.mMainUrl = optString;
        if (!TextUtils.isEmpty(optString)) {
            arrayList.add(this.mMainUrl);
        }
        String optString2 = jSONObject.optString("backup_play_url");
        this.mBackupUrl = optString2;
        if (!TextUtils.isEmpty(optString2)) {
            arrayList.add(this.mBackupUrl);
        }
        String[] strArr = new String[arrayList.size()];
        this.mURLs = strArr;
        arrayList.toArray(strArr);
    }
}
