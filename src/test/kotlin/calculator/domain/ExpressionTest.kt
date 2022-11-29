package calculator.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

class ExpressionTest : FunSpec({
    context("split()") {
        test("빈 문자열 또는 null일 경우, 빈 리스트를 반환한다.") {
            listOf(null, "", " ").forAll {
                Expression.split(it) shouldBe emptyList()
            }
        }

        test("숫자 하나일 경우, 해당 숫자를 담은 리스트를 반환한다.") {
            val text = "1"

            Expression.split(text) shouldBe listOf("1")
        }

        test("쉼표 기준으로 분리한 숫자 목록을 반환한다.") {
            val text = "1,2"

            Expression.split(text) shouldContainExactly listOf("1", "2")
        }

        test("쉼표, 콜론 기준으로 분리한 숫자 목록을 반환한다.") {
            val text = "1,2:3"

            Expression.split(text) shouldContainExactly listOf("1", "2", "3")
        }

        test("//와 \n 문자 사이에 커스텀 구분자를 기준으로 분리한 숫자 목록을 반환한다.") {
            val text = "//;\n1;2;3"

            Expression.split(text) shouldContainExactly listOf("1", "2", "3")
        }
    }
})
