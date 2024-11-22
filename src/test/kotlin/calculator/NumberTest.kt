package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class NumberTest {
    @Test
    fun `유효한 숫자를 생성한다`() {
        val number = Number.from("5")
        number.toInt() shouldBe 5
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-10", "-9999999"])
    fun `음수를 입력하면 예외를 발생시킨다`(text: String) {
        val exception =
            shouldThrow<IllegalArgumentException> {
                Number.from(text)
            }
        exception.message shouldContain "음수를 입력할 수 없습니다"
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = [" ", "a", "b", "#"])
    fun `잘못된 문자열 입력 시 예외를 발생시킨다`(text: String) {
        val exception =
            shouldThrow<IllegalArgumentException> {
                Number.from(text)
            }
        exception.message shouldContain "잘못된 입력값입니다"
    }
}
