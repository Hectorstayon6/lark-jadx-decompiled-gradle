package com.ss.android.lark.mm.push;

import com.google.firebase.messaging.Constants;
import com.ss.android.lark.mm.module.record.model.MmRecordSentence;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/mm/push/IPushRecordSubtitleListener;", "", "onPushRecordSubtitle", "", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Lcom/ss/android/lark/mm/module/record/model/MmRecordSentence;", "mm_release"}, mo238835k = 1, mv = {1, 1, 16})
/* renamed from: com.ss.android.lark.mm.d.b */
public interface IPushRecordSubtitleListener {
    /* renamed from: a */
    void mo161192a(MmRecordSentence mmRecordSentence);
}
