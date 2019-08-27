package jp.shiita.protectedmock

abstract class UseCase<in P, R> {

    protected abstract fun execute(parameters: P): R

    operator fun invoke(parameters: P): R {
        // ローディング等の共通化処理
        return execute(parameters)
    }
}