package lotto

class LottoMachine {

    private fun getRandoms(): List<Int> = LOTTO_NUMBERS.shuffled().subList(0, 6)

    fun calculateStat(lottoes: List<Lotto>, prizeLotto: Lotto): List<PrizeMoneyWrapper> {
        return lottoes
            .groupingBy {
                it.equalsCount(prizeLotto)
            }.eachCount().filter { it.key > 3 }.map { PrizeMoneyWrapper(PrizeMoney.generate(it.key), it.value) }
    }

    fun calculateProfit(prizeMoneyWrappers: List<PrizeMoneyWrapper>): Int {
        return prizeMoneyWrappers.sumBy { it.calculatePrizeMoney() }
    }

    fun calculateRateOfProfit(totalPrizeMoney: Int, buyMoney: Int): Double {
        return totalPrizeMoney.toDouble() / buyMoney.toDouble()
    }

    fun createLottoNumbers(buyMoney: Int): List<Lotto> {
        var lottoNumbers = mutableListOf<Lotto>()
        repeat(buyMoney / LOTTO_BASE_PRICE) {
            lottoNumbers.add(Lotto(getRandoms()))
        }
        return lottoNumbers
    }

    companion object {
        val LOTTO_NUMBERS = (1..45).toList()
    }
}

fun main() {
}
