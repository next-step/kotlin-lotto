package lotto.domain

import java.math.BigDecimal

class LottoPrizeStatics {

    var profitRate = 0.0
        private set

    var prizedLotto = mutableMapOf(
        Prize.MATCH_THREE to 0, Prize.MATCH_FOUR to 0,
        Prize.MATCH_FIVE to 0, Prize.MATCH_FIVE_WITH_BONUS to 0, Prize.MATCH_ALL to 0
    )
        private set

    fun checkMatches(prizeLotto: Lotto, bonusNumber: LottoNumber, lottoList: List<Lotto>) {
        val prizedLottoList = lottoList.asSequence()
            .filter { it.getPrize(prizeLotto).prizeMoney > 0 }
        val totalPrizeMoney = prizedLottoList
            .sumBy {
                val prize = it.getPrize(prizeLotto)
                prizedLotto[prize] = prizedLotto[prize]!!.plus(1)
                prize.prizeMoney
            }
        calculateProfitRate(lottoList.size, totalPrizeMoney)
    }

    private fun calculateProfitRate(count: Int, totalPrizeMoney: Int) {
        profitRate = totalPrizeMoney.toBigDecimal()
            .divide((count * PRICE_OF_LOTTO).toBigDecimal(), 2, BigDecimal.ROUND_HALF_EVEN)
            .stripTrailingZeros().toDouble()
    }
}
