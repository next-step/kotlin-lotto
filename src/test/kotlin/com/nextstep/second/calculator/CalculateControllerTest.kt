package com.nextstep.second.calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculateControllerTest {
    @ParameterizedTest
    @CsvSource(
        "1:2:3, 6",
        "3:5:6, 14"
    )
    fun `메인 테스트`(text: String, answer: Int) {
        // when
        val result = CalculateController.add(text)
        // then
        result shouldBe answer
    }

    @Test
    fun `custom expresssion 메인 테스트`() {
        // given
        val text = "//?\n1?2?3"
        val answer = 6
        // when
        val result = CalculateController.add(text)
        // then
        result shouldBe answer
    }
}
