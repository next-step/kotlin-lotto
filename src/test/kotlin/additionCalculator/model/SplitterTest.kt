package additionCalculator.model

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class SplitterTest : DescribeSpec({
    describe("constructor") {
        it("\"//\"와 \"\\n\" 문자 사이에 커스텀 구분자를 입력하면 tokens 를 분리한다") {
            // given
            val expression = "//;\n1;2;3"

            // when
            val tokens = Splitter.split(expression)

            // then
            tokens shouldBe listOf("1", "2", "3")
        }

        it("delimiter 를 ,(콤마)로 입력하면 tokens 를 분리한다.") {
            // given
            val expression = "1,2,3"

            // when
            val tokens = Splitter.split(expression)

            // then
            tokens shouldBe listOf("1", "2", "3")
        }

        it("delimiter 를 :(콜론)으로 입력하면 tokens 를 분리한다.") {
            // given
            val expression = "1:2:3"

            // when
            val tokens = Splitter.split(expression)

            // then
            tokens shouldBe listOf("1", "2", "3")
        }

        it("expression 이 null 일 경우 tokens 는 빈 배열이다.") {
            // given
            val expression = null

            // when
            val tokens = Splitter.split(expression)

            // then
            tokens shouldBe emptyList()
        }

        it("expression 이 빈 문자열 일 경우 tokens 는 빈 배열이다.") {
            // given
            val expression = ""

            // when
            val tokens = Splitter.split(expression)

            // then
            tokens shouldBe emptyList()
        }
    }
})
