package lotto

class LottoMachine {

    fun getRandoms(): List<Int> = LOTTO_NUMBERS.shuffled().subList(0, 6)

    fun calculateStat(lottoNumbers: List<LottoNumber>, prizeNumber: LottoNumber): List<PrizeMoneyWrapper> {
        return lottoNumbers.groupingBy {
            it.equalsCount(prizeNumber)
        }.eachCount().map { PrizeMoneyWrapper(PrizeMoney.generate(it.key), it.value) }
    }

    fun calculateProfit(prizeMoneyWrappers: List<PrizeMoneyWrapper>): Int {
        return prizeMoneyWrappers.sumBy { it.prizeMoney.getProfit(it.prizeCount) }
    }

    fun createLottoNumbers(buyMoney: Int): List<LottoNumber> {
        var lottoNumbers = mutableListOf<LottoNumber>()
        repeat(buyMoney / LOTTO_BASE_PRICE) {
            lottoNumbers.add(LottoNumber(getRandoms()))
        }
        return lottoNumbers
    }

    companion object {
        val LOTTO_NUMBERS = (1..45).toList()
    }
}

fun main() {
    val machime = LottoMachine()

    val inpuView = InputView()
    val buyMoney = inpuView.buyMoney()
    var lottoNumbers = machime.createLottoNumbers(buyMoney)
    val prevPrizNumber = LottoNumber(inpuView.prevPrizeLotto())
    val prizeMoneyWrappers = machime.calculateStat(lottoNumbers, prevPrizNumber)

    val resultView = ResultView()

    resultView.printNumbers(lottoNumbers)
    resultView.printPrizeStat(prizeMoneyWrappers)
    resultView.printProfit(machime.calculateProfit(prizeMoneyWrappers), buyMoney)
}
