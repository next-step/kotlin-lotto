package lotto

class LottoMachine {

    fun getRandoms(): List<Int> = LOTTO_NUMBERS.shuffled().subList(0, 5)

    fun calculateStat(lottoNumbers: List<LottoNumber>, prizeNumber: LottoNumber): List<PrizeMoneyWrapper> {
        return lottoNumbers.groupingBy {
            it.equalsCount(prizeNumber)
        }.eachCount().map { PrizeMoneyWrapper(PrizeMoney.generate(it.key), it.value) }
    }

    fun calculateProfit(prizeMoneyWrappers: List<PrizeMoneyWrapper>): Int {
        return prizeMoneyWrappers.sumBy { it.prizeMoney.getProfit(it.prizeCount) }
    }

    companion object {
        val LOTTO_NUMBERS = (1..45).toList()
    }
}
