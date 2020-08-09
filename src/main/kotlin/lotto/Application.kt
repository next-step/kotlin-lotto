package lotto

fun main() {
    try {
        val amountOfMoney = InputView.inputAmountOfMoney()
        val amountOfLotto = LottoProgram.getAmountOfLotto(amountOfMoney)
    } catch (e: NumberFormatException) {
        throw NullPointerException("숫자만 입력 가능합니다.")
    }
}
