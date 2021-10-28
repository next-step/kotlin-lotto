package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class RewardTest {

    @ParameterizedTest
    @MethodSource("paramsForReward")
    fun `당첨 일치 갯수와 당첨 금액을 리턴한다`(reward: Reward, match: Int, amount: Int, isBonus: Boolean) {
        assertAll(
            { assertThat(reward).isEqualTo(Reward.of(match, isBonus)) },
            { assertThat(reward.amount).isEqualTo(amount) }
        )
    }

    companion object {
        @JvmStatic
        fun paramsForReward(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Reward.FIRST, 6, 2_000_000_000, false),
                Arguments.of(Reward.SECOND, 5, 30_000_000, true),
                Arguments.of(Reward.THIRD, 5, 1_500_000, false),
                Arguments.of(Reward.FOURTH, 4, 50_000, false),
                Arguments.of(Reward.FIFTH, 3, 5_000, false),
                Arguments.of(Reward.NONE, 0, 0, false)
            )
        }
    }
}
