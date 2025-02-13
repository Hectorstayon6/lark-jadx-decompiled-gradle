package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.ss.android.ttvecamera.p3038g.C60375c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.resolve.MemberComparator;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.sequences.C69294l;

public abstract class DeserializedMemberScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "variableNamesLazy", "getVariableNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;"))};

    /* renamed from: c */
    public final DeserializationContext f173277c;
    private final NotNullLazyValue classNames$delegate;
    private final NotNullLazyValue functionNamesLazy$delegate;
    public final Map<Name, byte[]> functionProtosBytes;
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
    private final MemoizedFunctionToNotNull<Name, Collection<PropertyDescriptor>> properties;
    public final Map<Name, byte[]> propertyProtosBytes;
    private final MemoizedFunctionToNullable<Name, TypeAliasDescriptor> typeAliasByName;
    private final Map<Name, byte[]> typeAliasBytes;
    private final NotNullLazyValue variableNamesLazy$delegate;

    private final Set<Name> getFunctionNamesLazy() {
        return (Set) StorageKt.getValue(this.functionNamesLazy$delegate, this, $$delegatedProperties[0]);
    }

    private final Set<Name> getVariableNamesLazy() {
        return (Set) StorageKt.getValue(this.variableNamesLazy$delegate, this, $$delegatedProperties[1]);
    }

    /* access modifiers changed from: protected */
    public abstract void addEnumEntryDescriptors(Collection<DeclarationDescriptor> collection, Function1<? super Name, Boolean> function1);

    /* access modifiers changed from: protected */
    public void computeNonDeclaredFunctions(Name name, Collection<SimpleFunctionDescriptor> collection) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(collection, "functions");
    }

    /* access modifiers changed from: protected */
    public void computeNonDeclaredProperties(Name name, Collection<PropertyDescriptor> collection) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(collection, "descriptors");
    }

    /* access modifiers changed from: protected */
    public abstract ClassId createClassId(Name name);

    public final Set<Name> getClassNames$deserialization() {
        return (Set) StorageKt.getValue(this.classNames$delegate, this, $$delegatedProperties[2]);
    }

    /* access modifiers changed from: protected */
    public abstract Set<Name> getNonDeclaredFunctionNames();

    /* access modifiers changed from: protected */
    public abstract Set<Name> getNonDeclaredVariableNames();

    /* access modifiers changed from: protected */
    public final DeserializationContext getC() {
        return this.f173277c;
    }

    private final Set<Name> getTypeAliasNames() {
        return this.typeAliasBytes.keySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl
    public Set<Name> getFunctionNames() {
        return getFunctionNamesLazy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl
    public Set<Name> getVariableNames() {
        return getVariableNamesLazy();
    }

    private final ClassDescriptor deserializeClass(Name name) {
        return this.f173277c.getComponents().deserializeClass(createClassId(name));
    }

    /* access modifiers changed from: protected */
    public boolean hasClass(Name name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        return getClassNames$deserialization().contains(name);
    }

    public final TypeAliasDescriptor createTypeAlias(Name name) {
        ProtoBuf.TypeAlias parseDelimitedFrom;
        byte[] bArr = this.typeAliasBytes.get(name);
        if (bArr == null || (parseDelimitedFrom = ProtoBuf.TypeAlias.parseDelimitedFrom(new ByteArrayInputStream(bArr), this.f173277c.getComponents().getExtensionRegistryLite())) == null) {
            return null;
        }
        return this.f173277c.getMemberDeserializer().loadTypeAlias(parseDelimitedFrom);
    }

    private final Map<Name, byte[]> packToByteArray(Map<Name, ? extends Collection<? extends AbstractMessageLite>> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (T t : map.entrySet()) {
            Object key = t.getKey();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Iterable<AbstractMessageLite> iterable = (Iterable) t.getValue();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (AbstractMessageLite abstractMessageLite : iterable) {
                abstractMessageLite.writeDelimitedTo(byteArrayOutputStream);
                arrayList.add(Unit.INSTANCE);
            }
            linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
        }
        return linkedHashMap;
    }

    public final Collection<SimpleFunctionDescriptor> computeFunctions(Name name) {
        List<ProtoBuf.Function> list;
        List h;
        Map<Name, byte[]> map = this.functionProtosBytes;
        Parser<ProtoBuf.Function> parser = ProtoBuf.Function.PARSER;
        Intrinsics.checkExpressionValueIsNotNull(parser, "ProtoBuf.Function.PARSER");
        byte[] bArr = map.get(name);
        if (bArr == null || (h = C69294l.m266144h(C69294l.m266117a(new DeserializedMemberScope$computeDescriptors$$inlined$let$lambda$1(new ByteArrayInputStream(bArr), this, parser)))) == null) {
            list = CollectionsKt.emptyList();
        } else {
            list = h;
        }
        ArrayList arrayList = new ArrayList();
        for (ProtoBuf.Function function : list) {
            MemberDeserializer memberDeserializer = this.f173277c.getMemberDeserializer();
            Intrinsics.checkExpressionValueIsNotNull(function, "it");
            arrayList.add(memberDeserializer.loadFunction(function));
        }
        ArrayList arrayList2 = arrayList;
        computeNonDeclaredFunctions(name, arrayList2);
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(arrayList2);
    }

    public final Collection<PropertyDescriptor> computeProperties(Name name) {
        List<ProtoBuf.Property> list;
        List h;
        Map<Name, byte[]> map = this.propertyProtosBytes;
        Parser<ProtoBuf.Property> parser = ProtoBuf.Property.PARSER;
        Intrinsics.checkExpressionValueIsNotNull(parser, "ProtoBuf.Property.PARSER");
        byte[] bArr = map.get(name);
        if (bArr == null || (h = C69294l.m266144h(C69294l.m266117a(new DeserializedMemberScope$computeDescriptors$$inlined$let$lambda$3(new ByteArrayInputStream(bArr), this, parser)))) == null) {
            list = CollectionsKt.emptyList();
        } else {
            list = h;
        }
        ArrayList arrayList = new ArrayList();
        for (ProtoBuf.Property property : list) {
            MemberDeserializer memberDeserializer = this.f173277c.getMemberDeserializer();
            Intrinsics.checkExpressionValueIsNotNull(property, "it");
            arrayList.add(memberDeserializer.loadProperty(property));
        }
        ArrayList arrayList2 = arrayList;
        computeNonDeclaredProperties(name, arrayList2);
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(arrayList2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(lookupLocation, "location");
        if (hasClass(name)) {
            return deserializeClass(name);
        }
        if (getTypeAliasNames().contains(name)) {
            return this.typeAliasByName.invoke(name);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(lookupLocation, "location");
        if (!getFunctionNames().contains(name)) {
            return CollectionsKt.emptyList();
        }
        return this.functions.invoke(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(lookupLocation, "location");
        if (!getVariableNames().contains(name)) {
            return CollectionsKt.emptyList();
        }
        return this.properties.invoke(name);
    }

    /* access modifiers changed from: protected */
    public final Collection<DeclarationDescriptor> computeDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1, LookupLocation lookupLocation) {
        Intrinsics.checkParameterIsNotNull(descriptorKindFilter, "kindFilter");
        Intrinsics.checkParameterIsNotNull(function1, "nameFilter");
        Intrinsics.checkParameterIsNotNull(lookupLocation, "location");
        ArrayList arrayList = new ArrayList(0);
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getSINGLETON_CLASSIFIERS_MASK())) {
            addEnumEntryDescriptors(arrayList, function1);
        }
        ArrayList arrayList2 = arrayList;
        addFunctionsAndProperties(arrayList2, descriptorKindFilter, function1, lookupLocation);
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK())) {
            for (Name name : getClassNames$deserialization()) {
                if (function1.invoke(name).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(arrayList2, deserializeClass(name));
                }
            }
        }
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getTYPE_ALIASES_MASK())) {
            for (Name name2 : getTypeAliasNames()) {
                if (function1.invoke(name2).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(arrayList2, this.typeAliasByName.invoke(name2));
                }
            }
        }
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(arrayList);
    }

    private final void addFunctionsAndProperties(Collection<DeclarationDescriptor> collection, DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1, LookupLocation lookupLocation) {
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK())) {
            ArrayList arrayList = new ArrayList();
            for (Name name : getVariableNames()) {
                if (function1.invoke(name).booleanValue()) {
                    arrayList.addAll(getContributedVariables(name, lookupLocation));
                }
            }
            MemberComparator.NameAndTypeMemberComparator nameAndTypeMemberComparator = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(nameAndTypeMemberComparator, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
            CollectionsKt.sortWith(arrayList, nameAndTypeMemberComparator);
            collection.addAll(arrayList);
        }
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK())) {
            ArrayList arrayList2 = new ArrayList();
            for (Name name2 : getFunctionNames()) {
                if (function1.invoke(name2).booleanValue()) {
                    arrayList2.addAll(getContributedFunctions(name2, lookupLocation));
                }
            }
            MemberComparator.NameAndTypeMemberComparator nameAndTypeMemberComparator2 = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(nameAndTypeMemberComparator2, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
            CollectionsKt.sortWith(arrayList2, nameAndTypeMemberComparator2);
            collection.addAll(arrayList2);
        }
    }

    protected DeserializedMemberScope(DeserializationContext deserializationContext, Collection<ProtoBuf.Function> collection, Collection<ProtoBuf.Property> collection2, Collection<ProtoBuf.TypeAlias> collection3, Function0<? extends Collection<Name>> function0) {
        Map<Name, byte[]> map;
        Intrinsics.checkParameterIsNotNull(deserializationContext, C60375c.f150914a);
        Intrinsics.checkParameterIsNotNull(collection, "functionList");
        Intrinsics.checkParameterIsNotNull(collection2, "propertyList");
        Intrinsics.checkParameterIsNotNull(collection3, "typeAliasList");
        Intrinsics.checkParameterIsNotNull(function0, "classNames");
        this.f173277c = deserializationContext;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : collection) {
            Name name = NameResolverUtilKt.getName(this.f173277c.getNameResolver(), t.getName());
            Object obj = linkedHashMap.get(name);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(name, obj);
            }
            ((List) obj).add(t);
        }
        this.functionProtosBytes = packToByteArray(linkedHashMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (T t2 : collection2) {
            Name name2 = NameResolverUtilKt.getName(this.f173277c.getNameResolver(), t2.getName());
            Object obj2 = linkedHashMap2.get(name2);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap2.put(name2, obj2);
            }
            ((List) obj2).add(t2);
        }
        this.propertyProtosBytes = packToByteArray(linkedHashMap2);
        if (this.f173277c.getComponents().getConfiguration().getTypeAliasesAllowed()) {
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (T t3 : collection3) {
                Name name3 = NameResolverUtilKt.getName(this.f173277c.getNameResolver(), t3.getName());
                Object obj3 = linkedHashMap3.get(name3);
                if (obj3 == null) {
                    obj3 = new ArrayList();
                    linkedHashMap3.put(name3, obj3);
                }
                ((List) obj3).add(t3);
            }
            map = packToByteArray(linkedHashMap3);
        } else {
            map = MapsKt.emptyMap();
        }
        this.typeAliasBytes = map;
        this.functions = this.f173277c.getStorageManager().createMemoizedFunction(new DeserializedMemberScope$functions$1(this));
        this.properties = this.f173277c.getStorageManager().createMemoizedFunction(new DeserializedMemberScope$properties$1(this));
        this.typeAliasByName = this.f173277c.getStorageManager().createMemoizedFunctionWithNullableValues(new DeserializedMemberScope$typeAliasByName$1(this));
        this.functionNamesLazy$delegate = this.f173277c.getStorageManager().createLazyValue(new DeserializedMemberScope$functionNamesLazy$2(this));
        this.variableNamesLazy$delegate = this.f173277c.getStorageManager().createLazyValue(new DeserializedMemberScope$variableNamesLazy$2(this));
        this.classNames$delegate = this.f173277c.getStorageManager().createLazyValue(new DeserializedMemberScope$classNames$2(function0));
    }
}
