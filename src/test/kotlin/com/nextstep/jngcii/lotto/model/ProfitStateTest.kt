package com.nextstep.jngcii.lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class ProfitStateTest {
    @ParameterizedTest
    @MethodSource("comparisons")
    fun `수익률에 따라 손익을 확인`(rewardYield: Double, state: Int) {
        val actual: ProfitState = ProfitState.of(rewardYield)
        val expected: ProfitState = ProfitState.of(state)

        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun comparisons() = listOf(
            Arguments.of(1.0, 0),
            Arguments.of(1.01, 1),
            Arguments.of(0.35, -1),
            Arguments.of(0, -1),
            Arguments.of(10, 1),
        )
    }
}
