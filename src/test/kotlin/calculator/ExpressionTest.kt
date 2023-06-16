package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ExpressionTest : StringSpec({
    "표현식은 기본 구분자로 콤마(,)와 콜론(:)을 가진다." {
        Expression.DEFAULT_SEPARATORS[0] shouldBe ","
        Expression.DEFAULT_SEPARATORS[1] shouldBe ":"
    }

    "콤마(,)로 구분된 표현식을 숫자로 구분 한다." {
        // given
        val value = "1,2,3"

        // when
        val expression = Expression.of(value)

        // then
        expression.numbers.size shouldBe 3
    }

    "콜론(:)로 구분된 표현식을 숫자로 구분 한다." {
        // given
        val value = "1:2:3"

        // when
        val expression = Expression.of(value)

        // then
        expression.numbers.size shouldBe 3
    }

    "사용자 지정 구분자(;)로 구분된 표현식을 숫자로 구분 한다." {
        // given
        val value = "//;\n1;2;3"

        // when
        val expression = Expression.of(value)

        // then
        expression.numbers.size shouldBe 3
    }

    "표현식을 구분자로 구분한 결과가 음수면 에러가 발생 한다." {
        // given
        val value = "1,2,-1"

        // when & then
        shouldThrow<RuntimeException> { Expression.of(value) }
    }

    "표현식을 구분자로 구분한 결과가 숫자가 아니면 에러가 발생 한다." {
        // given
        val value = "1,2,-"

        // when & then
        shouldThrow<RuntimeException> { Expression.of(value) }
    }
})
