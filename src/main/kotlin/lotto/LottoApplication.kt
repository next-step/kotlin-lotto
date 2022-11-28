package lotto

fun main() {
    val price = InputView.inputPrice()
    val number = Purchase(price).count()
    OutputView.printNumber(number)

    val lottoNumbersList = mutableListOf<LottoNumbers>()
    for (i in 1..number) {
        val drawSet = LottoMachine().draw()
        lottoNumbersList.add(drawSet)
    }

    for (lottoNumbers in lottoNumbersList) {
        OutputView.print(lottoNumbers)
    }

    val lastWeekWinningNumbers = InputView.inputLastWeekWinningNumbers()

    val statistics = Statistics()
    for (lottoNumbers in lottoNumbersList) {
        val win = lastWeekWinningNumbers.win(lottoNumbers)
        statistics.add(win)
    }

    OutputView.resultPrint(statistics, Price(number).price())
}
