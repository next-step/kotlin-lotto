package stringaddcalculator.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class SeparatorSpecs : DescribeSpec({

    describe("구분자는") {
        it("구분자로 사용할 문자를 가질 수 있다") {
            Separator("/").value shouldBe "/"
        }

        context("구분자 문자의 길이가 1보다 작다면") {
            val value = ""
            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> {
                    Separator(value)
                }
            }
        }

        context("구분자 문자의 길이가 1보다 크다면") {
            val value = ";)"
            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> {
                    Separator(value)
                }
            }
        }

        context("구분자 문자가 숫자라면") {
            val value = "100"
            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> {
                    Separator(value)
                }
            }
        }
    }
})
