package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class 유효성_검사_테스트 : StringSpec({

    "입력 값에 숫자 이외의 값이 존재하면 예외가 발생한다" {
        listOf("""//;\n1;2;3x""", "32411a", "27,alex").forEach {
            val delimiters = DelimiterParser.extractDelimiters(it)

            shouldThrow<RuntimeException> {
                delimiters.validateInput(it)
            }.message shouldBe "입력 값은 쉼표(,), 콜론(:), 커스텀 구분자를 제외한 나머지 문자는 모두 숫자로 입력해야 합니다."
        }
    }
})

class 양수_숫자_목록_추출_테스트 : BehaviorSpec({

    Given("구분자가 있는 문자열이 주어질 때") {
        When("쉼표(,)가 포함된 문자열인 경우") {
            forAll(
                row("1,2,3,4,5", listOf(1, 2, 3, 4, 5)),
                row("2,3,9", listOf(2, 3, 9)),
                row("63435,73734,6759,567", listOf(63435, 73734, 6759, 567)),
            ) { inputString: String, expect: List<Int> ->
                val delimiters = DelimiterParser.extractDelimiters(inputString)
                val 추출된_양수_숫자_목록 = delimiters.extractPositiveNumbers(inputString)

                Then("구분자를 제외한 숫자를 반환한다.") {
                    추출된_양수_숫자_목록.values shouldBe expect
                }
            }
        }

        When("콜론(:)가 포함된 문자열인 경우") {
            forAll(
                row("1:2:3:4:5", listOf(1, 2, 3, 4, 5)),
                row("2:3:9", listOf(2, 3, 9)),
                row("63435:73734:6759:567", listOf(63435, 73734, 6759, 567)),
            ) { inputString: String, expect: List<Int> ->
                val delimiters = DelimiterParser.extractDelimiters(inputString)
                val 추출된_양수_숫자_목록 = delimiters.extractPositiveNumbers(inputString)

                Then("구분자를 제외한 숫자를 반환한다.") {
                    추출된_양수_숫자_목록.values shouldBe expect
                }
            }
        }

        When("쉼표(,)와 콜론(:)가 포함된 문자열인 경우") {
            forAll(
                row("1:2,3,4:5", listOf(1, 2, 3, 4, 5)),
                row("2:3,9", listOf(2, 3, 9)),
                row("63435,73734:6759,567", listOf(63435, 73734, 6759, 567)),
            ) { inputString: String, expect: List<Int> ->
                val delimiters = DelimiterParser.extractDelimiters(inputString)
                val 추출된_양수_숫자_목록 = delimiters.extractPositiveNumbers(inputString)

                Then("구분자를 제외한 숫자를 반환한다.") {
                    추출된_양수_숫자_목록.values shouldBe expect
                }
            }
        }

        When("커스텀 구분자가 포함된 문자열인 경우") {
            forAll(
                row("""//;\n1;2;3;4;5""", listOf(1, 2, 3, 4, 5)),
                row("""//^\n2^3^9""", listOf(2, 3, 9)),
                row("""//%%\n63435%%73734%%6759%%567""", listOf(63435, 73734, 6759, 567)),
                row("""//;\n1;2;3,4:5""", listOf(1, 2, 3, 4, 5)),
                row("""//^\n2^3,9""", listOf(2, 3, 9)),
                row("""//x\n2x3,9""", listOf(2, 3, 9)),
                row("""//%%\n63435%%73734,6759:567""", listOf(63435, 73734, 6759, 567)),
            ) { inputString: String, expect: List<Int> ->
                val delimiters = DelimiterParser.extractDelimiters(inputString)
                val pureInputString = DelimiterParser.extractPureInput(inputString)
                val 추출된_양수_숫자_목록 = delimiters.extractPositiveNumbers(pureInputString)

                Then("구분자를 제외한 숫자를 반환한다.") {
                    추출된_양수_숫자_목록.values shouldBe expect
                }
            }
        }
    }
})
