package lotto

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val price = inputView.inputPrice()
    val number = Purchase(price).count()
    outputView.printNumber(number)

    val lottoNumbersList = mutableListOf<LottoNumbers>()
    for (i in 1..number) {
        val drawSet = LottoMachine().draw()
        lottoNumbersList.add(drawSet)
    }

    for (lottoNumbers in lottoNumbersList) {
        outputView.print(lottoNumbers)
    }

    val lastWeekWinningNumbers = inputView.inputLastWeekWinningNumbers()

    val statistics = Statistics()
    for (lottoNumbers in lottoNumbersList) {
        val win = lastWeekWinningNumbers.win(lottoNumbers)
        statistics.add(win)
    }

    OutputView().resultPrint(statistics, number * 1000)
}
