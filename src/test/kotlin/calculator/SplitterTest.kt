package calculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class SplitterTest : DescribeSpec({
    describe("splitter") {
        it("커스텀 구분자는 문자열 앞부분의 “//”와 “\\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.") {
            // given
            val result = Splitter.getNumbers("1,2,3")

            // then
            result shouldBe listOf(1, 2, 3)
        }
        it("커스텀 구분자는 문자열 앞부분의 “//”와 “\\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.") {
            // given
            val result = Splitter.getNumbers("//;\n1;2;3")

            // then
            result shouldBe listOf(1, 2, 3)
        }
    }
})
