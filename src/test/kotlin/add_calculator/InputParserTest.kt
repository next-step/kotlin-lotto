package add_calculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class InputParserTest : DescribeSpec({
    describe("InputParser") {
        val inputParser = InputParser()

        context(", 혹은 : 로 구분된 문자열을 입력받으면") {
            val inputString = "3,5:4"
            it("분리된 문자열 배열을 반환한다.") {
                inputParser.parse(inputString) shouldBe listOf("3", "5", "4")
            }
        }
    }
})
