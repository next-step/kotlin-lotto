package lotto.domain

class Rewards(val reward: List<Reward>) {

    fun sum(): Float = reward.sumOf { it.reward }.toFloat()

}
