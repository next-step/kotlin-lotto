package lotto

fun main() {
    val amountOfMoney = InputView.inputAmountOfMoney()
    val amountOfLotto = LottoProgram.getAmountOfLotto(amountOfMoney)
    val manualCount = InputView.inputManualLottoCount(amountOfLotto)
    val manualLottos = InputView.inputManualNumbers(manualCount).map { it }
    val lottos = Lottos.newInstance(amountOfLotto, manualLottos)
    OutputView.showUserLottos(lottos.lottos, manualCount)
    val numbers = InputView.inputWinningNumbers()
    val bonusBall = InputView.inputBonusBall()
    val winningNumbers = WinningNumbers.newInstance(numbers)
    val matchingRanks = lottos.matchLottos(winningNumbers, bonusBall)
    val rateOfReturn = LottoProgram.calculateRateOfReturn(matchingRanks, amountOfMoney)
    OutputView.showResults(matchingRanks, rateOfReturn)
}
