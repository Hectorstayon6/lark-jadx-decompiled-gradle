package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.C69043h;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u0005\u0006\u0007\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u0001\u0005\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "()V", "asString", "", "FakeJavaAnnotationConstructor", "JavaConstructor", "JavaMethod", "KotlinConstructor", "KotlinFunction", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "kotlin-reflection"}, mo238835k = 1, mv = {1, 1, 16})
public abstract class JvmFunctionSignature {
    public abstract String asString();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "methods", "", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "getMethods", "()Ljava/util/List;", "asString", "", "kotlin-reflection"}, mo238835k = 1, mv = {1, 1, 16})
    public static final class FakeJavaAnnotationConstructor extends JvmFunctionSignature {
        private final Class<?> jClass;
        private final List<Method> methods;

        public final List<Method> getMethods() {
            return this.methods;
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        public String asString() {
            return CollectionsKt.joinToString$default(this.methods, "", "<init>(", ")V", 0, null, JvmFunctionSignature$FakeJavaAnnotationConstructor$asString$1.INSTANCE, 24, null);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FakeJavaAnnotationConstructor(Class<?> cls) {
            super(null);
            Intrinsics.checkParameterIsNotNull(cls, "jClass");
            this.jClass = cls;
            Method[] declaredMethods = cls.getDeclaredMethods();
            Intrinsics.checkExpressionValueIsNotNull(declaredMethods, "jClass.declaredMethods");
            this.methods = C69043h.m265775c((Object[]) declaredMethods, (Comparator) new JvmFunctionSignature$FakeJavaAnnotationConstructor$$special$$inlined$sortedBy$1());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "constructor", "Ljava/lang/reflect/Constructor;", "(Ljava/lang/reflect/Constructor;)V", "getConstructor", "()Ljava/lang/reflect/Constructor;", "asString", "", "kotlin-reflection"}, mo238835k = 1, mv = {1, 1, 16})
    public static final class JavaConstructor extends JvmFunctionSignature {
        private final Constructor<?> constructor;

        public final Constructor<?> getConstructor() {
            return this.constructor;
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        public String asString() {
            Class<?>[] parameterTypes = this.constructor.getParameterTypes();
            Intrinsics.checkExpressionValueIsNotNull(parameterTypes, "constructor.parameterTypes");
            return C69043h.m265740a(parameterTypes, "", "<init>(", ")V", 0, null, JvmFunctionSignature$JavaConstructor$asString$1.INSTANCE, 24, null);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public JavaConstructor(Constructor<?> constructor2) {
            super(null);
            Intrinsics.checkParameterIsNotNull(constructor2, "constructor");
            this.constructor = constructor2;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "getMethod", "()Ljava/lang/reflect/Method;", "asString", "", "kotlin-reflection"}, mo238835k = 1, mv = {1, 1, 16})
    public static final class JavaMethod extends JvmFunctionSignature {
        private final Method method;

        public final Method getMethod() {
            return this.method;
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        public String asString() {
            return RuntimeTypeMapperKt.getSignature(this.method);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public JavaMethod(Method method2) {
            super(null);
            Intrinsics.checkParameterIsNotNull(method2, "method");
            this.method = method2;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", "", "constructorDesc", "getConstructorDesc", "()Ljava/lang/String;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"}, mo238835k = 1, mv = {1, 1, 16})
    public static final class KotlinConstructor extends JvmFunctionSignature {
        private final String _signature;
        private final JvmMemberSignature.Method signature;

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        public String asString() {
            return this._signature;
        }

        public final String getConstructorDesc() {
            return this.signature.getDesc();
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public KotlinConstructor(JvmMemberSignature.Method method) {
            super(null);
            Intrinsics.checkParameterIsNotNull(method, "signature");
            this.signature = method;
            this._signature = method.asString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", "", "methodDesc", "getMethodDesc", "()Ljava/lang/String;", "methodName", "getMethodName", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"}, mo238835k = 1, mv = {1, 1, 16})
    public static final class KotlinFunction extends JvmFunctionSignature {
        private final String _signature;
        private final JvmMemberSignature.Method signature;

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        public String asString() {
            return this._signature;
        }

        public final String getMethodDesc() {
            return this.signature.getDesc();
        }

        public final String getMethodName() {
            return this.signature.getName();
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public KotlinFunction(JvmMemberSignature.Method method) {
            super(null);
            Intrinsics.checkParameterIsNotNull(method, "signature");
            this.signature = method;
            this._signature = method.asString();
        }
    }

    private JvmFunctionSignature() {
    }

    public /* synthetic */ JvmFunctionSignature(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
