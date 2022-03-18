package com.huawei.hms.common.data;

import android.content.ContentValues;
import com.huawei.hms.common.data.DataHolder;
import java.util.HashMap;

final class DataHolderBuilderCreator extends DataHolder.Builder {
    @Override // com.huawei.hms.common.data.DataHolder.Builder
    public final DataHolder.Builder setDataForContentValuesHashMap(HashMap<String, Object> hashMap) {
        throw new UnsupportedOperationException("DataHolderBuilderCreator unsupported setDataForContentValuesHashMap");
    }

    @Override // com.huawei.hms.common.data.DataHolder.Builder
    public final DataHolder.Builder withRow(ContentValues contentValues) {
        throw new UnsupportedOperationException("DataHolderBuilderCreator unsupported withRow");
    }

    DataHolderBuilderCreator(String[] strArr, String str) {
        super(strArr, (String) null, (DataHolderBuilderCreator) null);
    }
}
