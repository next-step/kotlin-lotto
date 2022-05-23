package calculator.vo

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class NumbersTest : DescribeSpec({

    describe("Numbers 클래스 테스트") {

        it("Numbers는 Number 리스트를 가진다.") {
            // given
            val intNumbers = listOf(IntNumber(1), IntNumber(2))

            // when
            val result = Numbers(intNumbers)

            // then
            result shouldBe Numbers(listOf(IntNumber(1), IntNumber(2)))
        }
    }
})
