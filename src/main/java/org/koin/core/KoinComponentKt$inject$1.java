package org.koin.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.DefinitionParameters;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "T", "invoke", "()Ljava/lang/Object;"}, mo238835k = 3, mv = {1, 1, 16})
public final class KoinComponentKt$inject$1 extends Lambda implements Function0<T> {
    final /* synthetic */ Function0 $parameters;
    final /* synthetic */ Qualifier $qualifier;
    final /* synthetic */ KoinComponent $this_inject;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KoinComponentKt$inject$1(KoinComponent cVar, Qualifier aVar, Function0 function0) {
        super(0);
        this.$this_inject = cVar;
        this.$qualifier = aVar;
        this.$parameters = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final T invoke() {
        Koin a = this.$this_inject.mo246610a();
        Qualifier aVar = this.$qualifier;
        Function0<DefinitionParameters> function0 = this.$parameters;
        Scope d = a.mo246615a().mo246686d();
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) d.mo246699b(Reflection.getOrCreateKotlinClass(Object.class), aVar, function0);
    }
}
