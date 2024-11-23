package lotto.view

object InputView {
    fun inputPurchaseAmount() = input("구입금액을 입력해 주세요.")
        .toIntOrThrow()

    private fun input(message: String): String {
        println(message)
        return readln()
    }

    private fun String.toIntOrThrow(): Int = runCatching {
        this.toInt()
    }.getOrElse { throw IllegalArgumentException("[InputView] 값을 Int로 변환하는데 실패했습니다. | '$this'") }
}
