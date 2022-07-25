package com.projeto.test.integration

internal class ReadFile {
    operator fun invoke(path: String) = this.javaClass.classLoader?.getResource(path)?.readText()
}