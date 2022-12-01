package lotto.domain

class ProfitCalculator {

    fun calculateProfit(rewards: Rewards, money: Int): Float {
        val reward = rewards.sum()
        return (reward - money) / money
    }
}
