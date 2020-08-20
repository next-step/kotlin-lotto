package lotto.domain

import java.math.BigDecimal

class LottoPrizeStatics {

    var profitRate = 0.0
        private set

    val prizedLotto: MutableMap<Prize, Int> =
        mutableMapOf(Prize.FIFTH to 0, Prize.FOURTH to 0, Prize.THIRD to 0, Prize.SECOND to 0, Prize.FIRST to 0)

    fun calculateResult(winningLotto: WinningLotto, lottoList: List<Lotto>) {
        val prizeLotto = winningLotto.prizeLotto
        val prizedLottoList = lottoList.filter { it.getPrize(prizeLotto).prizeMoney > 0 }
        val totalPrizeMoney = calculateTotalPrizeMoney(prizedLottoList, winningLotto)
        calculateProfitRate(lottoList.size, totalPrizeMoney)
    }

    private fun calculateTotalPrizeMoney(prizedLottoList: List<Lotto>, winningLotto: WinningLotto): Int =
        calculatePrizeMoneyMatchFive(prizedLottoList, winningLotto) + calculatePrizeMoneyExceptMatchFive(prizedLottoList, winningLotto)

    private fun calculatePrizeMoneyMatchFive(prizedLottoList: List<Lotto>, winningLotto: WinningLotto): Int {
        val prizeLotto = winningLotto.prizeLotto
        val bonusNumber = winningLotto.bonusNumber
        return prizedLottoList.filter { it.getPrize(prizeLotto).countOfMatch == Prize.THIRD.countOfMatch }
            .sumBy {
                val prize = if (it.isContainNumber(bonusNumber)) Prize.SECOND else Prize.THIRD
                prizedLotto[prize] = prizedLotto[prize]!!.plus(1)
                prize.prizeMoney
            }
    }

    private fun calculatePrizeMoneyExceptMatchFive(prizedLottoList: List<Lotto>, winningLotto: WinningLotto): Int {
        val prizeLotto = winningLotto.prizeLotto
        return prizedLottoList
            .filterNot { it.getPrize(prizeLotto).countOfMatch == Prize.THIRD.countOfMatch }
            .sumBy {
                val prize = it.getPrize(prizeLotto)
                prizedLotto[prize] = prizedLotto[prize]!!.plus(1)
                prize.prizeMoney
            }
    }

    private fun calculateProfitRate(count: Int, totalPrizeMoney: Int) {
        profitRate = totalPrizeMoney.toBigDecimal()
            .divide((count * PRICE_OF_LOTTO).toBigDecimal(), 2, BigDecimal.ROUND_HALF_EVEN)
            .stripTrailingZeros().toDouble()
    }
}
