package string_calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringNumbersTest : StringSpec({
    "문자열 숫자들을 모두 더한다." {
        // given
        val stringNumbers = StringNumbers(
            listOf(
                StringNumber(1),
                StringNumber(2),
                StringNumber(3),
            ),
        )

        // when
        val actual = stringNumbers.addAll()

        // then
        actual shouldBe StringNumber(6)
    }
})
