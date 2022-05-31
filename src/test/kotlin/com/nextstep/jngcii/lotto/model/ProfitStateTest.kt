package com.nextstep.jngcii.lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class ProfitStateTest {
    @ParameterizedTest
    @MethodSource("comparisons")
    fun `수익률에 따라 손익을 확인`(rewardYield: Double, state: Int) {
        val actual: ProfitState = ProfitState.of(rewardYield)
        val expected: ProfitState = ProfitState.of(state)

        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(ints = [-2, 2, 5])
    fun `잘못된 state에 대한 enum을 찾을 수 없음`(state: Int) {
        assertThrows<IllegalArgumentException>("잘못된 state 입니다.") {
            ProfitState.of(state)
        }
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
