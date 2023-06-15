package calculator

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test

class NumbersTest {
    @Test
    fun `Numbers에는 음수가 포함될 수 없다`() {
        shouldThrow<RuntimeException> { Numbers(listOf(-1,1,2,3)) }
    }
}