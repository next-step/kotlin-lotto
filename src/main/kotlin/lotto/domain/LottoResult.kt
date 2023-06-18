package lotto.domain

import lotto.domain.Money.Companion.toMoney

data class LottoResult(
    val lotto: Lotto,
    val winningLotto: Lotto
) {
    val sameNumberCount: Int = winningLotto.getSameNumberCount(lotto)

    val reward: LottoReward? = LottoReward.getReward(sameNumberCount)
}

enum class LottoReward(val prize: Long, val sameNumberCount: Int) {
    WINNER_1ST(2000L.millionWon(), 6),
    WINNER_2ST(1500L.thousandWon(), 5),
    WINNER_3ST(50L.thousandWon(), 4),
    WINNER_4ST(5L.thousandWon(), 3);

    fun toMoney(): Money = prize.toMoney()

    companion object {
        fun getReward(sameNumberCount: Int): LottoReward? = values().firstOrNull { sameNumberCount == it.sameNumberCount }
    }
}

private fun Long.thousandWon(): Long = this * 1000L

private fun Long.millionWon(): Long = this.thousandWon().thousandWon()
