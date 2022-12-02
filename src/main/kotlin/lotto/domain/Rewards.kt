package lotto.domain

class Rewards(val reward: List<Reward>) {
    fun calculateProfit(money: Int): Float {
        val reward = sum()
        return (reward - money) / money
    }
    private fun sum(): Float = reward.sumOf { it.reward }.toFloat()
}
