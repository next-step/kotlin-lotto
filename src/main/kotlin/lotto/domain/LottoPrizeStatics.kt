package lotto.domain

import java.math.BigDecimal

class LottoPrizeStatics {

    var profitRate = 0.0
        private set

    var prizedLotto = mutableMapOf(
        Prize.FIFTH to 0, Prize.FOURTH to 0,
        Prize.THIRD to 0, Prize.SECOND to 0, Prize.FIRST to 0
    )
        private set

    fun checkMatches(prizeLotto: Lotto, bonusNumber: LottoNumber?, lottoList: List<Lotto>) {
        val prizedLottoList = lottoList.asSequence()
            .filter { it.getPrize(prizeLotto).prizeMoney > 0 }
        var totalPrizeMoney = prizedLottoList
            .filterNot { it.getPrize(prizeLotto).countOfMatch == Prize.THIRD.countOfMatch }
            .sumBy {
                val prize = it.getPrize(prizeLotto)
                prizedLotto[prize] = prizedLotto[prize]!!.plus(1)
                prize.prizeMoney
            }
        totalPrizeMoney += prizedLottoList.filter { it.getPrize(prizeLotto).countOfMatch == Prize.THIRD.countOfMatch }
            .sumBy {
                val prize = if (it.isContainBonusNumber(bonusNumber)) Prize.SECOND else Prize.THIRD
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
