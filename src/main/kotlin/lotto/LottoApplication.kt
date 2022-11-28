package lotto

fun main() {
    val price = InputView.inputPrice()
    val number = Purchase(price).count()

    OutputView.printNumber(number)

    val lottoNumbersList = mutableListOf<LottoNumbers>()
    drawLottoNumber(number, lottoNumbersList)

    printLottoNumbersList(lottoNumbersList)

    val lastWeekWinningNumbers = InputView.inputLastWeekWinningNumbers()

    val statistics = Statistics()
    prickWinningNumber(lottoNumbersList, lastWeekWinningNumbers, statistics)

    OutputView.resultPrint(statistics, Price(number).price())
}

private fun prickWinningNumber(
    lottoNumbersList: MutableList<LottoNumbers>,
    lastWeekWinningNumbers: WinningLottoNumbers,
    statistics: Statistics
) {
    for (lottoNumbers in lottoNumbersList) {
        val win = lastWeekWinningNumbers.win(lottoNumbers)
        statistics.add(win)
    }
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
