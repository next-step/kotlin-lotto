package com.nextstep.jngcii.lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("operands")
    fun `구입한 로또의 갯수에 대하여 총 수익률을 계산`(
        count: Int,
        ranks: List<Rank>,
        expected: Double
    ) {
        val actual: Double = Calculator.calculateYield(count, ranks)

        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun operands() = listOf(
            Arguments.of(14, listOf(Rank.FOURTH), 0.35),
            Arguments.of(10, listOf(Rank.THIRD, Rank.THIRD), 10.0),
        )
    }
}
