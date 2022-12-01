package step1.calculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class TermsTest : StringSpec({
    val given = arrayListOf("1", "2", "3")

    "List<String>을 입력 받아 연산 대상인 항 객체를 생성한다." {
        val actual = Terms.of(given)

        actual[0] shouldBe 1
        actual[1] shouldBe 2
        actual[2] shouldBe 3
    }

    "항의 값이 유효하지 못한 경우 예외가 발생한다." {
        invalidInputs.forAll { (description: String, given: List<String>) ->
            shouldThrow<IllegalArgumentException> { Terms.of(given) }
        }
    }

    "각 항의 값이 합산된 결과를 반환한다." {
        val terms = Terms.of(given)
        terms.sum() shouldBe 6
    }
}) {
    companion object {
        val invalidInputs = listOf(
            "빈값 혹은 null이 포함된 경우" to arrayListOf("1", "", "3"),
            "숫자가 아닌 값이 포함된 경우" to arrayListOf("1", "이", "3"),
            "음수인 값이 포함된 경우" to arrayListOf("1", "-2", "3"),
        )
    }
}
