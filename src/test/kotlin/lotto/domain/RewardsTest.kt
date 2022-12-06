package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RewardsTest {

    @Test
    fun `총 상금 금액을 반환합니다`() {
        val rewards = Rewards(listOf(Reward.FIRST_RANK, Reward.THIRD_RANK, Reward.NO_RANK))

        val result = rewards.calculateProfit(1000)

        assertThat(result).isEqualTo((Reward.FIRST_RANK.reward + Reward.THIRD_RANK.reward - 1000) / 1000.toFloat())
    }
}
