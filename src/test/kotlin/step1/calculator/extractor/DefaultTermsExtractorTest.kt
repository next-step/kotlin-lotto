package step1.calculator.extractor

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import step1.calculator.DelimiterType

internal class DefaultTermsExtractorTest : BehaviorSpec({
    given("기본 구분자로 구분된 숫자 추출") {
        `when`("콤마 혹은 콜론으로 구분된 문자열과 구분자 타입을 입력하면") {
            expressions.forAll { (expression: String, expected: Array<String>) ->
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
        private val actual: Array<String> = arrayOf("1", "2", "3")
        private val expressions = listOf(
            "1,2,3" to actual,
            "1:2:3" to actual,
            "1,2:3" to actual,
            "1:2,3" to actual
        )
    }
}
