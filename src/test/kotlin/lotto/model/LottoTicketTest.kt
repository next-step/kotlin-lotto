package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

internal class LottoTicketTest {
    @Test
    fun `지난 주 당첨 번호 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoTicket("A")
        }
    }

    @Test
    fun `지난 주 당첨 번호 범위가 1에서 45가 아니면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            LottoTicket("1, 2, 3, 4, 5, 46")
        }
        assertThat(exception.message).isSameAs("1에서 45 사이의 값을 입력하세요.")
    }

    @Test
    fun `지난 주 당첨 번호 음수면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            LottoTicket("1, 2, 3, 4, 5, -6")
        }
        assertThat(exception.message).isSameAs("1에서 45 사이의 값을 입력하세요.")
    }

    @Test
    fun `지난 주 당첨 번호 6개가 아니면 예외가 발생한다`() {
        assertAll(
            {
                val exception = assertThrows<IllegalArgumentException> {
                    LottoTicket("1, 2, 3, 4, 5")
                }
                assertThat(exception.message).isSameAs("당첨 번호는 6개여야 합니다.")
            },
            {
                val exception = assertThrows<IllegalArgumentException> {
                    LottoTicket("1, 2, 3, 4, 5, 6, 7")
                }
                assertThat(exception.message).isSameAs("당첨 번호는 6개여야 합니다.")
            },
        )
    }

    @Test
    fun `지난 주 당첨 번호 중복 시 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            LottoTicket("1, 2, 2, 4, 5, 6")
        }
        assertThat(exception.message).isSameAs("중복 불가")
    }
}
