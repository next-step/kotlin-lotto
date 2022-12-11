package lotto.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.lang.IllegalArgumentException

internal class WinnerNumberTest {
    @Test
    fun `지난 주 당첨 번호 숫자가 아니면 예외가 발생한다`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            WinnerNumber("A")
        }
    }

    @Test
    fun `지난 주 당첨 번호 범위가 1에서 45가 아니면 예외가 발생한다`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            WinnerNumber("1, 2, 3, 4, 5, 46")
        }
    }

    @Test
    fun `지난 주 당첨 번호 음수면 예외가 발생한다`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            WinnerNumber("1, 2, 3, 4, 5, -6")
        }
    }

    @Test
    fun `지난 주 당첨 번호 6개가 아니면 예외가 발생한다`() {
        assertAll(
            {
                Assertions.assertThrows(IllegalArgumentException::class.java) {
                    WinnerNumber("1, 2, 3, 4, 5")
                }
            },
            {
                Assertions.assertThrows(IllegalArgumentException::class.java) {
                    WinnerNumber("1, 2, 3, 4, 5, 6, 7")
                }
            },
        )
    }

    @Test
    fun `지난 주 당첨 번호 중복 시 예외가 발생한다`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            WinnerNumber("1, 2, 2, 4, 5, 6")
        }
    }
}
