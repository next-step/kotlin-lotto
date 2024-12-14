package lotto.common

object RetryHandler {
    fun <T> retryIfFail(
        mainAction: () -> T,
        retryAction: () -> T,
    ): T {
        return runCatching { mainAction() }
            .getOrElse { exception ->
                println("Error: ${exception.message}")
                retryAction()
            }
    }
}
