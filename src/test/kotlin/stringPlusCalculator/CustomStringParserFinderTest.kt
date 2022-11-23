package stringPlusCalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CustomStringParserFinderTest  : DescribeSpec({
    describe("커스텀 문자열 파서 파인더 테스트") {
        val customStringParserFinder = CustomStringParserFinder()

        it("커스텀 파서 문자를 찾아낼 수 있다.") {
            val expressionInput = "//---\n1---2"
            val customParser = customStringParserFinder.find(expressionInput)

            customParser shouldBe "---"
        }

        it("//로 시작하지 않을 경우 커스텀 파서 문자를 찾아낼 수 없고") {
            it("IllegalArgumentException 을 throw 한다.") {
                val expressionInput = "/---\n1---2"
                val customParser = customStringParserFinder.find(expressionInput)

                customParser shouldBe ""
            }
        }

        it("/n로 끝나지 않을 경우 커스텀 파서 문자를 찾아낼 수 없고") {
            it("IllegalArgumentException 을 throw 한다.") {
                val expressionInput = "//---n1---2"
                val customParser = customStringParserFinder.find(expressionInput)

                customParser shouldBe ""
            }
        }
    }
})