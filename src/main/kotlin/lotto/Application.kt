package lotto

fun main() {
    try {
        val amountOfMoney = InputView.inputAmountOfMoney()
        val amountOfLotto = LottoProgram.getAmountOfLotto(amountOfMoney)
        val lottos = Lottos(amountOfLotto)
        OutputView.showUserLottos(lottos.lottos)
        val numbers = InputView.inputWinningNumbers()
        val winningNumbers = LottoProgram.getWinningNumbers(numbers)
    } catch (e: NumberFormatException) {
        throw NullPointerException("숫자만 입력 가능합니다.")
    }
}
