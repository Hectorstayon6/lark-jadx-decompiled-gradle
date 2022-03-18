package com.ss.android.lark.passport.signinsdk_api.interfaces;

import com.ss.android.lark.passport.signinsdk_api.entity.LoginSourceInfo;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/interfaces/ILoginSourceService;", "", "getLoginSource", "Lcom/ss/android/lark/passport/signinsdk_api/entity/LoginSourceInfo;", "resetLoginSource", "", "setLoginSource", "info", "signinsdk-api_release"}, mo238835k = 1, mv = {1, 1, 16})
/* renamed from: com.ss.android.lark.passport.signinsdk_api.interfaces.h */
public interface ILoginSourceService {
    LoginSourceInfo getLoginSource();

    void resetLoginSource();

    void setLoginSource(LoginSourceInfo loginSourceInfo);
}
