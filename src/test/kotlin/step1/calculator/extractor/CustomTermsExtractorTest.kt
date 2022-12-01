package step1.calculator.extractor

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import step1.calculator.domain.DelimiterType
import step1.calculator.domain.Terms

internal class CustomTermsExtractorTest : BehaviorSpec({
    given("커스텀 구분자로 구분된 숫자 추출") {
        `when`("커스텀 구분자로 구분된 문자열과 구분자 타입을 입력하면") {
            expressions.forAll { (expression: String, expected: Terms) ->
                val delimiterType = DelimiterType.match(expression)
                val extractor = delimiterType.getExtractor()
                val actual = extractor.extractTerms(delimiterType, expression)
                then("구분자를 기준으로 분리된 숫자 문자열 목록을 반환한다.") {
                    actual shouldBe expected
                }
            }
        }
    }
}) {
    companion object {
        private val actual: Terms = Terms.of(arrayListOf("4", "5"))
        private val expressions = listOf(
            "//;\n4;5" to actual,
            "//|\n4|5" to actual,
        )
    }
}
