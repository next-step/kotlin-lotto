package lotto.view

object InputView {
    private const val CORRECT_NUMBER_DELIMITER = ","

    fun inputPurchaseAmount() = input("구입금액을 입력해 주세요.")
        .toIntOrThrow()

    fun inputCorrectNumbers() = input("지난 주 당첨 번호를 입력해 주세요.")
        .toIntsOrThrow()
        .toSet()

    private fun input(message: String): String {
        println(message)
        return readln()
    }

    private fun String.toIntOrThrow(): Int = runCatching {
        this.toInt()
    }.getOrElse { throw IllegalArgumentException("[InputView] 값을 Int로 변환하는데 실패했습니다. | '$this'") }

    private fun String.toIntsOrThrow(): List<Int> {
        return this.split(CORRECT_NUMBER_DELIMITER)
            .map { it.trim().toIntOrThrow() }
    }
}
