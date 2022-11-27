package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RewardTest {

    @Test
    fun `매치된 숫자개수에 맞는 상금금액이 반한됩니다`() {
        assertThat(Reward.getReward(3)).isEqualTo(Reward.FOURTH_RANK)
        assertThat(Reward.getReward(0)).isEqualTo(Reward.NO_RANK)
    }
}
