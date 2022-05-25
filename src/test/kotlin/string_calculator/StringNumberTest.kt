package string_calculator

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

class StringNumberTest : StringSpec({
    "값이 음수가 아니면 문자열 숫자를 생성할 수 있다." {
        listOf(
            1,
            2,
        ).forAll {
            // when // then
            shouldNotThrowAny { StringNumber(it) }
        }
    }

    "값이 음수인 문자열 숫자는 생성할 수 없다." {
        // given
        val value = -1

        // when // then
        shouldThrowExactly<RuntimeException> { StringNumber(value) }
    }
})
