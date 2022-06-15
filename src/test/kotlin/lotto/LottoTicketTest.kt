package lotto

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class LottoTicketTest {

    @Test
    fun `입력된 문자열을 리스트로 만들었을 때 길이는 항상 6이어야 한다`() {
        val winningNumbers = listOf(1,2,3,4,5,6,7)

        val ticket = LottoTicket()

        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            ticket.validate(winningNumbers, 7)
        }
    }

    @Test
    fun `bonus 숫자는 winning number에 포함되면 안된다`() {
        val winningNumbers = listOf(1,2,3,4,5,6)

        val ticket = LottoTicket()

        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            ticket.validate(winningNumbers, 6)
        }
    }
}