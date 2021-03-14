package lotto.domain

import lotto.vo.*
import kotlin.math.round

const val ROUND_OFF_HUNDRED = 100.0

class LottoCompany {

    lateinit var winnerNumber: WinnerLotto

    fun calculateEarningRate(winners: Winners, totalMoney: Money): Double {
        val beforeRound = winners.getTotalPrizeMoney() / totalMoney.money.toDouble()
        return round(beforeRound * ROUND_OFF_HUNDRED) / ROUND_OFF_HUNDRED
    }

    fun findWinners(lottos: LottoBasket): Winners {
        val winners = mutableListOf<LottoPrize>()
        lottos.lottos.forEach {
            winners.add(it.match(winnerNumber))
        }
        return Winners(winners)
    }

    fun setWinnerNumber(numbers: List<LottoNumber>) {
        winnerNumber = WinnerLotto(numbers)
    }
}
