package lotto

import lotto.controller.LottoGame
import lotto.model.BonusNumber
import lotto.model.LottoTicket
import lotto.model.TicketQuantity
import lotto.model.WinnerNumber
import lotto.model.WinningCalculator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.lang.IllegalArgumentException

internal class LottoAllTest {
    @Test
    fun `임의의 6개 숫자를 중복없이 생성한다`() {
        val testTicket = LottoTicket()
        assertEquals(LOTTO_NUMBER_SIZE, testTicket.lottoNumbers.toSet().size)
    }

    @Test
    fun `구입 금액 입력 값이 숫자가 아니면 예외가 발생한다`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            TicketQuantity("A")
        }
        assertEquals("숫자만 입력 가능합니다.", exception.message)
    }

    @Test
    fun `구입 금액이 최소 1000원 미만이면 예외가 발생한다`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            TicketQuantity("999")
        }
        assertEquals("1000원 이상을 결제해주세요.", exception.message)
    }

    @Test
    fun `구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            TicketQuantity("1200")
        }
        assertEquals("1000원 단위로 결제해주세요.", exception.message)
    }

    @Test
    fun `구입 금액에 맞는 수량만큼 발행한다`() {
        assertEquals(10, LottoGame().purchaseLottoTicket(10).size)
    }

    @Test
    fun `지난 주 당첨 번호 숫자가 아니면 예외가 발생한다`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            WinnerNumber("A")
        }
        assertEquals("숫자만 입력 가능합니다.", exception.message)
    }

    @Test
    fun `지난 주 당첨 번호 범위가 1에서 45가 아니면 예외가 발생한다`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            WinnerNumber("1, 2, 3, 4, 5, 46")
        }
        assertEquals("1에서 45 사이의 값을 입력하세요.", exception.message)
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
                val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
                    WinnerNumber("1, 2, 3, 4, 5")
                }
                assertEquals("당첨 번호는 6개여야 합니다.", exception.message)
            },
            {
                val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
                    WinnerNumber("1, 2, 3, 4, 5, 6, 7")
                }
                assertEquals("당첨 번호는 6개여야 합니다.", exception.message)
            },
        )
    }

    @Test
    fun `지난 주 당첨 번호 중복 시 예외가 발생한다`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            WinnerNumber("1, 2, 2, 4, 5, 6")
        }
        assertEquals("중복 불가", exception.message)
    }

    @Test
    fun `보너스 번호가 숫자가 아니면 예외가 발생한다`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            BonusNumber("A").parse()
        }
        Assertions.assertEquals("숫자만 입력 가능합니다.", exception.message)
    }

    @Test
    fun `당첨 통계를 계산한다`() {
        var test1Ticket = LottoTicket()
        val test1WinningNumber = test1Ticket.lottoNumbers.toString().replace("[", "").replace("]", "")

        var test2Ticket = LottoTicket()
        var test2WinningNumber = test2Ticket.lottoNumbers.toString().replace("[", "").replace("]", "")

        val testTickets = listOf(test1Ticket, test2Ticket)

        assertAll(
            {
                val testCalculator = WinningCalculator(testTickets, WinnerNumber(test1WinningNumber), 1)
                assertEquals(
                    (LOTTO_MAX_REWARD / (testTickets.size * LOTTO_TICKET_PRICE)).toDouble(),
                    testCalculator.calculateRate(testTickets.size)
                )
            },
            {
                val testCalculator = WinningCalculator(testTickets, WinnerNumber(test2WinningNumber), 1)
                assertEquals(
                    (LOTTO_MAX_REWARD / (testTickets.size * LOTTO_TICKET_PRICE)).toDouble(),
                    testCalculator.calculateRate(testTickets.size)
                )
            },
        )
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
        const val LOTTO_MAX_REWARD = 2000000000
        const val LOTTO_TICKET_PRICE = 1000
    }
}
