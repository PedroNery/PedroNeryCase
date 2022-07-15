package com.projeto.common.koin.aware

import org.koin.core.module.Module

fun KoinAware.modules(
    vararg modules: Module,
    keepAfterDestroy: Boolean = true
) = subModules(modules.asList(), keepAfterDestroy)

private fun subModules(
    modules: List<Module>,
    keepAfterDestroy: Boolean
) = lazy {
    ModuleList(modules, keepAfterDestroy)
}