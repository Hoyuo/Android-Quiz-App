package com.example.template.internal

import org.gradle.api.NamedDomainObjectContainer

inline val <T> NamedDomainObjectContainer<T>.test: T get() = test { }

fun <T> NamedDomainObjectContainer<T>.test(block: T.() -> Unit): T =
    getByName("test") { block() }

inline val <T> NamedDomainObjectContainer<T>.main: T get() = main { }

fun <T> NamedDomainObjectContainer<T>.main(block: T.() -> Unit): T =
    getByName("main") { block() }

inline val <T> NamedDomainObjectContainer<T>.dev: T get() = dev { }

fun <T> NamedDomainObjectContainer<T>.dev(block: T.() -> Unit): T =
    getByName(Flavors.DEV) { block() }

inline val <T> NamedDomainObjectContainer<T>.staging: T get() = staging { }

fun <T> NamedDomainObjectContainer<T>.staging(block: T.() -> Unit): T =
    getByName(Flavors.STAGING) { block() }

inline val <T> NamedDomainObjectContainer<T>.production: T get() = production { }

fun <T> NamedDomainObjectContainer<T>.production(block: T.() -> Unit): T =
    getByName(Flavors.PRODUCTION) { block() }

inline val <T> NamedDomainObjectContainer<T>.debug: T get() = debug { }

fun <T> NamedDomainObjectContainer<T>.debug(block: T.() -> Unit): T =
    getByName("debug") { block() }

inline val <T> NamedDomainObjectContainer<T>.release: T get() = release { }

fun <T> NamedDomainObjectContainer<T>.release(block: T.() -> Unit): T =
    getByName("release") { block() }
