package org.koin.core.scope;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.koin.core.parameter.DefinitionParameters;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "T", "", "Lorg/koin/core/scope/Scope;", "it", "Lorg/koin/core/parameter/DefinitionParameters;", "invoke", "(Lorg/koin/core/scope/Scope;Lorg/koin/core/parameter/DefinitionParameters;)Ljava/lang/Object;"}, mo238835k = 3, mv = {1, 1, 16})
public final class ScopeDefinition$saveNewDefinition$beanDefinition$1 extends Lambda implements Function2<Scope, DefinitionParameters, T> {
    final /* synthetic */ Object $instance;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScopeDefinition$saveNewDefinition$beanDefinition$1(Object obj) {
        super(2);
        this.$instance = obj;
    }

    public final T invoke(Scope aVar, DefinitionParameters aVar2) {
        Intrinsics.checkParameterIsNotNull(aVar, "$receiver");
        Intrinsics.checkParameterIsNotNull(aVar2, "it");
        return (T) this.$instance;
    }
}
