package jp.shiita.protectedmock

import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.jvm.isAccessible

// protectedなメソッドの代わりに使う拡張関数
fun <P, R> UseCase<P, R>.execute(parameters: P) =
    this::class.declaredMemberFunctions.single { it.name == "execute" }.let { function ->
        function.isAccessible = true
        function.call(this, parameters)
    }