package lotto

fun main() {
    try {
        val amountOfMoney = InputView.inputAmountOfMoney()
        val amountOfLotto = LottoProgram.getAmountOfLotto(amountOfMoney)
        val lottos = Lottos(amountOfLotto)
        OutputView.showUserLottos(lottos.lottos)
        val numbers = InputView.inputWinningNumbers()
        val winningNumbers = WinningNumbers.getInstance(numbers)
        val result = LottoProgram.matchLottos(lottos, winningNumbers)
        val rateOfReturn = LottoProgram.calculateRateOfReturn(result, amountOfMoney)
        OutputView.showResults(result, rateOfReturn)
    } catch (e: NumberFormatException) {
        throw NullPointerException("숫자만 입력 가능합니다.")
    }
}
