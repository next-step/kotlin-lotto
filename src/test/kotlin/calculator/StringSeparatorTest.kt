package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StringSeparatorTest : FunSpec({
    test("쉼표(,), 또는 콜론(:)을 구분자로 숫자 리스트를 반환한다.") {
        // given
        val expression = "1,2:3"
        val separator = StringSeparator()

        // when
        val actual = separator.separate(expression)

        // then
        actual shouldBe listOf(1, 2, 3)
    }

    test("“//”와 “\\n” 사이에 위치하는 문자를 커스텀 구분자로 숫자 리스트를 반환한다.") {
        // given
        val expression = "//;\n1;2;3"
        val separator = StringSeparator()

        // when
        val actual = separator.separate(expression)

        // then
        actual shouldBe listOf(1, 2, 3)
    }
})