package lotto.core

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinningNumbersTest {
    @ParameterizedTest
    @ValueSource(strings = [ "", "a", "1,2", "1,2,3,4,5,46", "1,2,3,4,5,47", "-01, 2,3,4,5,45" ])
    fun `잘못된 문자열 입력 시 오류를 확인한다`(value: String) {
        shouldThrow<RuntimeException> {
            WinningNumbers(value)
        }
    }
}
