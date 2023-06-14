package com.nextstep.second.calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class MainTest {
    @ParameterizedTest
    @CsvSource(
        "1:2:3, 6",
        "3:5:6, 14"
    )
    fun `메인 테스트`(text:String, answer: Int) {
        // when
        val parsedNumList = ExpressionParser.parse(text, normalTokenize)
        val result = Calculator.add(parsedNumList)

        // then
        result shouldBe answer
    }

    @Test
    fun `custom expresssion 메인 테스트`() {
        // given
        val text = "//?\n1?2?3"
        val answer = 6
        // when
        val parsedNumList = ExpressionParser.parse(text, customTokenize)
        val result = Calculator.add(parsedNumList)

        // then
        result shouldBe answer
    }
}