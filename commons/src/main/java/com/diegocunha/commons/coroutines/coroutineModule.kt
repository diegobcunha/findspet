package com.diegocunha.commons.coroutines

import org.koin.dsl.module

val coroutineModule = module {
    factory<DispatchersProvider> { ProductionDispatchersProvider }
}