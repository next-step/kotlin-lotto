package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.Test

class NumbersTest {
    @Test
    fun `Numbers에는 음수가 포함될 수 없다`() {
        shouldThrow<IllegalArgumentException> { Numbers(listOf(-1, 1, 2, 3)) }
            .shouldHaveMessage("음수가 전달되었습니다.")
    }
}
