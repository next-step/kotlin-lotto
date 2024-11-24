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

    describe("deleteCustomDelimiter") {
        context("커스텀 구분자가 있는 경우") {
            it("커스텀 구분자를 지운 문자열을 리턴한다.") {
                val text = "//abc₩n10abc20"
                val actual = deleteCustomDelimiter(text)
                actual shouldBe "10abc20"
            }
        }

        context("커스텀 구분자가 없는 경우") {
            it("문자열을 그대로 리턴한다.") {
                val text = "10,20"
                val actual = deleteCustomDelimiter(text)
                actual shouldBe "10,20"
            }
        }
    }
})
