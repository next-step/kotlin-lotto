package com.nextstep.second.calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    internal fun `주어진 배열에 각 요소를 더한다`() {
        // given
        val inputNumberList = listOf(1, 2, 3)
        val answer = 6

        // when
        val result = Calculator.add(inputNumberList)

        // then
        result shouldBe answer
    }

    @Test
    internal fun `빈 배열을 더하면 0 을 반환한다`() {
        // given
        val inputNumberList = emptyList<Int>()
        val answer = 0

        // when
        val result = Calculator.add(inputNumberList)

        // then
        result shouldBe answer
    }
}