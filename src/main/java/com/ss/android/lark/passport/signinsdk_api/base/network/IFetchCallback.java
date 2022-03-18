package com.ss.android.lark.passport.signinsdk_api.base.network;

import com.ss.android.lark.passport.signinsdk_api.base.NetworkErrorResult;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/base/network/IFetchCallback;", "", "onError", "", "passportError", "Lcom/ss/android/lark/passport/signinsdk_api/base/NetworkErrorResult;", "onSuccess", "result", "Lcom/ss/android/lark/passport/signinsdk_api/base/network/RequestResult;", "signinsdk-api_release"}, mo238835k = 1, mv = {1, 1, 16})
/* renamed from: com.ss.android.lark.passport.signinsdk_api.base.network.c */
public interface IFetchCallback {
    /* renamed from: a */
    void mo171362a(NetworkErrorResult networkErrorResult);

    /* renamed from: a */
    void mo171363a(RequestResult fVar);
}
