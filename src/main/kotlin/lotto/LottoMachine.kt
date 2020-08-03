package lotto

class LottoMachine {

    fun getRandoms(): List<Int> = LOTTO_NUMBERS.shuffled().subList(0, 5)

    fun calculateStat(lottoNumbers: List<LottoNumber>, prizeNumber: LottoNumber): Map<Int, Int> {
        return lottoNumbers.groupingBy {
            it.equalsCount(prizeNumber)
        }
            .eachCount()
    }

    fun calculateProfit(rankAndCount: Map<Int, Int>): Int {
        return rankAndCount.map {
            PrizeMoney.generate(it.key).getProfit(it.value)
        }.sum()
    }

    companion object {
        val LOTTO_NUMBERS = (1..45).toList()
    }
}
