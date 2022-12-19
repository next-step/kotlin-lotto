package lotto.domain

data class LottoRewards(
    private val rewards: List<LottoReward>
) {

    fun exchange(): Cash {
        val money = rewards.fold(0) { total, current ->
            total + current.reward
        }
        return Cash(money)
    }

    fun getByGroup(): Map<LottoReward, Int> {
        return rewards.groupingBy { it }.eachCount()
    }
}
