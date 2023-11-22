package lotto.domain

import lotto.data.LottoRanking
import java.util.EnumMap

object LottoCalculator {

    private const val ERR_MSG_OVER_MANUAL_GAME_TIMES = "수동 게임 횟수가 총 게임 횟수를 초과하였습니다."

    fun calculateWinningRate(cash: Int, winningStatus: EnumMap<LottoRanking, Int>): Float {
        val totalPrice = winningStatus.toList().sumOf { it.first.findPrize(it) }

        return totalPrice / cash.toFloat()
    }

    fun getTimes(cash: Int, gameCost: Int): Int {
        return cash / gameCost
    }

    fun getAutoTimes(totalTimes: Int, manualGameTimes: Int): Int {
        require(totalTimes >= manualGameTimes) { ERR_MSG_OVER_MANUAL_GAME_TIMES }
        return totalTimes - manualGameTimes
    }
}
