package lotto.domain

import java.math.BigDecimal

class LottoPrizeStatics(winningLotto: WinningLotto, lottoList: List<Lotto>) {
    init {
        val prizeLotto = winningLotto.prizeLotto
        val prizedLottoList = lottoList.filter { it.getCountOfMatchNumber(prizeLotto) >= Prize.FIFTH.countOfMatch }
        val totalPrizeMoney = calculateTotalPrizeMoney(prizedLottoList, winningLotto)
        calculateProfitRate(lottoList.size, totalPrizeMoney)
    }

    var profitRate = 0.0
        private set

    private val prizedLotto: MutableMap<Prize, Int> =
        mutableMapOf(Prize.FIFTH to 0, Prize.FOURTH to 0, Prize.THIRD to 0, Prize.SECOND to 0, Prize.FIRST to 0)

    val prizedLottoList = prizedLotto.toMap()

    private fun calculateTotalPrizeMoney(prizedLottoList: List<Lotto>, winningLotto: WinningLotto): Int =
        calculatePrizeMoneyMatchFive(
            prizedLottoList,
            winningLotto
        ) + calculatePrizeMoneyExceptMatchFive(prizedLottoList, winningLotto)

    private fun calculatePrizeMoneyMatchFive(prizedLottoList: List<Lotto>, winningLotto: WinningLotto): Int {
        val prizeLotto = winningLotto.prizeLotto
        val bonusNumber = winningLotto.bonusNumber
        return prizedLottoList.filter { it.getCountOfMatchNumber(prizeLotto) == Prize.THIRD.countOfMatch }
            .sumBy {
                val prize = Prize.getPrize(it.getCountOfMatchNumber(prizeLotto), it.isContainNumber(bonusNumber))
                prizedLotto[prize] = prizedLotto[prize]!!.plus(1)
                prize.prizeMoney
            }
    }

    private fun calculatePrizeMoneyExceptMatchFive(prizedLottoList: List<Lotto>, winningLotto: WinningLotto): Int {
        val prizeLotto = winningLotto.prizeLotto
        return prizedLottoList
            .filterNot { it.getCountOfMatchNumber(prizeLotto) == Prize.THIRD.countOfMatch }
            .sumBy {
                val prize = Prize.getPrize(it.getCountOfMatchNumber(prizeLotto))
                println(prize)
                prizedLotto[prize] = prizedLotto[prize]!!.plus(1)
                prize.prizeMoney
            }
    }

    private fun calculateProfitRate(count: Int, totalPrizeMoney: Int) {
        if(count == 0) return
        profitRate = totalPrizeMoney.toBigDecimal()
            .divide((count * PRICE_OF_LOTTO).toBigDecimal(), 2, BigDecimal.ROUND_HALF_EVEN)
            .stripTrailingZeros().toDouble()
    }
}
