package lotto

fun main() {
    val amountOfMoney = InputView.inputAmountOfMoney(LottoProgram.validateMoneyUnit())
    val amountOfLotto = LottoProgram.getAmountOfLotto(amountOfMoney)
    val manualCount = InputView.inputManualLottoCount(amountOfLotto, LottoProgram.validateAmountOfManualLotto())
    val manualLottos =
        InputView.inputManualNumbers(manualCount, LottoProgram.isNotDuplicated(), LottoProgram.isNumbersInRange())
            .map { it }
    val lottos = Lottos.newInstance(amountOfLotto, manualLottos)
    OutputView.showUserLottos(lottos.lottos, manualCount)
    val numbers = InputView.inputWinningNumbers(LottoProgram.isNotDuplicated(), LottoProgram.isNumbersInRange())
    val bonusBall = InputView.inputBonusBall(LottoProgram.isInRange())
    val winningNumbers = WinningNumbers.newInstance(numbers)
    val matchingRanks = lottos.matchLottos(winningNumbers, bonusBall)
    val rateOfReturn = LottoProgram.calculateRateOfReturn(matchingRanks, amountOfMoney)
    OutputView.showResults(matchingRanks, rateOfReturn)
}
