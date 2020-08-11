package lotto

fun main() {
    try {
        val amountOfMoney = InputView.inputAmountOfMoney()
        val amountOfLotto = LottoProgram.getAmountOfLotto(amountOfMoney)
        val lottos = Lottos(amountOfLotto)
        OutputView.showUserLottos(lottos.getLottos())
        val numbers = InputView.inputWinningNumbers()
        val winningNumbers = WinningNumbers.getInstance(numbers)
        val matchingRanks = lottos.matchLottos(winningNumbers)
        val rateOfReturn = LottoProgram.calculateRateOfReturn(matchingRanks, amountOfMoney)
        OutputView.showResults(matchingRanks, rateOfReturn)
    } catch (e: NumberFormatException) {
        throw NullPointerException("숫자만 입력 가능합니다.")
    }
}
