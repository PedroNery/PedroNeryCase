package com.projeto.pedronerycase.koin.aware

import org.koin.core.module.Module

class ModuleList internal constructor(
    modules: List<Module>,
    val keepAfterDestroy: Boolean
) : List<Module> by modules