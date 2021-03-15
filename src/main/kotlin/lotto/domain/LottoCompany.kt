package lotto.domain

import lotto.vo.LottoNumber
import lotto.vo.Money
import lotto.vo.Statistics
import lotto.vo.WinningLotto
import kotlin.math.round

const val ROUND_OFF_HUNDRED = 100.0

class LottoCompany {

    lateinit var winningNumber: WinningLotto

    fun calculateEarningRate(statistics: Statistics, totalMoney: Money): Double {
        val beforeRound = statistics.getTotalPrizeMoney() / totalMoney.money.toDouble()
        return round(beforeRound * ROUND_OFF_HUNDRED) / ROUND_OFF_HUNDRED
    }

    fun findWinners(lottos: LottoBasket): Statistics {
        val winningStats = lottos.match(winningNumber)
        return Statistics(winningStats)
    }

    fun setWinnerNumber(numbers: Set<LottoNumber>) {
        winningNumber = WinningLotto(numbers)
    }
}
