package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

public final class SignatureBuildingComponents {
    public static final SignatureBuildingComponents INSTANCE = new SignatureBuildingComponents();

    private SignatureBuildingComponents() {
    }

    public final String escapeClassName(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return 'L' + str + ';';
    }

    public final String javaFunction(String str) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        return "java/util/function/" + str;
    }

    public final String javaLang(String str) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        return "java/lang/" + str;
    }

    public final String javaUtil(String str) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        return "java/util/" + str;
    }

    public final String[] constructors(String... strArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "signatures");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("<init>(" + str + ")V");
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final LinkedHashSet<String> inJavaLang(String str, String... strArr) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(strArr, "signatures");
        return inClass(javaLang(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final LinkedHashSet<String> inJavaUtil(String str, String... strArr) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(strArr, "signatures");
        return inClass(javaUtil(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final String signature(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "internalName");
        Intrinsics.checkParameterIsNotNull(str2, "jvmDescriptor");
        return str + '.' + str2;
    }

    public final LinkedHashSet<String> inClass(String str, String... strArr) {
        Intrinsics.checkParameterIsNotNull(str, "internalName");
        Intrinsics.checkParameterIsNotNull(strArr, "signatures");
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        for (String str2 : strArr) {
            linkedHashSet.add(str + '.' + str2);
        }
        return linkedHashSet;
    }

    public final String signature(ClassDescriptor classDescriptor, String str) {
        Intrinsics.checkParameterIsNotNull(classDescriptor, "classDescriptor");
        Intrinsics.checkParameterIsNotNull(str, "jvmDescriptor");
        return signature(MethodSignatureMappingKt.getInternalName(classDescriptor), str);
    }

    public final String jvmDescriptor(String str, List<String> list, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(list, "parameters");
        Intrinsics.checkParameterIsNotNull(str2, "ret");
        return str + '(' + CollectionsKt.joinToString$default(list, "", null, null, 0, null, SignatureBuildingComponents$jvmDescriptor$1.INSTANCE, 30, null) + ')' + escapeClassName(str2);
    }
}
