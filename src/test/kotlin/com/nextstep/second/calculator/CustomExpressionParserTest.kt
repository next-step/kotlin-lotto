package com.nextstep.second.calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CustomExpressionParserTest {
    @Test
    fun `입력받은 스트링 문자열을 List 로 반환해준다`() {
        // given
        val input = "//;\n1;2;3"
        input shouldBe input

        // when
        val parsedExp = CustomExpressionParser(input)
        val parsedNumberList = parsedExp.numberList
        // then
        parsedNumberList.size shouldBe 3
        parsedNumberList.contains(1) shouldBe true
        parsedNumberList.contains(2) shouldBe true
        parsedNumberList.contains(3) shouldBe true
    }

    @Test
    fun `입력받은 스트링 문자열이 형식에 맞지 않아서 예외를 발생`() {
        // given
        val input = "//;\n1;2,3"

        // when
        assertThrows<IllegalArgumentException> { CustomExpressionParser(input) }
    }

    @Test
    fun `Int 로 파싱되지 않아서 예외를 발생`() {
        // given
        val input = "//;\n1;b;a"

        // when
        assertThrows<IllegalArgumentException> { CustomExpressionParser(input) }
    }

    @Test
    fun `음수가 포함되어 있어서 예외를 발생`() {
        // given
        val input = "//;\n-1;2;3"

        // when
        assertThrows<IllegalStateException> { CustomExpressionParser(input) }
    }
}