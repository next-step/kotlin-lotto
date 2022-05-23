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
    }
})
