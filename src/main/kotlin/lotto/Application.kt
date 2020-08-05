package lotto

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        val machine = LottoMachine()
        val buyMoney = InputView.buyMoney()

        var lottoes = machine.createLottoNumbers(buyMoney.divide(LOTTO_BASE_PRICE))
        ResultView.printNumbers(lottoes)

        val prizeLotto = Lotto(InputView.prevPrizeLotto())
        val prizeMoneyWrappers = machine.calculateStat(lottoes, prizeLotto)
        ResultView.printPrizeStat(prizeMoneyWrappers)

        val totalPrizeMoney = machine.calculateProfit(prizeMoneyWrappers)
        val rateProfit = machine.calculateRateOfProfit(totalPrizeMoney, buyMoney.divide(LOTTO_BASE_PRICE))
        ResultView.printProfit(rateProfit)
    }
}
