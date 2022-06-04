package com.nextstep.jngcii.lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @ParameterizedTest
    @ValueSource(
        ints =
        [-1, -10, -1000, -1234]
    )
    fun `구입금액이 음수일 경우 예외 발생`(payment: Int) {
        assertThrows<IllegalArgumentException>("구입금액이 음수일 수 없습니다") {
            Calculator.calculateLottoCount(payment)
        }
    }

    @ParameterizedTest
    @CsvSource(
        "1000, 1",
        "20000, 20",
        "1234, 1",
        "1, 0",
    )
    fun `구입금액이 양수일 경우 반환값 확인`(payment: Int, expected: Int) {
        val count = Calculator.calculateLottoCount(payment)

        assertThat(count).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("operands")
    fun `구입한 로또의 갯수에 대하여 총 수익률을 계산`(
        count: Int,
        ranks: List<Rank>,
        expected: Double
    ) {
        val actual: Double = Calculator.calculateYield(count, Ranks(ranks))

        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun operands() = listOf(
            Arguments.of(14, listOf(Rank.FIFTH), 0.35),
            Arguments.of(10, listOf(Rank.FOURTH, Rank.FOURTH), 10.0),
        )
    }
}
