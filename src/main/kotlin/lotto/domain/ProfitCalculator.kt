package lotto.domain

class ProfitCalculator {

    fun calculateProfit(rewards: List<Reward>, money: Int): Float {
        val reward = rewards.sumOf { it.reward }
        return (reward - money) / money.toFloat()
    }
}
