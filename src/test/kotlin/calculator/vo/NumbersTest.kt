package calculator.vo

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class NumbersTest : DescribeSpec({

    describe("Numbers 클래스 테스트") {

        it("Numbers은 소유한 IntNumbers의 덧셈 결과를 반환한다.") {
            // given
            val intNumbers = listOf(IntNumber(1), IntNumber(2))

            // when
            val result = Numbers(intNumbers).sum()

            // then
            result shouldBe IntNumber(3)
        }
    }
})
