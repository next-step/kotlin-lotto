package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class InputAnalyzerTest : BehaviorSpec({

    Given("구분자가 없는 숫자로 된 문자열이 주어질 때") {
        listOf("12345", "543", "1", "23").forEach {
            val `입력값 분석 객체` = InputAnalyzer(it)

            Then("숫자 1개가 담긴 목록으로 반환한다") {
                val actual = `입력값 분석 객체`.extractNumbers()
                actual shouldHaveSize 1
                actual[0] shouldBe it.toInt()
            }
        }
    }

    Given("구분자가 있는 문자열이 주어질 때") {
        When("쉼표(,)가 포함된 문자열일 경우") {
            forAll(
                row("1,2,3,4,5", listOf(1, 2, 3, 4, 5)),
                row("2,3,9", listOf(2, 3, 9)),
                row("63435,73734,6759,567", listOf(63435, 73734, 6759, 567)),
            ) { inputString: String, expect: List<Int> ->
                val `입력값 분석 객체` = InputAnalyzer(inputString)

                Then("구분자 객체는 문자열을 구분자 기준으로 분리해 숫자 목록으로 반환한다.") {
                    `입력값 분석 객체`.extractNumbers() shouldBe expect
                }
            }
        }

        When("콜론(:)가 포함된 문자열일 경우") {
            forAll(
                row("1:2:3:4:5", listOf(1, 2, 3, 4, 5)),
                row("2:3:9", listOf(2, 3, 9)),
                row("63435:73734:6759:567", listOf(63435, 73734, 6759, 567)),
            ) { inputString: String, expect: List<Int> ->
                val `입력값 분석 객체` = InputAnalyzer(inputString)

                Then("구분자 객체는 문자열을 구분자 기준으로 분리해 숫자 목록으로 반환한다.") {
                    `입력값 분석 객체`.extractNumbers() shouldBe expect
                }
            }
        }

        When("쉼표(,)와 콜론(:)가 포함된 문자열일 경우") {
            forAll(
                row("1:2,3,4:5", listOf(1, 2, 3, 4, 5)),
                row("2:3,9", listOf(2, 3, 9)),
                row("63435,73734:6759,567", listOf(63435, 73734, 6759, 567)),
            ) { inputString: String, expect: List<Int> ->
                val `입력값 분석 객체` = InputAnalyzer(inputString)

                Then("구분자 객체는 문자열을 구분자 기준으로 분리해 숫자 목록으로 반환한다.") {
                    `입력값 분석 객체`.extractNumbers() shouldBe expect
                }
            }
        }
    }

    Given("커스텀 구분자를 가진 문자열이 주어질 때") {
        When("다른 구분자는 없을 경우") {
            forAll(
                row("""//;\n1;2;3;4;5""", listOf(1, 2, 3, 4, 5)),
                row("""//^\n2^3^9""", listOf(2, 3, 9)),
                row("""//%%\n63435%%73734%%6759%%567""", listOf(63435, 73734, 6759, 567)),
            ) { inputString: String, expect: List<Int> ->
                val `입력값 분석 객체` = InputAnalyzer(inputString)

                Then("구분자 객체는 문자열을 구분자 기준으로 분리해 숫자 목록으로 반환한다.") {
                    `입력값 분석 객체`.extractNumbers() shouldBe expect
                }
            }
        }

        When("쉼표(,)와 콜론(:)가 포함된 문자열일 경우") {
            forAll(
                row("""//;\n1;2;3,4:5""", listOf(1, 2, 3, 4, 5)),
                row("""//^\n2^3,9""", listOf(2, 3, 9)),
                row("""//x\n2x3,9""", listOf(2, 3, 9)),
                row("""//%%\n63435%%73734,6759:567""", listOf(63435, 73734, 6759, 567)),
            ) { inputString: String, expect: List<Int> ->
                val `입력값 분석 객체` = InputAnalyzer(inputString)

                Then("구분자 객체는 문자열을 구분자 기준으로 분리해 숫자 목록으로 반환한다.") {
                    `입력값 분석 객체`.extractNumbers() shouldBe expect
                }
            }
        }
    }
})

class ValidateTest : StringSpec({
    "입력 값에 숫자 이외의 값이 존재하면 예외가 발생한다" {
        listOf("""//;\n1;2;3x""", "32411a", "27,alex").forEach {
            val `입력값 분석 객체` = InputAnalyzer(it)

            shouldThrow<RuntimeException> {
                `입력값 분석 객체`.validateInput()
            }.message shouldBe "입력 값은 쉼표(,), 콜론(:), 커스텀 구분자를 제외한 나머지 문자는 모두 숫자로 입력해야 합니다."
        }
    }

    "입력 값에 음수가 들어오면 예외가 발생한다" {
        listOf("""//x\n1,2:-3x4""", "4:6,-7", "332323,-2,0").forEach {
            val `입력값 분석 객체` = InputAnalyzer(it)

            shouldThrow<RuntimeException> {
                `입력값 분석 객체`.validateInput()
            }.message shouldBe "입력 값은 음수가 아니어야 합니다."
        }
    }
})
