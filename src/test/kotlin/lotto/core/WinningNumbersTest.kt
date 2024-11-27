package lotto.core

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test

class WinningNumbersTest {
    @Test
    fun `잘못된 문자열 입력 시 오류를 확인한다`() {
        shouldThrow<IllegalArgumentException> {
            WinningNumbers(listOf(1))
        }
        shouldThrow<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }
}
