package lotto.domain

import java.math.RoundingMode
import java.text.DecimalFormat

class LottoStatics {

    private val earningRateFormat = DecimalFormat("#.##").apply {
        roundingMode = RoundingMode.DOWN
    }
    private val winningGrade: WinningGrade = WinningGrade()
    private var earningRate: Float = 0f

    fun makeStatics(amount: Int, rewards: List<Reward>): Pair<WinningGrade, Float> {
        var totalReward = 0

        rewards.forEach { reward ->
            totalReward += reward.reward
            makeWinningGrade(winningGrade, reward)
        }

        earningRate = makeEarningRate(totalReward.toFloat(), amount.toFloat())

        return winningGrade to earningRate
    }

    fun makeEarningRate(reward: Float, amount: Float): Float {
        return earningRateFormat.format(reward.div(amount)).toFloat()
    }

    private fun makeWinningGrade(grade: WinningGrade, reward: Reward) {
        when (reward.matchingCount) {
            3 -> grade.three++
            4 -> grade.four++
            5 -> grade.five++
            6 -> grade.six++
        }
    }
}
