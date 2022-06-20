package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTicketTest {

    @Test
    fun `입력된 문자열을 리스트로 만들었을 때 길이는 항상 6이어야 한다`() {
        val winningNumbers = listOf(LottoNumber(1)
            , LottoNumber(2)
            , LottoNumber(3)
            , LottoNumber(4)
            , LottoNumber(5)
            , LottoNumber(6)
            , LottoNumber(7)
        )

        val ticket = LottoTicket()

        assertThrows<IllegalArgumentException> {
            ticket.validate(winningNumbers, LottoNumber(7))
        }
    }

    @Test
    fun `bonus 숫자는 winning number에 포함되면 안된다`() {
        val winningNumbers = listOf(LottoNumber(1)
            , LottoNumber(2)
            , LottoNumber(3)
            , LottoNumber(4)
            , LottoNumber(5)
            , LottoNumber(6)
        )

        val ticket = LottoTicket()

        assertThrows<IllegalArgumentException> {
            ticket.validate(winningNumbers, LottoNumber(6))
        }
    }
}
