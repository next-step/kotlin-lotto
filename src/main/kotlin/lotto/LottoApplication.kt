package lotto

fun main() {
    val inputView = InputView()
    val price = inputView.inputPrice()
    val number = Purchase(price).count()
    inputView.printNumber(number);

    val lottoNumbersList = mutableListOf<LottoNumbers>()
    for (i in 1..number) {
        val drawSet = LottoMachine().draw()
        println(drawSet)
        lottoNumbersList.add(drawSet)
    }

    val lastWeekWinningNumbers = inputView.inputLastWeekWinningNumbers()

    val statistics = Statistics()
    for (lottoNumbers in lottoNumbersList) {
        val win = lastWeekWinningNumbers.win(lottoNumbers)
        statistics.add(win)
    }

    OutputView().resultPrint(statistics, number * 1000)
}
