package com.projeto.test

object ReadFile {
    operator fun invoke(path: String) = this.javaClass.classLoader.getResource(path).readText()
}