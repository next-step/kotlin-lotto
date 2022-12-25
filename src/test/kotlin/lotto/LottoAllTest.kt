package lotto

import lotto.controller.LottoGame
import lotto.model.AutomaticLottoTicketGenerator
import lotto.model.LottoNumber
import lotto.model.LottoTicket
import lotto.model.TicketQuantity
import lotto.model.WinningCalculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

internal class LottoAllTest {
    @Test
    fun `임의의 6개 숫자를 중복없이 생성한다`() {
        val testTicket = AutomaticLottoTicketGenerator(1)
        assertThat(testTicket.lottoNumbers[0].values.toSet().size).isSameAs(LOTTO_NUMBER_SIZE)
    }

    @Test
    fun `구입 금액 입력 값이 숫자가 아니면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            TicketQuantity("A")
        }
        assertThat(exception.message).isSameAs("숫자만 입력 가능합니다.")
    }

    @Test
    fun `구입 금액이 최소 1000원 미만이면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            TicketQuantity("999")
        }
        assertThat(exception.message).isSameAs("1000원 이상을 결제해주세요.")
    }

    @Test
    fun `구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            TicketQuantity("1200")
        }
        assertThat(exception.message).isSameAs("1000원 단위로 결제해주세요.")
    }

    @Test
    fun `구입 금액에 맞는 수량만큼 발행한다`() {
        assertThat(LottoGame().purchaseAutomaticLottoTicket(10).size).isSameAs(10)
    }

    @Test
    fun `지난 주 당첨 번호 숫자가 아니면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            LottoTicket("A")
        }
        assertThat(exception.message).isSameAs("숫자만 입력 가능합니다.")
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
        assertThrows<IllegalArgumentException> {
            LottoTicket("1, 2, 3, 4, 5, -6")
        }
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

    @Test
    fun `숫자가 아닌 값을 입력하면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            LottoNumber("A")
        }
        assertThat(exception.message).isSameAs("숫자만 입력 가능합니다.")
    }

    @Test
    fun `1에서 45 사이 값이 아닌 경우 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            LottoNumber("46")
        }
        assertThat(exception.message).isSameAs("1에서 45 사이의 값을 입력하세요.")
    }

    @Test
    fun `당첨 통계를 계산한다`() {
        var test1Ticket = AutomaticLottoTicketGenerator(1).lottoNumbers
        val test1WinningNumber = test1Ticket[0].values.toString().replace("[", "").replace("]", "")

        var test2Ticket = AutomaticLottoTicketGenerator(1).lottoNumbers
        var test2WinningNumber = test2Ticket[0].values.toString().replace("[", "").replace("]", "")

        assertAll(
            {
                val testCalculator = WinningCalculator(test1Ticket, LottoTicket(test1WinningNumber), 1)
                assertEquals(
                    (LOTTO_MAX_REWARD / (test1Ticket.size * LOTTO_TICKET_PRICE)).toDouble(),
                    testCalculator.calculateRate(test1Ticket.size)
                )
            },
            {
                val testCalculator = WinningCalculator(test2Ticket, LottoTicket(test2WinningNumber), 1)
                assertEquals(
                    (LOTTO_MAX_REWARD / (test2Ticket.size * LOTTO_TICKET_PRICE)).toDouble(),
                    testCalculator.calculateRate(test2Ticket.size)
                )
            }
        )
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
        const val LOTTO_MAX_REWARD = 2000000000
        const val LOTTO_TICKET_PRICE = 1000
    }
}
