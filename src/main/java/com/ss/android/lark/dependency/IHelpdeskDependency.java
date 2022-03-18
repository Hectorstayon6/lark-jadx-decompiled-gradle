package com.ss.android.lark.dependency;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.chat.entity.helpdesk.KbTopExtendControl;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/dependency/IHelpdeskDependency;", "", "getKbTopExtendData", "", "targetId", "", "context", "getKbTopView", "Landroid/view/View;", "Landroid/content/Context;", "initRecycleViewData", "registerKbTopExtendControl", "listener", "Lcom/ss/android/lark/chat/entity/helpdesk/KbTopExtendControl;", "registerKbTopExtendPush", "unRegisterKbTopExtendPush", "im_chat_chat_productionUsRelease"}, mo238835k = 1, mv = {1, 1, 16})
/* renamed from: com.ss.android.lark.dependency.w */
public interface IHelpdeskDependency {
    /* renamed from: a */
    View mo134725a(Context context);

    /* renamed from: a */
    void mo134726a();

    /* renamed from: a */
    void mo134727a(Context context, String str);

    /* renamed from: a */
    void mo134728a(KbTopExtendControl aVar, Context context);

    /* renamed from: a */
    void mo134729a(String str, String str2);

    /* renamed from: b */
    void mo134730b();
}
