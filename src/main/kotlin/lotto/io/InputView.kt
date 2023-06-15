package lotto.io

object InputView {
    private const val AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요."
    fun getAmount(): Int {
        println(AMOUNT_INPUT_MESSAGE)
        return requireNotNull(readlnOrNull()?.toIntOrNull()) { "입력이 올바르지 않습니다" }
    }

    fun getWinNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val tokens = requireNotNull(readlnOrNull()?.split(", ")) { "입력이 올바르지 않습니다" }
        return tokens.map { requireNotNull(it.toIntOrNull()) { "입력이 올바르지 않습니다" } }
    }
}
