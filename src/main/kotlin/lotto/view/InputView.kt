package lotto.view

object InputView {
    fun getPurchaseAmount(): Int {
        println("구입 금액을 입력해 주세요.")
        val input = readlnOrNull()
        return input?.toIntOrNull() ?: throw IllegalArgumentException("숫자만 입력 가능합니다.")
    }
}
