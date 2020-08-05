package lotto

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        val machine = LottoMachine()
        val buyMoney = InputView.buyMoney()

        var lottoes = machine.createLottoes(buyMoney.divide(LOTTO_BASE_PRICE))
        ResultView.printNumbers(lottoes)

        val prizeLottoNumbers = InputView.prevPrizeLotto()
        val prizeLotto = machine.createLotto(prizeLottoNumbers)
        val prizeMoneyWrappers = machine.calculateStat(lottoes, prizeLotto)
        ResultView.printPrizeStat(prizeMoneyWrappers)

        val profitCalculator = ProfitCalculator()

        val totalPrizeMoney = profitCalculator.calculateProfit(prizeMoneyWrappers)
        val rateProfit = totalPrizeMoney.rate(buyMoney.money)
        ResultView.printProfit(rateProfit)
    }
}
