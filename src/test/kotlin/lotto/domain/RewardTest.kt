package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RewardTest {

    @Test
    fun `매치된 숫자개수에 맞는 상금금액이 반한됩니다`() {
        assertThat(Reward.getReward(3)).isEqualTo(5000)
        assertThat(Reward.getReward(0)).isEqualTo(0)
    }
}
