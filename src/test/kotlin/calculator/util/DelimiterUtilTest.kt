package calculator.util

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class DelimiterUtilTest : DescribeSpec({
    describe("getCustomDelimiter") {
        context("문자열 앞부분에 //와 ₩n 사이에 문자열이 있는 경우") {
            it("해당 문자열을 리턴한다") {
                val text = "//abc₩n"
                val actual = getCustomDelimiter(text)
                actual shouldBe "abc"
            }
        }

        context("문자열에 //와 ₩n 이 없는 경우") {
            it("빈 문자열을 리턴한다") {
                val text = "10;20;30"
                val actual = getCustomDelimiter(text)
                actual shouldBe ""
            }
        }

        context("문자열 중간에 //와 ₩n 이 위치한 경우") {
            it("빈 문자열을 리턴한다") {
                val text = "10;20;//abc₩n30"
                val actual = getCustomDelimiter(text)
                actual shouldBe ""
            }
        }

        context("null이 전달되는 경우") {
            it("빈 문자열을 리턴한다") {
                val text: String? = null
                val actual = getCustomDelimiter(text)
                actual shouldBe ""
            }
        }
    }
})
