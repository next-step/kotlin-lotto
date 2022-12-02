package step1.calculator.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ExpressionTypeTest : StringSpec({
    "주어진 문자열의 구분자 타입을 판별한다." {
        forAll(
            row("빈값", "", ExpressionType.EMPTY),
            row("단일 양수", "1", ExpressionType.SINGLE_POSITIVE_NUMBER),
            row("콤마", "1,2,3", ExpressionType.COMMA),
            row("콜론", "1:2:3", ExpressionType.COLON),
            row("혼합형", "1,2:3", ExpressionType.MIXED),
            row("커스텀 구분자", "//;\n4;5", ExpressionType.CUSTOM),
            row("커스텀 구분자가 콤마", "//,\n4,5", ExpressionType.CUSTOM)
        ) { description: String, given: String, actual: ExpressionType ->
            ExpressionType.match(given) shouldBe actual
        }
    }

    "구분자가 포함되지 않거나, 올바른 형식이 아닌 경우 예외가 발생한다." {
        forAll(
            row("구분자가 포함되지 않은 경우", "-123"),
            row("올바른 형식이 아닌 경우", "1|2|3")
        ) { description: String, given: String ->
            shouldThrowExactly<IllegalArgumentException> { ExpressionType.match(given) }
        }
    }

    "판별한 구분자를 반환한다." {
        forAll(
            row("콤마", "1,2,3", ","),
            row("콜론", "1:2:3", ":"),
            row("혼합형", "1,2:3", "[,:]"),
            row("커스텀 구분자", "//|\n1|2|3", "|")
        ) { description: String, given: String, actual: String ->
            val match = ExpressionType.match(given)
            match.extractDelimiter(given) shouldBe actual
        }
    }
})
