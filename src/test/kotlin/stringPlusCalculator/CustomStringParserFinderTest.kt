package stringPlusCalculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
class CustomStringParserFinderTest : DescribeSpec({
    describe("커스텀 문자열 파서 파인더 테스트") {
        it("커스텀 파서 문자를 찾아낼 수 있다.") {
            val expressionInput = "//---\n1---2"
            val customParser = CustomStringParserFinder.find(expressionInput)

            customParser shouldBe "---"
        }

        it("//로 시작하지 않을 경우 커스텀 파서 문자를 찾아낼 수 없고") {
            it("빈 문자열을 리턴한다.") {
                val expressionInput = "/---\n1---2"
                val customParser = CustomStringParserFinder.find(expressionInput)

                customParser shouldBe ""
            }
        }

        it("/n로 끝나지 않을 경우 커스텀 파서 문자를 찾아낼 수 없고") {
            it("빈 문자열을 리턴한다.") {
                val expressionInput = "//---n1---2"
                val customParser = CustomStringParserFinder.find(expressionInput)

                customParser shouldBe ""
            }
        }
    }
})
