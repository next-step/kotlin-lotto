package calculator.domain

import calculator.vo.IntNumber
import calculator.vo.Numbers
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class ParserTest : DescribeSpec({

    describe("Parser 클래스 테스트") {

        it("구분자를 가진 식을 분석하여 Numbers 객체를 반환한다.") {
            // given
            val expression = "1,3,2,1"

            // when
            val result = Parser.parse(expression)

            // then
            result shouldBe Numbers(listOf(IntNumber(1), IntNumber(3), IntNumber(2), IntNumber(1)))
        }

        it("빈 문자열을 준 경우 0만 있는 Numbers 객체를 반환한다.") {
            // given
            val expression = ""

            // when
            val result = Parser.parse(expression)

            // then
            result shouldBe Numbers(listOf(IntNumber(0)))
        }

        it("null을 준 경우 0만 있는 Numbers 객체를 반환한다.") {
            // given
            val expression = null

            // when
            val result = Parser.parse(expression)

            // then
            result shouldBe Numbers(listOf(IntNumber(0)))
        }

        it("한자리 숫자 문자열을 준 경우 해당 숫자를 가진 Numbers 객체를 반환한다.") {
            // given
            val expression = "1"

            // when
            val result = Parser.parse(expression)

            // then
            result shouldBe Numbers(listOf(IntNumber(1)))
        }

        it("커스텀 구분자를 지정할 수 있다.") {
            // given
            val expression = "//;\n1;2"

            // when
            val result = Parser.parse(expression)

            // then
            result shouldBe Numbers(listOf(IntNumber(1), IntNumber(2)))
        }
    }
})
