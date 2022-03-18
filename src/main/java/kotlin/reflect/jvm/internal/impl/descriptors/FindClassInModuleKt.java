package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.sequences.C69294l;

public final class FindClassInModuleKt {
    public static final ClassDescriptor findClassAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "$this$findClassAcrossModuleDependencies");
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        ClassifierDescriptor findClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (!(findClassifierAcrossModuleDependencies instanceof ClassDescriptor)) {
            findClassifierAcrossModuleDependencies = null;
        }
        return (ClassDescriptor) findClassifierAcrossModuleDependencies;
    }

    public static final TypeAliasDescriptor findTypeAliasAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "$this$findTypeAliasAcrossModuleDependencies");
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        ClassifierDescriptor findClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (!(findClassifierAcrossModuleDependencies instanceof TypeAliasDescriptor)) {
            findClassifierAcrossModuleDependencies = null;
        }
        return (TypeAliasDescriptor) findClassifierAcrossModuleDependencies;
    }

    public static final ClassifierDescriptor findClassifierAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "$this$findClassifierAcrossModuleDependencies");
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        FqName packageFqName = classId.getPackageFqName();
        Intrinsics.checkExpressionValueIsNotNull(packageFqName, "classId.packageFqName");
        PackageViewDescriptor packageViewDescriptor = moduleDescriptor.getPackage(packageFqName);
        List<Name> pathSegments = classId.getRelativeClassName().pathSegments();
        Intrinsics.checkExpressionValueIsNotNull(pathSegments, "classId.relativeClassName.pathSegments()");
        MemberScope memberScope = packageViewDescriptor.getMemberScope();
        Object first = CollectionsKt.first((List) pathSegments);
        Intrinsics.checkExpressionValueIsNotNull(first, "segments.first()");
        ClassDescriptor contributedClassifier = memberScope.getContributedClassifier((Name) first, NoLookupLocation.FROM_DESERIALIZATION);
        if (contributedClassifier == null) {
            return null;
        }
        for (Name name : pathSegments.subList(1, pathSegments.size())) {
            if (!(contributedClassifier instanceof ClassDescriptor)) {
                return null;
            }
            MemberScope unsubstitutedInnerClassesScope = ((ClassDescriptor) contributedClassifier).getUnsubstitutedInnerClassesScope();
            Intrinsics.checkExpressionValueIsNotNull(name, "name");
            ClassifierDescriptor contributedClassifier2 = unsubstitutedInnerClassesScope.getContributedClassifier(name, NoLookupLocation.FROM_DESERIALIZATION);
            if (!(contributedClassifier2 instanceof ClassDescriptor)) {
                contributedClassifier2 = null;
            }
            ClassDescriptor classDescriptor = (ClassDescriptor) contributedClassifier2;
            if (classDescriptor == null) {
                return null;
            }
            contributedClassifier = classDescriptor;
        }
        return contributedClassifier;
    }

    public static final ClassDescriptor findNonGenericClassAcrossDependencies(ModuleDescriptor moduleDescriptor, ClassId classId, NotFoundClasses notFoundClasses) {
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "$this$findNonGenericClassAcrossDependencies");
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        Intrinsics.checkParameterIsNotNull(notFoundClasses, "notFoundClasses");
        ClassDescriptor findClassAcrossModuleDependencies = findClassAcrossModuleDependencies(moduleDescriptor, classId);
        if (findClassAcrossModuleDependencies != null) {
            return findClassAcrossModuleDependencies;
        }
        return notFoundClasses.getClass(classId, C69294l.m266144h(C69294l.m266140e(C69294l.m266115a(classId, FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1.INSTANCE), FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2.INSTANCE)));
    }
}
