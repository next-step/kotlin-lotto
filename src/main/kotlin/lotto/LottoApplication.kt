package lotto

fun main() {
    val inputView = InputView()
    val price = inputView.inputPrice()

    val lottoNumbersList = mutableListOf<LottoNumbers>()
    for (i in 1..price) {
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

    OutputView().resultPrint(statistics, price * 1000)
}
