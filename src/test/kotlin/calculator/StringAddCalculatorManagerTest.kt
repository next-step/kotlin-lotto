package calculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows

class StringAddCalculatorManagerTest : DescribeSpec({
    lateinit var sut: StringAddCalculatorManager

    beforeTest { sut = StringAddCalculatorManager() }

    describe("start") {
        it("쉼표(,)를 구분자로 가지는 문자열의 합") {
            val input = "10,20,30"
            val actual = sut.start(input)
            actual shouldBe 60
        }

        it("콜론(:)를 구분자로 가지는 문자열의 합") {
            val input = "10:20:30"
            val actual = sut.start(input)
            actual shouldBe 60
        }

        it("커스텀 구분자를 가지는 문자열의 합") {
            val input = "//abc₩n10abc20abc30"
            val actual = sut.start(input)
            actual shouldBe 60
        }

        it("커스텀 구분자와 기본 구분자를 함께 사용하는 경우") {
            val input = "//abc₩n10,20:30"
            val actual = sut.start(input)
            actual shouldBe 60
        }

        context("빈 문자열을 입력한 경우") {
            it("0을 리턴") {
                val input = "  "
                val actual = sut.start(input)
                actual shouldBe 0
            }
        }

        context("null을 입력한 경우") {
            it("0을 리턴") {
                val input = null
                val actual = sut.start(input)
                actual shouldBe 0
            }
        }

        context("음수를 입력한 경우") {
            it("throw RuntimeException") {
                val input = "10:-20:30"
                assertThrows<RuntimeException> {
                    sut.start(input)
                }
            }
        }

        context("커스텀 구분자를 잘못 사용한 경우") {
            it("RuntimeException throw") {
                val input = "//abcd₩n10abc20abc30"

                assertThrows<RuntimeException> {
                    sut.start(input)
                }
            }
        }
    }

    describe("문자열을 입력받고 숫자를 리스트로 반환한다.") {
        context("쉼표(,)를 구분자로 가지는 문자열을 입력받은 경우") {
            it("각 숫자를 리스트로 반환한다.") {
                val input = "10,20,30"
                val actual: List<Int> = sut.inputToListOrThrow(input)
                actual[0] shouldBe 10
                actual[1] shouldBe 20
                actual[2] shouldBe 30
            }
        }

        context("콜론(:)를 구분자로 가지는 문자열을 입력받은 경우") {
            it("각 숫자를 리스트로 반환한다.") {
                val input = "10:20:30"
                val actual: List<Int> = sut.inputToListOrThrow(input)
                actual[0] shouldBe 10
                actual[1] shouldBe 20
                actual[2] shouldBe 30
            }
        }

        context("커스텀 구분자를 지정한 경우") {
            it("각 숫자를 리스트로 반환한다.") {
                val input = "//;₩n10;20;30"
                val actual: List<Int> = sut.inputToListOrThrow(input)
                actual[0] shouldBe 10
                actual[1] shouldBe 20
                actual[2] shouldBe 30
            }
        }

        context("기본 구분자와 커스텀 구분자를 함께 사용하는 경우") {
            it("각 숫자를 리스트로 반환한다.") {
                val input = "//;₩n10;20,30:40"
                val actual: List<Int> = sut.inputToListOrThrow(input)
                actual[0] shouldBe 10
                actual[1] shouldBe 20
                actual[2] shouldBe 30
                actual[3] shouldBe 40
            }
        }

        context("문자열에 음수를 전달받은 경우") {
            it("RuntimeException throw") {
                val input = "10,20,-30"
                assertThrows<RuntimeException> {
                    sut.inputToListOrThrow(input)
                }
            }
        }

        context("문자열에 숫자 이외의 값을 전달받은 경우") {
            it("RuntimeException throw") {
                val input = "a,20,-30"
                assertThrows<RuntimeException> {
                    sut.inputToListOrThrow(input)
                }
            }
        }

        context("빈 문자열을 전달받는 경우") {
            it("emptyList 리턴한다") {
                val input = ""
                val actual = sut.inputToListOrThrow(input)
                actual.size shouldBe 0
            }
        }

        context("null을 전달받는 경우") {
            it("emptyList 리턴한다") {
                val input = ""
                val actual = sut.inputToListOrThrow(input)
                actual.size shouldBe 0
            }
        }
    }
})
