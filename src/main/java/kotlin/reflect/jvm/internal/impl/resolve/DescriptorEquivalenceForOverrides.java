package kotlin.reflect.jvm.internal.impl.resolve;

import com.ss.android.socialbase.downloader.downloader.AbstractC60044a;
import com.ss.android.vesdk.p3188b.C63954b;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;

public final class DescriptorEquivalenceForOverrides {
    public static final DescriptorEquivalenceForOverrides INSTANCE = new DescriptorEquivalenceForOverrides();

    private DescriptorEquivalenceForOverrides() {
    }

    private final SourceElement singleSource(CallableDescriptor callableDescriptor) {
        while (callableDescriptor instanceof CallableMemberDescriptor) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) callableDescriptor;
            if (callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                break;
            }
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
            Intrinsics.checkExpressionValueIsNotNull(overriddenDescriptors, "overriddenDescriptors");
            CallableMemberDescriptor callableMemberDescriptor2 = (CallableMemberDescriptor) CollectionsKt.singleOrNull(overriddenDescriptors);
            if (callableMemberDescriptor2 == null) {
                return null;
            }
            callableDescriptor = callableMemberDescriptor2;
        }
        return callableDescriptor.getSource();
    }

    private final boolean areClassesEquivalent(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        return Intrinsics.areEqual(classDescriptor.getTypeConstructor(), classDescriptor2.getTypeConstructor());
    }

    public final boolean areEquivalent(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, boolean z) {
        if ((declarationDescriptor instanceof ClassDescriptor) && (declarationDescriptor2 instanceof ClassDescriptor)) {
            return areClassesEquivalent((ClassDescriptor) declarationDescriptor, (ClassDescriptor) declarationDescriptor2);
        }
        if ((declarationDescriptor instanceof TypeParameterDescriptor) && (declarationDescriptor2 instanceof TypeParameterDescriptor)) {
            return areTypeParametersEquivalent$default(this, (TypeParameterDescriptor) declarationDescriptor, (TypeParameterDescriptor) declarationDescriptor2, z, null, 8, null);
        }
        if ((declarationDescriptor instanceof CallableDescriptor) && (declarationDescriptor2 instanceof CallableDescriptor)) {
            return areCallableDescriptorsEquivalent$default(this, (CallableDescriptor) declarationDescriptor, (CallableDescriptor) declarationDescriptor2, z, false, 8, null);
        }
        if (!(declarationDescriptor instanceof PackageFragmentDescriptor) || !(declarationDescriptor2 instanceof PackageFragmentDescriptor)) {
            return Intrinsics.areEqual(declarationDescriptor, declarationDescriptor2);
        }
        return Intrinsics.areEqual(((PackageFragmentDescriptor) declarationDescriptor).getFqName(), ((PackageFragmentDescriptor) declarationDescriptor2).getFqName());
    }

    private final boolean ownersEquivalent(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> kVar, boolean z) {
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        DeclarationDescriptor containingDeclaration2 = declarationDescriptor2.getContainingDeclaration();
        if ((containingDeclaration instanceof CallableMemberDescriptor) || (containingDeclaration2 instanceof CallableMemberDescriptor)) {
            return kVar.invoke(containingDeclaration, containingDeclaration2).booleanValue();
        }
        return areEquivalent(containingDeclaration, containingDeclaration2, z);
    }

    public final boolean areTypeParametersEquivalent(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, boolean z, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> kVar) {
        if (Intrinsics.areEqual(typeParameterDescriptor, typeParameterDescriptor2)) {
            return true;
        }
        if (!Intrinsics.areEqual(typeParameterDescriptor.getContainingDeclaration(), typeParameterDescriptor2.getContainingDeclaration()) && ownersEquivalent(typeParameterDescriptor, typeParameterDescriptor2, kVar, z) && typeParameterDescriptor.getIndex() == typeParameterDescriptor2.getIndex()) {
            return true;
        }
        return false;
    }

    public final boolean areCallableDescriptorsEquivalent(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean z, boolean z2) {
        Intrinsics.checkParameterIsNotNull(callableDescriptor, AbstractC60044a.f149675a);
        Intrinsics.checkParameterIsNotNull(callableDescriptor2, C63954b.f161494a);
        if (Intrinsics.areEqual(callableDescriptor, callableDescriptor2)) {
            return true;
        }
        if (!Intrinsics.areEqual(callableDescriptor.getName(), callableDescriptor2.getName())) {
            return false;
        }
        if (Intrinsics.areEqual(callableDescriptor.getContainingDeclaration(), callableDescriptor2.getContainingDeclaration())) {
            if (!z || (!Intrinsics.areEqual(singleSource(callableDescriptor), singleSource(callableDescriptor2)))) {
                return false;
            }
            if ((callableDescriptor instanceof MemberDescriptor) && (callableDescriptor2 instanceof MemberDescriptor) && ((MemberDescriptor) callableDescriptor).isExpect() != ((MemberDescriptor) callableDescriptor2).isExpect()) {
                return false;
            }
        }
        CallableDescriptor callableDescriptor3 = callableDescriptor;
        if (!DescriptorUtils.isLocal(callableDescriptor3)) {
            CallableDescriptor callableDescriptor4 = callableDescriptor2;
            if (DescriptorUtils.isLocal(callableDescriptor4) || !ownersEquivalent(callableDescriptor3, callableDescriptor4, DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$1.INSTANCE, z)) {
                return false;
            }
            OverridingUtil createWithEqualityAxioms = OverridingUtil.createWithEqualityAxioms(new DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1(z, callableDescriptor, callableDescriptor2));
            Intrinsics.checkExpressionValueIsNotNull(createWithEqualityAxioms, "OverridingUtil.createWit…= a && y == b }\n        }");
            OverridingUtil.OverrideCompatibilityInfo isOverridableBy = createWithEqualityAxioms.isOverridableBy(callableDescriptor, callableDescriptor2, null, !z2);
            Intrinsics.checkExpressionValueIsNotNull(isOverridableBy, "overridingUtil.isOverrid… null, !ignoreReturnType)");
            if (isOverridableBy.getResult() == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) {
                OverridingUtil.OverrideCompatibilityInfo isOverridableBy2 = createWithEqualityAxioms.isOverridableBy(callableDescriptor2, callableDescriptor, null, !z2);
                Intrinsics.checkExpressionValueIsNotNull(isOverridableBy2, "overridingUtil.isOverrid… null, !ignoreReturnType)");
                if (isOverridableBy2.getResult() == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static /* synthetic */ boolean areCallableDescriptorsEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = false;
        }
        return descriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent(callableDescriptor, callableDescriptor2, z, z2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides */
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean areTypeParametersEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, boolean z, Function2 kVar, int i, Object obj) {
        if ((i & 8) != 0) {
            kVar = DescriptorEquivalenceForOverrides$areTypeParametersEquivalent$1.INSTANCE;
        }
        return descriptorEquivalenceForOverrides.areTypeParametersEquivalent(typeParameterDescriptor, typeParameterDescriptor2, z, kVar);
    }
}
