import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : DescribeSpec({
    describe("문자열 덧셈 계산기") {
        context("빈 문자열을 입력하면") {
            it("0을 반환한다") {
                StringAddCalculator.add("") shouldBe 0
            }
        }
    }
})