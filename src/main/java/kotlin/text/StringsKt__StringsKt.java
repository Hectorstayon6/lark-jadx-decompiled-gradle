package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.C69043h;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.C69294l;
import kotlin.sequences.Sequence;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u000e\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\rH\u0002\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0002\u001a\u0015\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\n\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a:\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001aE\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b\u001c\u001a:\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006\u001a4\u0010 \u001a\u0002H!\"\f\b\u0000\u0010\"*\u00020\u0002*\u0002H!\"\u0004\b\u0001\u0010!*\u0002H\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$H\b¢\u0006\u0002\u0010%\u001a4\u0010&\u001a\u0002H!\"\f\b\u0000\u0010\"*\u00020\u0002*\u0002H!\"\u0004\b\u0001\u0010!*\u0002H\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$H\b¢\u0006\u0002\u0010%\u001a&\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a;\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b)\u001a&\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010+\u001a\u00020\u0006*\u00020\u00022\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u0010+\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\r\u0010.\u001a\u00020\r*\u00020\u0002H\b\u001a\r\u0010/\u001a\u00020\r*\u00020\u0002H\b\u001a\r\u00100\u001a\u00020\r*\u00020\u0002H\b\u001a \u00101\u001a\u00020\r*\u0004\u0018\u00010\u0002H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u00102\u001a\u00020\r*\u0004\u0018\u00010\u0002H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u00103\u001a\u000204*\u00020\u0002H\u0002\u001a&\u00105\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u00105\u001a\u00020\u0006*\u00020\u00022\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u00106\u001a\u00020\u0006*\u00020\u00022\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u00106\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0010\u00107\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u0002\u001a\u0010\u00109\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u0002\u001a\u0015\u0010;\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\f\u001a\u000f\u0010<\u001a\u00020\n*\u0004\u0018\u00010\nH\b\u001a\u001c\u0010=\u001a\u00020\u0002*\u00020\u00022\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010=\u001a\u00020\n*\u00020\n2\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010@\u001a\u00020\u0002*\u00020\u00022\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010@\u001a\u00020\n*\u00020\n2\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001aG\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000108*\u00020\u00022\u000e\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010F\u001a=\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000108*\u00020\u00022\u0006\u0010B\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0002\bE\u001a4\u0010G\u001a\u00020\r*\u00020\u00022\u0006\u0010H\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010I\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u0012\u0010J\u001a\u00020\u0002*\u00020\u00022\u0006\u0010K\u001a\u00020\u0002\u001a\u0012\u0010J\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\u0002\u001a\u001a\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006\u001a\u0012\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u001d\u0010L\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\b\u001a\u0015\u0010L\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u0001H\b\u001a\u0012\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010N\u001a\u00020\n*\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a+\u0010Q\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0014\b\b\u0010R\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\u00020SH\b\u001a\u001d\u0010Q\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\nH\b\u001a$\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010X\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010X\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Y\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Y\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Z\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Z\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001d\u0010[\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\nH\b\u001a\"\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0002\u001a\u001a\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u0002\u001a%\u0010\\\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0002H\b\u001a\u001d\u0010\\\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u0002H\b\u001a=\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006¢\u0006\u0002\u0010^\u001a0\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\n\u0010B\u001a\u00020-\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006\u001a/\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0006\u0010P\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0002\b_\u001a%\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010D\u001a\u00020\u0006H\b\u001a=\u0010`\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u00022\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006¢\u0006\u0002\u0010a\u001a0\u0010`\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u00022\n\u0010B\u001a\u00020-\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006\u001a\u001c\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a$\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u001d\u0010c\u001a\u00020\u0002*\u00020\n2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u0006H\b\u001a\u001f\u0010f\u001a\u00020\n*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u0006H\b\u001a\u0012\u0010f\u001a\u00020\n*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u0012\u0010f\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u0001\u001a\u001c\u0010g\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010g\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010h\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010h\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010i\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010i\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010j\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010j\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\n\u0010k\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010k\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010k\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010k\u001a\u00020\n*\u00020\nH\b\u001a!\u0010k\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010k\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\n\u0010m\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010m\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010m\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010m\u001a\u00020\n*\u00020\nH\b\u001a!\u0010m\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010m\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\n\u0010n\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010n\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010n\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010n\u001a\u00020\n*\u00020\nH\b\u001a!\u0010n\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010n\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006o"}, d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, mo238835k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/text/StringsKt")
public class StringsKt__StringsKt extends C69341v {
    private static final String orEmpty(String str) {
        return str != null ? str : "";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"kotlin/text/StringsKt__StringsKt$iterator$1", "Lkotlin/collections/CharIterator;", "index", "", "hasNext", "", "nextChar", "", "kotlin-stdlib"}, mo238835k = 1, mv = {1, 1, 16})
    /* renamed from: kotlin.text.StringsKt__StringsKt$a */
    public static final class C69316a extends CharIterator {

        /* renamed from: a */
        final /* synthetic */ CharSequence f173339a;

        /* renamed from: b */
        private int f173340b;

        @Override // kotlin.collections.CharIterator
        /* renamed from: b */
        public char mo239061b() {
            CharSequence charSequence = this.f173339a;
            int i = this.f173340b;
            this.f173340b = i + 1;
            return charSequence.charAt(i);
        }

        public boolean hasNext() {
            if (this.f173340b < this.f173339a.length()) {
                return true;
            }
            return false;
        }

        C69316a(CharSequence charSequence) {
            this.f173339a = charSequence;
        }
    }

    private static final boolean isNotBlank(CharSequence charSequence) {
        return !StringsKt.isBlank(charSequence);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lkotlin/ranges/IntRange;", "invoke"}, mo238835k = 3, mv = {1, 1, 16})
    /* renamed from: kotlin.text.StringsKt__StringsKt$d */
    static final class C69319d extends Lambda implements Function1<IntRange, String> {
        final /* synthetic */ CharSequence $this_splitToSequence;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C69319d(CharSequence charSequence) {
            super(1);
            this.$this_splitToSequence = charSequence;
        }

        public final String invoke(IntRange kVar) {
            Intrinsics.checkParameterIsNotNull(kVar, "it");
            return StringsKt.substring(this.$this_splitToSequence, kVar);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lkotlin/ranges/IntRange;", "invoke"}, mo238835k = 3, mv = {1, 1, 16})
    /* renamed from: kotlin.text.StringsKt__StringsKt$e */
    static final class C69320e extends Lambda implements Function1<IntRange, String> {
        final /* synthetic */ CharSequence $this_splitToSequence;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C69320e(CharSequence charSequence) {
            super(1);
            this.$this_splitToSequence = charSequence;
        }

        public final String invoke(IntRange kVar) {
            Intrinsics.checkParameterIsNotNull(kVar, "it");
            return StringsKt.substring(this.$this_splitToSequence, kVar);
        }
    }

    public static final int getLastIndex(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    private static final boolean isEmpty(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return true;
        }
        return false;
    }

    private static final boolean isNotEmpty(CharSequence charSequence) {
        if (charSequence.length() > 0) {
            return true;
        }
        return false;
    }

    private static final boolean isNullOrBlank(CharSequence charSequence) {
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return true;
        }
        return false;
    }

    private static final boolean isNullOrEmpty(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return true;
        }
        return false;
    }

    public static final CharIterator iterator(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$iterator");
        return new C69316a(charSequence);
    }

    public static final List<String> lines(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$lines");
        return C69294l.m266144h(StringsKt.lineSequence(charSequence));
    }

    public static final IntRange getIndices(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$indices");
        return new IntRange(0, charSequence.length() - 1);
    }

    public static final Sequence<String> lineSequence(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$lineSequence");
        return StringsKt.splitToSequence$default(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, (Object) null);
    }

    private static final String trim(String str) {
        if (str != null) {
            return StringsKt.trim((CharSequence) str).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    private static final String trimEnd(String str) {
        if (str != null) {
            return StringsKt.trimEnd((CharSequence) str).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    private static final String trimStart(String str) {
        if (str != null) {
            return StringsKt.trimStart((CharSequence) str).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final CharSequence trim(CharSequence charSequence) {
        int i;
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            if (!z) {
                i = i2;
            } else {
                i = length;
            }
            boolean a = C69321a.m266165a(charSequence.charAt(i));
            if (!z) {
                if (!a) {
                    z = true;
                } else {
                    i2++;
                }
            } else if (!a) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static final CharSequence trimEnd(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$trimEnd");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (C69321a.m266165a(charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }

    public static final CharSequence trimStart(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$trimStart");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!C69321a.m266165a(charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    private static final boolean matches(CharSequence charSequence, Regex regex) {
        return regex.matches(charSequence);
    }

    private static final boolean contains(CharSequence charSequence, Regex regex) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$contains");
        return regex.containsMatchIn(charSequence);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: C extends java.lang.CharSequence & R */
    /* JADX WARN: Multi-variable type inference failed */
    private static final <C extends CharSequence & R, R> R ifBlank(C c, Function0<? extends R> function0) {
        return StringsKt.isBlank(c) ? (R) function0.invoke() : c;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: C extends java.lang.CharSequence & R */
    /* JADX WARN: Multi-variable type inference failed */
    private static final <C extends CharSequence & R, R> R ifEmpty(C c, Function0<? extends R> function0) {
        boolean z;
        if (c.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        return z ? (R) function0.invoke() : c;
    }

    public static final CharSequence removeSurrounding(CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$removeSurrounding");
        Intrinsics.checkParameterIsNotNull(charSequence2, "delimiter");
        return StringsKt.removeSurrounding(charSequence, charSequence2, charSequence2);
    }

    /* access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"}, mo238835k = 3, mv = {1, 1, 16})
    /* renamed from: kotlin.text.StringsKt__StringsKt$b */
    public static final class C69317b extends Lambda implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
        final /* synthetic */ char[] $delimiters;
        final /* synthetic */ boolean $ignoreCase;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C69317b(char[] cArr, boolean z) {
            super(2);
            this.$delimiters = cArr;
            this.$ignoreCase = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return invoke(charSequence, num.intValue());
        }

        public final Pair<Integer, Integer> invoke(CharSequence charSequence, int i) {
            Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
            int indexOfAny = StringsKt.indexOfAny(charSequence, this.$delimiters, i, this.$ignoreCase);
            if (indexOfAny < 0) {
                return null;
            }
            return TuplesKt.to(Integer.valueOf(indexOfAny), 1);
        }
    }

    public static final String removeSurrounding(String str, CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(str, "$this$removeSurrounding");
        Intrinsics.checkParameterIsNotNull(charSequence, "delimiter");
        return StringsKt.removeSurrounding(str, charSequence, charSequence);
    }

    /* access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"}, mo238835k = 3, mv = {1, 1, 16})
    /* renamed from: kotlin.text.StringsKt__StringsKt$c */
    public static final class C69318c extends Lambda implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
        final /* synthetic */ List $delimitersList;
        final /* synthetic */ boolean $ignoreCase;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C69318c(List list, boolean z) {
            super(2);
            this.$delimitersList = list;
            this.$ignoreCase = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return invoke(charSequence, num.intValue());
        }

        public final Pair<Integer, Integer> invoke(CharSequence charSequence, int i) {
            Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
            Pair<Integer, String> findAnyOf$StringsKt__StringsKt = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt(charSequence, this.$delimitersList, i, this.$ignoreCase, false);
            if (findAnyOf$StringsKt__StringsKt != null) {
                return TuplesKt.to(findAnyOf$StringsKt__StringsKt.getFirst(), Integer.valueOf(findAnyOf$StringsKt__StringsKt.getSecond().length()));
            }
            return null;
        }
    }

    public static final boolean hasSurrogatePairAt(CharSequence charSequence, int i) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$hasSurrogatePairAt");
        int length = charSequence.length() - 2;
        if (i >= 0 && length >= i && Character.isHighSurrogate(charSequence.charAt(i)) && Character.isLowSurrogate(charSequence.charAt(i + 1))) {
            return true;
        }
        return false;
    }

    public static final CharSequence removePrefix(CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$removePrefix");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        if (StringsKt.startsWith$default(charSequence, charSequence2, false, 2, (Object) null)) {
            return charSequence.subSequence(charSequence2.length(), charSequence.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static final CharSequence removeRange(CharSequence charSequence, IntRange kVar) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$removeRange");
        Intrinsics.checkParameterIsNotNull(kVar, "range");
        return StringsKt.removeRange(charSequence, kVar.mo239377g().intValue(), kVar.mo239379i().intValue() + 1);
    }

    public static final CharSequence removeSuffix(CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$removeSuffix");
        Intrinsics.checkParameterIsNotNull(charSequence2, "suffix");
        if (StringsKt.endsWith$default(charSequence, charSequence2, false, 2, (Object) null)) {
            return charSequence.subSequence(0, charSequence.length() - charSequence2.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static final CharSequence subSequence(CharSequence charSequence, IntRange kVar) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$subSequence");
        Intrinsics.checkParameterIsNotNull(kVar, "range");
        return charSequence.subSequence(kVar.mo239377g().intValue(), kVar.mo239379i().intValue() + 1);
    }

    public static final String substring(CharSequence charSequence, IntRange kVar) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$substring");
        Intrinsics.checkParameterIsNotNull(kVar, "range");
        return charSequence.subSequence(kVar.mo239377g().intValue(), kVar.mo239379i().intValue() + 1).toString();
    }

    public static final String removePrefix(String str, CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(str, "$this$removePrefix");
        Intrinsics.checkParameterIsNotNull(charSequence, "prefix");
        if (!StringsKt.startsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static final String removeSuffix(String str, CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(str, "$this$removeSuffix");
        Intrinsics.checkParameterIsNotNull(charSequence, "suffix");
        if (!StringsKt.endsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - charSequence.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String substring(String str, IntRange kVar) {
        Intrinsics.checkParameterIsNotNull(str, "$this$substring");
        Intrinsics.checkParameterIsNotNull(kVar, "range");
        String substring = str.substring(kVar.mo239377g().intValue(), kVar.mo239379i().intValue() + 1);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final CharSequence trim(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        int i;
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$trim");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            if (!z) {
                i = i2;
            } else {
                i = length;
            }
            boolean booleanValue = function1.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue();
            if (!z) {
                if (!booleanValue) {
                    z = true;
                } else {
                    i2++;
                }
            } else if (!booleanValue) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static final CharSequence trimEnd(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$trimEnd");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (function1.invoke(Character.valueOf(charSequence.charAt(length))).booleanValue());
        return charSequence.subSequence(0, length + 1);
    }

    public static final CharSequence trimStart(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$trimStart");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!function1.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    private static final String removeRange(String str, IntRange kVar) {
        if (str != null) {
            return StringsKt.removeRange((CharSequence) str, kVar).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final CharSequence trim(CharSequence charSequence, char... cArr) {
        int i;
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$trim");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            if (!z) {
                i = i2;
            } else {
                i = length;
            }
            boolean a = C69043h.m265749a(cArr, charSequence.charAt(i));
            if (!z) {
                if (!a) {
                    z = true;
                } else {
                    i2++;
                }
            } else if (!a) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static final CharSequence trimEnd(CharSequence charSequence, char... cArr) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$trimEnd");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (C69043h.m265749a(cArr, charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }

    public static final CharSequence trimStart(CharSequence charSequence, char... cArr) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$trimStart");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!C69043h.m265749a(cArr, charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    public static final String trim(String str, Function1<? super Character, Boolean> function1) {
        int i;
        Intrinsics.checkParameterIsNotNull(str, "$this$trim");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        String str2 = str;
        int length = str2.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            if (!z) {
                i = i2;
            } else {
                i = length;
            }
            boolean booleanValue = function1.invoke(Character.valueOf(str2.charAt(i))).booleanValue();
            if (!z) {
                if (!booleanValue) {
                    z = true;
                } else {
                    i2++;
                }
            } else if (!booleanValue) {
                break;
            } else {
                length--;
            }
        }
        return str2.subSequence(i2, length + 1).toString();
    }

    public static final String trimEnd(String str, Function1<? super Character, Boolean> function1) {
        String str2;
        Intrinsics.checkParameterIsNotNull(str, "$this$trimEnd");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        String str3 = str;
        int length = str3.length();
        while (true) {
            length--;
            if (length >= 0) {
                if (!function1.invoke(Character.valueOf(str3.charAt(length))).booleanValue()) {
                    str2 = str3.subSequence(0, length + 1);
                    break;
                }
            } else {
                break;
            }
        }
        return str2.toString();
    }

    public static final String trimStart(String str, Function1<? super Character, Boolean> function1) {
        String str2;
        Intrinsics.checkParameterIsNotNull(str, "$this$trimStart");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        String str3 = str;
        int length = str3.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (!function1.invoke(Character.valueOf(str3.charAt(i))).booleanValue()) {
                str2 = str3.subSequence(i, str3.length());
                break;
            } else {
                i++;
            }
        }
        return str2.toString();
    }

    public static final String trim(String str, char... cArr) {
        int i;
        Intrinsics.checkParameterIsNotNull(str, "$this$trim");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        String str2 = str;
        int length = str2.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            if (!z) {
                i = i2;
            } else {
                i = length;
            }
            boolean a = C69043h.m265749a(cArr, str2.charAt(i));
            if (!z) {
                if (!a) {
                    z = true;
                } else {
                    i2++;
                }
            } else if (!a) {
                break;
            } else {
                length--;
            }
        }
        return str2.subSequence(i2, length + 1).toString();
    }

    public static final String trimEnd(String str, char... cArr) {
        String str2;
        Intrinsics.checkParameterIsNotNull(str, "$this$trimEnd");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        String str3 = str;
        int length = str3.length();
        while (true) {
            length--;
            if (length >= 0) {
                if (!C69043h.m265749a(cArr, str3.charAt(length))) {
                    str2 = str3.subSequence(0, length + 1);
                    break;
                }
            } else {
                break;
            }
        }
        return str2.toString();
    }

    public static final String trimStart(String str, char... cArr) {
        String str2;
        Intrinsics.checkParameterIsNotNull(str, "$this$trimStart");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        String str3 = str;
        int length = str3.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (!C69043h.m265749a(cArr, str3.charAt(i))) {
                str2 = str3.subSequence(i, str3.length());
                break;
            } else {
                i++;
            }
        }
        return str2.toString();
    }

    private static final String replace(CharSequence charSequence, Regex regex, String str) {
        return regex.replace(charSequence, str);
    }

    private static final String replaceFirst(CharSequence charSequence, Regex regex, String str) {
        return regex.replaceFirst(charSequence, str);
    }

    private static final List<String> split(CharSequence charSequence, Regex regex, int i) {
        return regex.split(charSequence, i);
    }

    @Deprecated(message = "Use parameters named startIndex and endIndex.", replaceWith = @ReplaceWith(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    private static final CharSequence subSequence(String str, int i, int i2) {
        return str.subSequence(i, i2);
    }

    public static final String padEnd(String str, int i, char c) {
        Intrinsics.checkParameterIsNotNull(str, "$this$padEnd");
        return StringsKt.padEnd((CharSequence) str, i, c).toString();
    }

    public static final String padStart(String str, int i, char c) {
        Intrinsics.checkParameterIsNotNull(str, "$this$padStart");
        return StringsKt.padStart((CharSequence) str, i, c).toString();
    }

    private static final String replace(CharSequence charSequence, Regex regex, Function1<? super MatchResult, ? extends CharSequence> function1) {
        return regex.replace(charSequence, function1);
    }

    private static final String substring(CharSequence charSequence, int i, int i2) {
        return charSequence.subSequence(i, i2).toString();
    }

    public static final boolean contains(CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$contains");
        if (StringsKt.indexOf$default(charSequence, c, 0, z, 2, (Object) null) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean endsWith(CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$endsWith");
        if (charSequence.length() <= 0 || !C69321a.m266166a(charSequence.charAt(StringsKt.getLastIndex(charSequence)), c, z)) {
            return false;
        }
        return true;
    }

    private static final String removeRange(String str, int i, int i2) {
        if (str != null) {
            return StringsKt.removeRange((CharSequence) str, i, i2).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final boolean startsWith(CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$startsWith");
        if (charSequence.length() <= 0 || !C69321a.m266166a(charSequence.charAt(0), c, z)) {
            return false;
        }
        return true;
    }

    public static final boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$contains");
        Intrinsics.checkParameterIsNotNull(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (StringsKt.indexOf$default(charSequence, (String) charSequence2, 0, z, 2, (Object) null) >= 0) {
                return true;
            }
        } else if (indexOf$StringsKt__StringsKt$default(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean endsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$endsWith");
        Intrinsics.checkParameterIsNotNull(charSequence2, "suffix");
        if (z || !(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            return StringsKt.regionMatchesImpl(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
        }
        return StringsKt.endsWith$default((String) charSequence, (String) charSequence2, false, 2, (Object) null);
    }

    public static final CharSequence replaceRange(CharSequence charSequence, IntRange kVar, CharSequence charSequence2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$replaceRange");
        Intrinsics.checkParameterIsNotNull(kVar, "range");
        Intrinsics.checkParameterIsNotNull(charSequence2, "replacement");
        return StringsKt.replaceRange(charSequence, kVar.mo239377g().intValue(), kVar.mo239379i().intValue() + 1, charSequence2);
    }

    public static final String substringAfter(String str, char c, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$substringAfter");
        Intrinsics.checkParameterIsNotNull(str2, "missingDelimiterValue");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(indexOf$default + 1, str.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String substringAfterLast(String str, char c, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$substringAfterLast");
        Intrinsics.checkParameterIsNotNull(str2, "missingDelimiterValue");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(lastIndexOf$default + 1, str.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String substringBefore(String str, char c, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$substringBefore");
        Intrinsics.checkParameterIsNotNull(str2, "missingDelimiterValue");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String substringBeforeLast(String str, char c, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$substringBeforeLast");
        Intrinsics.checkParameterIsNotNull(str2, "missingDelimiterValue");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(0, lastIndexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String commonPrefixWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$commonPrefixWith");
        Intrinsics.checkParameterIsNotNull(charSequence2, "other");
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i = 0;
        while (i < min && C69321a.m266166a(charSequence.charAt(i), charSequence2.charAt(i), z)) {
            i++;
        }
        int i2 = i - 1;
        if (StringsKt.hasSurrogatePairAt(charSequence, i2) || StringsKt.hasSurrogatePairAt(charSequence2, i2)) {
            i--;
        }
        return charSequence.subSequence(0, i).toString();
    }

    public static final String commonSuffixWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$commonSuffixWith");
        Intrinsics.checkParameterIsNotNull(charSequence2, "other");
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int min = Math.min(length, length2);
        int i = 0;
        while (i < min && C69321a.m266166a(charSequence.charAt((length - i) - 1), charSequence2.charAt((length2 - i) - 1), z)) {
            i++;
        }
        if (StringsKt.hasSurrogatePairAt(charSequence, (length - i) - 1) || StringsKt.hasSurrogatePairAt(charSequence2, (length2 - i) - 1)) {
            i--;
        }
        return charSequence.subSequence(length - i, length).toString();
    }

    public static final CharSequence padEnd(CharSequence charSequence, int i, char c) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$padEnd");
        if (i < 0) {
            throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
        } else if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(i);
            sb.append(charSequence);
            int length = i - charSequence.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c);
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            return sb;
        }
    }

    public static final CharSequence padStart(CharSequence charSequence, int i, char c) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$padStart");
        if (i < 0) {
            throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
        } else if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(i);
            int length = i - charSequence.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c);
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            sb.append(charSequence);
            return sb;
        }
    }

    public static final CharSequence removeRange(CharSequence charSequence, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$removeRange");
        if (i2 < i) {
            throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
        } else if (i2 == i) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(charSequence.length() - (i2 - i));
            sb.append(charSequence, 0, i);
            Intrinsics.checkExpressionValueIsNotNull(sb, "this.append(value, startIndex, endIndex)");
            sb.append(charSequence, i2, charSequence.length());
            Intrinsics.checkExpressionValueIsNotNull(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
    }

    public static final CharSequence removeSurrounding(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$removeSurrounding");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "suffix");
        if (charSequence.length() < charSequence2.length() + charSequence3.length() || !StringsKt.startsWith$default(charSequence, charSequence2, false, 2, (Object) null) || !StringsKt.endsWith$default(charSequence, charSequence3, false, 2, (Object) null)) {
            return charSequence.subSequence(0, charSequence.length());
        }
        return charSequence.subSequence(charSequence2.length(), charSequence.length() - charSequence3.length());
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$startsWith");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        if (z || !(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            return StringsKt.regionMatchesImpl(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
        }
        return StringsKt.startsWith$default((String) charSequence, (String) charSequence2, false, 2, (Object) null);
    }

    public static final String substringAfter(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "$this$substringAfter");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(indexOf$default + str2.length(), str.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String substringAfterLast(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "$this$substringAfterLast");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(lastIndexOf$default + str2.length(), str.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String substringBefore(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "$this$substringBefore");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String substringBeforeLast(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "$this$substringBeforeLast");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(0, lastIndexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String removeSurrounding(String str, CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$removeSurrounding");
        Intrinsics.checkParameterIsNotNull(charSequence, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence2, "suffix");
        if (str.length() < charSequence.length() + charSequence2.length()) {
            return str;
        }
        String str2 = str;
        if (!StringsKt.startsWith$default((CharSequence) str2, charSequence, false, 2, (Object) null) || !StringsKt.endsWith$default((CharSequence) str2, charSequence2, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    private static final String replaceRange(String str, IntRange kVar, CharSequence charSequence) {
        if (str != null) {
            return StringsKt.replaceRange((CharSequence) str, kVar, charSequence).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final Pair<Integer, String> findAnyOf(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$findAnyOf");
        Intrinsics.checkParameterIsNotNull(collection, "strings");
        return findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, false);
    }

    public static final Pair<Integer, String> findLastAnyOf(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$findLastAnyOf");
        Intrinsics.checkParameterIsNotNull(collection, "strings");
        return findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, true);
    }

    public static final int indexOf(CharSequence charSequence, char c, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$indexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c, i);
        }
        return StringsKt.indexOfAny(charSequence, new char[]{c}, i, z);
    }

    public static final int indexOfAny(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        Integer first;
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$indexOfAny");
        Intrinsics.checkParameterIsNotNull(collection, "strings");
        Pair<Integer, String> findAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, false);
        if (findAnyOf$StringsKt__StringsKt == null || (first = findAnyOf$StringsKt__StringsKt.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    public static final int lastIndexOf(CharSequence charSequence, char c, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$lastIndexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c, i);
        }
        return StringsKt.lastIndexOfAny(charSequence, new char[]{c}, i, z);
    }

    public static final int lastIndexOfAny(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        Integer first;
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$lastIndexOfAny");
        Intrinsics.checkParameterIsNotNull(collection, "strings");
        Pair<Integer, String> findAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, true);
        if (findAnyOf$StringsKt__StringsKt == null || (first = findAnyOf$StringsKt__StringsKt.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    private static final String replaceRange(String str, int i, int i2, CharSequence charSequence) {
        if (str != null) {
            return StringsKt.replaceRange((CharSequence) str, i, i2, charSequence).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final int indexOf(CharSequence charSequence, String str, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$indexOf");
        Intrinsics.checkParameterIsNotNull(str, "string");
        if (z || !(charSequence instanceof String)) {
            return indexOf$StringsKt__StringsKt$default(charSequence, str, i, charSequence.length(), z, false, 16, null);
        }
        return ((String) charSequence).indexOf(str, i);
    }

    public static final int lastIndexOf(CharSequence charSequence, String str, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$lastIndexOf");
        Intrinsics.checkParameterIsNotNull(str, "string");
        if (z || !(charSequence instanceof String)) {
            return indexOf$StringsKt__StringsKt(charSequence, str, i, 0, z, true);
        }
        return ((String) charSequence).lastIndexOf(str, i);
    }

    public static final String replaceAfter(String str, char c, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "$this$replaceAfter");
        Intrinsics.checkParameterIsNotNull(str2, "replacement");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        String str4 = str;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str4, c, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str3;
        }
        return StringsKt.replaceRange((CharSequence) str4, indexOf$default + 1, str.length(), (CharSequence) str2).toString();
    }

    public static final String replaceAfterLast(String str, char c, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "$this$replaceAfterLast");
        Intrinsics.checkParameterIsNotNull(str2, "replacement");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        String str4 = str;
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str4, c, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str3;
        }
        return StringsKt.replaceRange((CharSequence) str4, lastIndexOf$default + 1, str.length(), (CharSequence) str2).toString();
    }

    public static final String replaceBefore(String str, char c, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "$this$replaceBefore");
        Intrinsics.checkParameterIsNotNull(str2, "replacement");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        String str4 = str;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str4, c, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str3;
        }
        return StringsKt.replaceRange((CharSequence) str4, 0, indexOf$default, (CharSequence) str2).toString();
    }

    public static final String replaceBeforeLast(String str, char c, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "$this$replaceBeforeLast");
        Intrinsics.checkParameterIsNotNull(str2, "replacement");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        String str4 = str;
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str4, c, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str3;
        }
        return StringsKt.replaceRange((CharSequence) str4, 0, lastIndexOf$default, (CharSequence) str2).toString();
    }

    public static final Sequence<String> splitToSequence(CharSequence charSequence, char[] cArr, boolean z, int i) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$splitToSequence");
        Intrinsics.checkParameterIsNotNull(cArr, "delimiters");
        return C69294l.m266140e(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, cArr, 0, z, i, 2, (Object) null), new C69320e(charSequence));
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence charSequence2, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$startsWith");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        if (z || !(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            return StringsKt.regionMatchesImpl(charSequence, i, charSequence2, 0, charSequence2.length(), z);
        }
        return StringsKt.startsWith$default((String) charSequence, (String) charSequence2, i, false, 4, (Object) null);
    }

    public static final int indexOfAny(CharSequence charSequence, char[] cArr, int i, boolean z) {
        boolean z2;
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$indexOfAny");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            int coerceAtLeast = RangesKt.coerceAtLeast(i, 0);
            int lastIndex = StringsKt.getLastIndex(charSequence);
            if (coerceAtLeast > lastIndex) {
                return -1;
            }
            while (true) {
                char charAt = charSequence.charAt(coerceAtLeast);
                int length = cArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z2 = false;
                        break;
                    } else if (C69321a.m266166a(cArr[i2], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    return coerceAtLeast;
                }
                if (coerceAtLeast == lastIndex) {
                    return -1;
                }
                coerceAtLeast++;
            }
        } else {
            return ((String) charSequence).indexOf(C69043h.m265735a(cArr), i);
        }
    }

    public static final int lastIndexOfAny(CharSequence charSequence, char[] cArr, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$lastIndexOfAny");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            for (int coerceAtMost = RangesKt.coerceAtMost(i, StringsKt.getLastIndex(charSequence)); coerceAtMost >= 0; coerceAtMost--) {
                char charAt = charSequence.charAt(coerceAtMost);
                int length = cArr.length;
                boolean z2 = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (C69321a.m266166a(cArr[i2], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    return coerceAtMost;
                }
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(C69043h.m265735a(cArr), i);
    }

    public static final String replaceAfter(String str, String str2, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "$this$replaceAfter");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "replacement");
        Intrinsics.checkParameterIsNotNull(str4, "missingDelimiterValue");
        String str5 = str;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str5, str2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str4;
        }
        return StringsKt.replaceRange((CharSequence) str5, indexOf$default + str2.length(), str.length(), (CharSequence) str3).toString();
    }

    public static final String replaceAfterLast(String str, String str2, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "$this$replaceAfterLast");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "replacement");
        Intrinsics.checkParameterIsNotNull(str4, "missingDelimiterValue");
        String str5 = str;
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str5, str2, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str4;
        }
        return StringsKt.replaceRange((CharSequence) str5, lastIndexOf$default + str2.length(), str.length(), (CharSequence) str3).toString();
    }

    public static final String replaceBefore(String str, String str2, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "$this$replaceBefore");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "replacement");
        Intrinsics.checkParameterIsNotNull(str4, "missingDelimiterValue");
        String str5 = str;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str5, str2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str4;
        }
        return StringsKt.replaceRange((CharSequence) str5, 0, indexOf$default, (CharSequence) str3).toString();
    }

    public static final String replaceBeforeLast(String str, String str2, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "$this$replaceBeforeLast");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "replacement");
        Intrinsics.checkParameterIsNotNull(str4, "missingDelimiterValue");
        String str5 = str;
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str5, str2, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str4;
        }
        return StringsKt.replaceRange((CharSequence) str5, 0, lastIndexOf$default, (CharSequence) str3).toString();
    }

    public static final CharSequence replaceRange(CharSequence charSequence, int i, int i2, CharSequence charSequence2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$replaceRange");
        Intrinsics.checkParameterIsNotNull(charSequence2, "replacement");
        if (i2 >= i) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i);
            Intrinsics.checkExpressionValueIsNotNull(sb, "this.append(value, startIndex, endIndex)");
            sb.append(charSequence2);
            sb.append(charSequence, i2, charSequence.length());
            Intrinsics.checkExpressionValueIsNotNull(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    public static final List<String> split(CharSequence charSequence, char[] cArr, boolean z, int i) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$split");
        Intrinsics.checkParameterIsNotNull(cArr, "delimiters");
        if (cArr.length == 1) {
            return split$StringsKt__StringsKt(charSequence, String.valueOf(cArr[0]), z, i);
        }
        Iterable<IntRange> k = C69294l.m266147k(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, cArr, 0, z, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(k, 10));
        for (IntRange kVar : k) {
            arrayList.add(StringsKt.substring(charSequence, kVar));
        }
        return arrayList;
    }

    public static final Sequence<String> splitToSequence(CharSequence charSequence, String[] strArr, boolean z, int i) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$splitToSequence");
        Intrinsics.checkParameterIsNotNull(strArr, "delimiters");
        return C69294l.m266140e(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, strArr, 0, z, i, 2, (Object) null), new C69319d(charSequence));
    }

    public static final List<String> split(CharSequence charSequence, String[] strArr, boolean z, int i) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$split");
        Intrinsics.checkParameterIsNotNull(strArr, "delimiters");
        boolean z2 = true;
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                z2 = false;
            }
            if (!z2) {
                return split$StringsKt__StringsKt(charSequence, str, z, i);
            }
        }
        Iterable<IntRange> k = C69294l.m266147k(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, strArr, 0, z, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(k, 10));
        for (IntRange kVar : k) {
            arrayList.add(StringsKt.substring(charSequence, kVar));
        }
        return arrayList;
    }

    private static final List<String> split$StringsKt__StringsKt(CharSequence charSequence, String str, boolean z, int i) {
        boolean z2;
        boolean z3;
        int i2 = 0;
        if (i >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            int indexOf = StringsKt.indexOf(charSequence, str, 0, z);
            if (indexOf == -1 || i == 1) {
                return CollectionsKt.listOf(charSequence.toString());
            }
            if (i > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            int i3 = 10;
            if (z3) {
                i3 = RangesKt.coerceAtMost(i, 10);
            }
            ArrayList arrayList = new ArrayList(i3);
            do {
                arrayList.add(charSequence.subSequence(i2, indexOf).toString());
                i2 = str.length() + indexOf;
                if (z3 && arrayList.size() == i - 1) {
                    break;
                }
                indexOf = StringsKt.indexOf(charSequence, str, i2, z);
            } while (indexOf != -1);
            arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
            return arrayList;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
    }

    public static /* synthetic */ String commonPrefixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.commonPrefixWith(charSequence, charSequence2, z);
    }

    public static /* synthetic */ String commonSuffixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.commonSuffixWith(charSequence, charSequence2, z);
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.contains(charSequence, c, z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.endsWith(charSequence, c, z);
    }

    public static /* synthetic */ CharSequence padEnd$default(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return StringsKt.padEnd(charSequence, i, c);
    }

    public static /* synthetic */ CharSequence padStart$default(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return StringsKt.padStart(charSequence, i, c);
    }

    static /* synthetic */ List split$default(CharSequence charSequence, Regex regex, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.startsWith(charSequence, c, z);
    }

    public static /* synthetic */ String substringAfter$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringAfter(str, c, str2);
    }

    public static /* synthetic */ String substringAfterLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringAfterLast(str, c, str2);
    }

    public static /* synthetic */ String substringBefore$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringBefore(str, c, str2);
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringBeforeLast(str, c, str2);
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.contains(charSequence, charSequence2, z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.endsWith(charSequence, charSequence2, z);
    }

    public static /* synthetic */ String padEnd$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return StringsKt.padEnd(str, i, c);
    }

    public static /* synthetic */ String padStart$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return StringsKt.padStart(str, i, c);
    }

    static /* synthetic */ String substring$default(CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = charSequence.length();
        }
        return charSequence.subSequence(i, i2).toString();
    }

    public static /* synthetic */ String substringAfter$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringAfter(str, str2, str3);
    }

    public static /* synthetic */ String substringAfterLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringAfterLast(str, str2, str3);
    }

    public static /* synthetic */ String substringBefore$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringBefore(str, str2, str3);
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringBeforeLast(str, str2, str3);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, char[] cArr, int i, boolean z, int i2) {
        boolean z2;
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return new DelimitedRangesSequence(charSequence, i, i2, new C69317b(cArr, z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.startsWith(charSequence, charSequence2, z);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        boolean z2;
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return new DelimitedRangesSequence(charSequence, i, i2, new C69318c(C69043h.m265716a(strArr), z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    public static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        IntRange kVar;
        T t;
        T t2;
        int i2;
        if (z || collection.size() != 1) {
            if (!z2) {
                kVar = new IntRange(RangesKt.coerceAtLeast(i, 0), charSequence.length());
            } else {
                kVar = RangesKt.downTo(RangesKt.coerceAtMost(i, StringsKt.getLastIndex(charSequence)), 0);
            }
            if (charSequence instanceof String) {
                int a = kVar.mo239399a();
                int b = kVar.mo239400b();
                int c = kVar.mo239401c();
                if (c < 0 ? a >= b : a <= b) {
                    while (true) {
                        Iterator<T> it = collection.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                t2 = null;
                                break;
                            }
                            t2 = it.next();
                            T t3 = t2;
                            if (StringsKt.regionMatches((String) t3, 0, (String) charSequence, a, t3.length(), z)) {
                                break;
                            }
                        }
                        T t4 = t2;
                        if (t4 == null) {
                            if (a == b) {
                                break;
                            }
                            a += c;
                        } else {
                            return TuplesKt.to(Integer.valueOf(a), t4);
                        }
                    }
                }
            } else {
                int a2 = kVar.mo239399a();
                int b2 = kVar.mo239400b();
                int c2 = kVar.mo239401c();
                if (c2 < 0 ? a2 >= b2 : a2 <= b2) {
                    while (true) {
                        Iterator<T> it2 = collection.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                t = null;
                                break;
                            }
                            t = it2.next();
                            T t5 = t;
                            if (StringsKt.regionMatchesImpl(t5, 0, charSequence, a2, t5.length(), z)) {
                                break;
                            }
                        }
                        T t6 = t;
                        if (t6 == null) {
                            if (a2 == b2) {
                                break;
                            }
                            a2 += c2;
                        } else {
                            return TuplesKt.to(Integer.valueOf(a2), t6);
                        }
                    }
                }
            }
            return null;
        }
        String str = (String) CollectionsKt.single(collection);
        if (!z2) {
            i2 = StringsKt.indexOf$default(charSequence, str, i, false, 4, (Object) null);
        } else {
            i2 = StringsKt.lastIndexOf$default(charSequence, str, i, false, 4, (Object) null);
        }
        if (i2 < 0) {
            return null;
        }
        return TuplesKt.to(Integer.valueOf(i2), str);
    }

    public static /* synthetic */ Pair findAnyOf$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.findAnyOf(charSequence, collection, i, z);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.indexOf(charSequence, c, i, z);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.indexOfAny(charSequence, collection, i, z);
    }

    public static /* synthetic */ String replaceAfter$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return StringsKt.replaceAfter(str, c, str2, str3);
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return StringsKt.replaceAfterLast(str, c, str2, str3);
    }

    public static /* synthetic */ String replaceBefore$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return StringsKt.replaceBefore(str, c, str2, str3);
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return StringsKt.replaceBeforeLast(str, c, str2, str3);
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.splitToSequence(charSequence, cArr, z, i);
    }

    public static /* synthetic */ Pair findLastAnyOf$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.findLastAnyOf(charSequence, collection, i, z);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.indexOf(charSequence, str, i, z);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.indexOfAny(charSequence, cArr, i, z);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.lastIndexOf(charSequence, c, i, z);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.lastIndexOfAny(charSequence, collection, i, z);
    }

    public static /* synthetic */ String replaceAfter$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return StringsKt.replaceAfter(str, str2, str3, str4);
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return StringsKt.replaceAfterLast(str, str2, str3, str4);
    }

    public static /* synthetic */ String replaceBefore$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return StringsKt.replaceBefore(str, str2, str3, str4);
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return StringsKt.replaceBeforeLast(str, str2, str3, str4);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.split(charSequence, cArr, z, i);
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.splitToSequence(charSequence, strArr, z, i);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.startsWith(charSequence, charSequence2, i, z);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.lastIndexOf(charSequence, str, i, z);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.lastIndexOfAny(charSequence, cArr, i, z);
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$regionMatchesImpl");
        Intrinsics.checkParameterIsNotNull(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!C69321a.m266166a(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.split(charSequence, strArr, z, i);
    }

    private static final int indexOf$StringsKt__StringsKt(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        IntRange kVar;
        if (!z2) {
            kVar = new IntRange(RangesKt.coerceAtLeast(i, 0), RangesKt.coerceAtMost(i2, charSequence.length()));
        } else {
            kVar = RangesKt.downTo(RangesKt.coerceAtMost(i, StringsKt.getLastIndex(charSequence)), RangesKt.coerceAtLeast(i2, 0));
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int a = kVar.mo239399a();
            int b = kVar.mo239400b();
            int c = kVar.mo239401c();
            if (c >= 0) {
                if (a > b) {
                    return -1;
                }
            } else if (a < b) {
                return -1;
            }
            while (!StringsKt.regionMatchesImpl(charSequence2, 0, charSequence, a, charSequence2.length(), z)) {
                if (a == b) {
                    return -1;
                }
                a += c;
            }
            return a;
        }
        int a2 = kVar.mo239399a();
        int b2 = kVar.mo239400b();
        int c2 = kVar.mo239401c();
        if (c2 >= 0) {
            if (a2 > b2) {
                return -1;
            }
        } else if (a2 < b2) {
            return -1;
        }
        while (!StringsKt.regionMatches((String) charSequence2, 0, (String) charSequence, a2, charSequence2.length(), z)) {
            if (a2 == b2) {
                return -1;
            }
            a2 += c2;
        }
        return a2;
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, cArr, i, z, i2);
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, strArr, i, z, i2);
    }

    static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        boolean z3;
        if ((i3 & 16) != 0) {
            z3 = false;
        } else {
            z3 = z2;
        }
        return indexOf$StringsKt__StringsKt(charSequence, charSequence2, i, i2, z, z3);
    }
}
