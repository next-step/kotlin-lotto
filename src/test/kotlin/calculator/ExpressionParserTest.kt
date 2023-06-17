package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.throwable.shouldHaveMessage

class ExpressionParserTest : StringSpec({
    "빈문자열일 경우 0을 반환" {
        // given
        val expression = ""

        // when
        val result = ExpressionParser.parse(expression)

        // then
        result shouldContainExactly listOf(0)
    }

    "',', ':' 기준으로 문자열을 분리한다" {
        // given
        val expression = "1,2:3"

        // when
        val result = ExpressionParser.parse(expression)

        // then
        result shouldContainExactly listOf(1, 2, 3)
    }

    "커스텀 구분자를 기준으로 문자열 분리" {
        // given
        val expression = "1//hi\n2//hi\n3"

        // when
        val result = ExpressionParser.parse(expression)

        // then
        result shouldContainExactlyInAnyOrder listOf(1, 2, 3)
    }

    "복합 구분자를 기준으로 문자열 분리" {
        // given
        val expression = "1//hi\n2,3:4"

        // when
        val result = ExpressionParser.parse(expression)

        // then
        result shouldContainExactlyInAnyOrder listOf(1, 2, 3, 4)
    }

    "커스텀 구분자 사이에 기본 구분자가 있을 경우" {
        // given
        val expression = "//,\n2,3:4"

        // when
        val result = ExpressionParser.parse(expression)

        // then
        result shouldContainExactlyInAnyOrder listOf(0, 2, 3, 4)
    }

    "커스텀 구분자 사이에 공백이 있는경우" {
        // given
        val expression = "//\n2,3:4"

        // when
        val result = ExpressionParser.parse(expression)

        // then
        result shouldContainExactlyInAnyOrder listOf(0, 2, 3, 4)
    }

    "구분자 사이에 양수가 아닌 수가 있는 경우" {
        // given

        forAll(row("//hi\n2,-3:4"), row("//hi\n2,3:a"), row("//hi\na,3"), row("//hi\n-2,1:0")) {
            shouldThrow<RuntimeException> {
                // when & then
                ExpressionParser.parse(it)
            }.shouldHaveMessage("피연산자는 양수만 가능합니다")
        }
    }
})
