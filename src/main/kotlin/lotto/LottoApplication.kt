package lotto

fun main() {
    val price = InputView.inputPrice()
    val number = Purchase(price).count()

    OutputView.printNumber(number)

    val lottoNumbersList = mutableListOf<LottoNumbers>()
    drawLottoNumber(number, lottoNumbersList)

    printLottoNumbersList(lottoNumbersList)

    val lastWeekWinningNumbers = InputView.inputLastWeekWinningNumbers()
    val bonusNumber = InputView.inputBonusNumber()

    val statistics = Statistics()
    val pickWinningNumber = pickWinningNumber(lottoNumbersList, lastWeekWinningNumbers, statistics, bonusNumber)

    OutputView.resultPrint(pickWinningNumber, Price(number).price())
}

private fun pickWinningNumber(
    lottoNumbersList: MutableList<LottoNumbers>,
    lastWeekWinningNumbers: WinningLottoNumbers,
    statistics: Statistics,
    bonusNumber: LottoNumber,
): Statistics {
    for (lottoNumbers in lottoNumbersList) {
        val win = lastWeekWinningNumbers.win(lottoNumbers, bonusNumber)
        statistics.add(win)
    }
    return statistics
}

private fun drawLottoNumber(number: Int, lottoNumbersList: MutableList<LottoNumbers>) {
    for (i in 1..number) {
        val drawSet = LottoMachine().draw()
        lottoNumbersList.add(drawSet)
    }
}

private fun printLottoNumbersList(lottoNumbersList: MutableList<LottoNumbers>) {
    for (lottoNumbers in lottoNumbersList) {
        OutputView.print(lottoNumbers)
    }
}
