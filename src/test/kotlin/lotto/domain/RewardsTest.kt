package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RewardsTest {

    @Test
    fun `총 상금 금액을 반환합니다`(){
        val rewards = Rewards(listOf(Reward.FIRST_RANK , Reward.THIRD_RANK , Reward.NO_RANK))

        assertThat(rewards.sum()).isEqualTo(Reward.FIRST_RANK.reward + Reward.THIRD_RANK.reward.toFloat())
    }
}
