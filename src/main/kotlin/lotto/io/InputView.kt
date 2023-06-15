package lotto.io

object InputView {
    private const val AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요."
    fun getAmount(): Int {
        println(AMOUNT_INPUT_MESSAGE)
        return requireNotNull(readlnOrNull()?.toIntOrNull()) { "입력이 올바르지 않습니다" }
    }
}
