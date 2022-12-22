package lotto.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.lang.IllegalArgumentException

internal class LottoTicketTest {
    @Test
    fun `지난 주 당첨 번호 숫자가 아니면 예외가 발생한다`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            LottoTicket("A")
        }
    }

    @Test
    fun `지난 주 당첨 번호 범위가 1에서 45가 아니면 예외가 발생한다`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            LottoTicket("1, 2, 3, 4, 5, 46")
        }
        Assertions.assertEquals("1에서 45 사이의 값을 입력하세요.", exception.message)
    }

    @Test
    fun `지난 주 당첨 번호 음수면 예외가 발생한다`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            LottoTicket("1, 2, 3, 4, 5, -6")
        }
        Assertions.assertEquals("1에서 45 사이의 값을 입력하세요.", exception.message)
    }

    @Test
    fun `지난 주 당첨 번호 6개가 아니면 예외가 발생한다`() {
        assertAll(
            {
                val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
                    LottoTicket("1, 2, 3, 4, 5")
                }
                Assertions.assertEquals("당첨 번호는 6개여야 합니다.", exception.message)
            },
            {
                val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
                    LottoTicket("1, 2, 3, 4, 5, 6, 7")
                }
                Assertions.assertEquals("당첨 번호는 6개여야 합니다.", exception.message)
            },
        )
    }

    @Test
    fun `지난 주 당첨 번호 중복 시 예외가 발생한다`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            LottoTicket("1, 2, 2, 4, 5, 6")
        }
        Assertions.assertEquals("중복 불가", exception.message)
    }
}
