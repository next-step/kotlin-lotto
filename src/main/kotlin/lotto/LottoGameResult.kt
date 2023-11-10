package lotto

import java.text.DecimalFormat

data class LottoGameResult(val totalPrice: Int, val rewards: List<LottoReward>) {
    fun calculatePerformance(): Double =
        rewards.getAmount().toDouble() / totalPrice

    fun getRewardCount(reward: LottoReward): Int =
        rewards.count { it == reward }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        LottoReward.values().reversed().forEach {
            val rewardCount = getRewardCount(it)
            stringBuilder
                .append("${it.matchCount}개 일치 (${it.reward}원) - ${rewardCount}개")
                .append("\n")
        }
        val performance = DecimalFormat("#,###.00").format(calculatePerformance())
        stringBuilder.append("총 수익률은 ${performance}입니다.")
        return stringBuilder.toString()
    }
}
