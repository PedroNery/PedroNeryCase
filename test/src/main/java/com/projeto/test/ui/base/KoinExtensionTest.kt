package com.projeto.test.ui.base

import com.projeto.common.koin.aware.KoinAware
import com.projeto.common.koin.aware.getUniqueScopedQualifier
import io.mockk.every
import io.mockk.mockkStatic
import org.koin.core.qualifier.TypeQualifier
import kotlin.reflect.KClass

private const val KOIN_EXT_PACKAGE = "com.projeto.common.koin.aware.KoinExtensionsKt"

internal inline fun <reified T : KoinAware> mockScopeQualifier(type: KClass<*>) {
    mockkStatic(KOIN_EXT_PACKAGE)
    every { any<T>().getUniqueScopedQualifier() } returns TypeQualifier(type)
}