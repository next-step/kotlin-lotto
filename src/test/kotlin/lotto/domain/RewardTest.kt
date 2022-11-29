package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RewardTest {

    @Test
    fun `매치된 숫자개수에 맞는 상금금액이 반한됩니다`() {
        assertThat(Reward.getReward(3, false)).isEqualTo(Reward.FIFTH_RANK)
        assertThat(Reward.getReward(0, false)).isEqualTo(Reward.NO_RANK)
        assertThat(Reward.getReward(5, true)).isEqualTo(Reward.SECOND_RANK)
    }
}
