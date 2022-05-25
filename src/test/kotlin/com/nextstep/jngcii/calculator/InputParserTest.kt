package com.nextstep.jngcii.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class InputParserTest {
    @Test
    fun `커스텀구분자테스트 - 구분자를 파싱했다면 listOf("구분자")를 만들어 반환`() {
        val input = "//*\n2/1*5,3"

        val (expression, delimiter) = InputParser.parseDelimiter(input)

        assertThat(expression).isEqualTo("2/1*5,3")
        assertThat(delimiter).isEqualTo("*")
    }

    @Test
    fun `커스텀구분자테스트 - 구분자를 파싱하지 못했다면 null 반환`() {
        val input = "/d\n2/1*5,3"

        val (expression, delimiter) = InputParser.parseDelimiter(input)

        assertThat(expression).isEqualTo(input)
        assertThat(delimiter).isNull()
    }

    @Test
    fun `커스텀구분자테스트 - 구분자 파싱 위치에 알파벳이 존재하면 listOf(알파벳)를 반환`() {
        val input = "//a\n2/1*5,3"

        val (expression, delimiter) = InputParser.parseDelimiter(input)

        assertThat(expression).isEqualTo("2/1*5,3")
        assertThat(delimiter).isEqualTo("a")
    }

    @Test
    fun `커스텀구분자테스트 - 구분자 파싱 위치에 숫자가 존재하면 null 반환`() {
        val input = "//3\n2/1*5,3"

        val (expression, delimiter) = InputParser.parseDelimiter(input)

        assertThat(expression).isEqualTo(input)
        assertThat(delimiter).isNull()
    }

    @ParameterizedTest
    @ValueSource(strings = ["?", "/", "d", ".", "!"])
    fun `표현식파싱테스트 - 전달받은 delimiter를 사용하여 파싱하는 것 테스트`(delimiter: String) {
        val expression = "1${delimiter}2${delimiter}3"

        val actual = InputParser.parseExpression(expression, delimiter)

        assertThat(actual).isEqualTo(listOf(1, 2, 3))
    }

    @ParameterizedTest
    @ValueSource(strings = ["?", "/", "d", ".", "!"])
    fun `표현식파싱테스트 - 표현식에 전달받은 delimiter가 아닌 delimiter가 포함된 경우 파싱 예외 테스트`(delimiter: String) {
        val expression = "1:2,3"

        assertThrows<IllegalArgumentException>("부적절한 계산식입니다.") {
            InputParser.parseExpression(expression, delimiter)
        }
    }

    @Test
    fun `표현식파싱테스트 - 전달받은 delimiter가 null일 때 comma와 colon으로 파싱하는 것 테스트`() {
        val expression = "1:2,3"
        val delimiter = null

        val actual = InputParser.parseExpression(expression, delimiter)

        assertThat(actual).isEqualTo(listOf(1, 2, 3))
    }

    @ParameterizedTest
    @ValueSource(strings = ["?", "/", "d", ".", "!"])
    fun `표현식파싱테스트 - 전달받은 delimiter가 null일 때 표현식에 comma,colon 이외의 delimiter가 포함된 경우 파싱 예외 테스트`() {
        val expression = "1|2,3"
        val delimiter = null

        assertThrows<IllegalArgumentException>("부적절한 계산식입니다.") {
            InputParser.parseExpression(expression, delimiter)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2:3", "//a\n1a2a3"])
    fun `파싱 통합테스트 - 파싱성공 테스트`(input: String) {
        val (expression, delimiter) = InputParser.parseDelimiter(input)
        val actual = InputParser.parseExpression(expression, delimiter)

        assertThat(actual).isEqualTo(listOf(1, 2, 3))
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2.3", "//a\n1b2*3"])
    fun `파싱 통합테스트 - 파싱실패 테스트`() {
        val input = "1,2.3"

        val (expression, delimiter) = InputParser.parseDelimiter(input)

        assertThrows<IllegalArgumentException>("부적절한 계산식입니다.") {
            InputParser.parseExpression(expression, delimiter)
        }
    }

    @Test
    fun `파싱 통합테스트 - 음수 파싱 실패 테스트`() {
        val input = "1,-2:3"

        val (expression, delimiter) = InputParser.parseDelimiter(input)

        assertThrows<IllegalArgumentException>("양의 정수만 입력 가능합니다.") {
            InputParser.parseExpression(expression, delimiter)
        }
    }

    @Test
    fun `파싱 통합테스트 - 기본 구분자로 파싱 테스트 - 숫자 한개`() {
        val input = "1"

        val (expression, delimiter) = InputParser.parseDelimiter(input)
        val actual = InputParser.parseExpression(expression, delimiter)

        assertThat(actual).isEqualTo(listOf(1))
    }
}
