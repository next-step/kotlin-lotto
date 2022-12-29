package lotto

import lotto.model.AutomaticLottoTicketGenerator
import lotto.model.LottoNumber
import lotto.model.LottoTicket
import lotto.model.ManualLottoTicketGenerator
import lotto.model.TicketQuantity
import lotto.model.WinningCalculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

internal class LottoAllTest {
    @Test
    fun `임의의 6개 숫자를 중복없이 생성한다`() {
        val testTicket = AutomaticLottoTicketGenerator().generate(1)
        assertThat(testTicket[0].values.toSet().size).isEqualTo(LOTTO_NUMBER_SIZE)
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
    fun `1등 당첨 통계를 계산한다`() {
        assertAll(
            {
                var testTicket = AutomaticLottoTicketGenerator().generate(1)
                val testWinningNumber = testTicket[0].values.toString().replace("[", "").replace("]", "")
                val result =
                    WinningCalculator().generateWinningStatistics(testTicket, LottoTicket(testWinningNumber), 1)
                assertEquals(
                    (LOTTO_MAX_REWARD / (testTicket.size * LOTTO_TICKET_PRICE)).toDouble(),
                    result.rate
                )
            },
            {
                var testTicket = AutomaticLottoTicketGenerator().generate(1)
                var testWinningNumber = testTicket[0].values.toString().replace("[", "").replace("]", "")
                val result =
                    WinningCalculator().generateWinningStatistics(testTicket, LottoTicket(testWinningNumber), 1)
                assertEquals(
                    2000000.0,
                    result.rate
                )
            },
            {
                var testTicket = ManualLottoTicketGenerator().generate(listOf("1, 2, 3, 4, 5, 6"))
                var testWinningNumber = "1, 2, 3, 4, 5, 6"
                val result =
                    WinningCalculator().generateWinningStatistics(testTicket, LottoTicket(testWinningNumber), 1)
                assertEquals(
                    2000000.0,
                    result.rate
                )
            }
        )
    }

    @Test
    fun `2등 당첨 통계를 계산한다`() {
        var testTicket = ManualLottoTicketGenerator().generate(listOf("1, 2, 3, 4, 5, 7"))
        var testWinningNumber = "1, 2, 3, 4, 5, 6"
        val result = WinningCalculator().generateWinningStatistics(testTicket, LottoTicket(testWinningNumber), 7)
        assertEquals(
            30000.0,
            result.rate
        )
    }

    @Test
    fun `3등 당첨 통계를 계산한다`() {
        var testTicket = ManualLottoTicketGenerator().generate(listOf("1, 2, 3, 4, 5, 7"))
        var testWinningNumber = "1, 2, 3, 4, 5, 6"
        val result = WinningCalculator().generateWinningStatistics(testTicket, LottoTicket(testWinningNumber), 8)
        assertEquals(
            1500.0,
            result.rate
        )
    }

    @Test
    fun `4등 당첨 통계를 계산한다`() {
        var testTicket = ManualLottoTicketGenerator().generate(listOf("1, 2, 3, 4, 15, 17"))
        var testWinningNumber = "1, 2, 3, 4, 5, 6"
        val result = WinningCalculator().generateWinningStatistics(testTicket, LottoTicket(testWinningNumber), 8)
        assertEquals(
            50.0,
            result.rate
        )
    }

    @Test
    fun `5등 당첨 통계를 계산한다`() {
        var testTicket = ManualLottoTicketGenerator().generate(listOf("1, 2, 3, 14, 15, 17"))
        var testWinningNumber = "1, 2, 3, 4, 5, 6"
        val result = WinningCalculator().generateWinningStatistics(testTicket, LottoTicket(testWinningNumber), 8)
        assertEquals(
            5.0,
            result.rate
        )
    }

    @Test
    fun `미당첨 통계를 계산한다`() {
        var testTicket = ManualLottoTicketGenerator().generate(listOf("11, 12, 13, 14, 15, 17"))
        var testWinningNumber = "1, 2, 3, 4, 5, 6"
        val result = WinningCalculator().generateWinningStatistics(testTicket, LottoTicket(testWinningNumber), 8)
        assertEquals(
            0.0,
            result.rate
        )
    }

    @Test
    fun `수량에 맞는 수동 번호 로또를 발행한다`() {
        assertThat(
            ManualLottoTicketGenerator().generate(
                listOf(
                    "1, 2, 3, 4, 5, 6",
                    "11, 12, 13, 14, 15, 16"
                )
            ).size
        ).isSameAs(2)
    }

    @Test
    fun `정상적으로 자동 번호 로또가 발생하는 확인한다`() {
        assertDoesNotThrow {
            AutomaticLottoTicketGenerator().generate(1)
        }
    }

    @Test
    fun `수량만큼 자동 번호 로또를 발행한다`() {
        val testTicket = AutomaticLottoTicketGenerator().generate(2)
        testTicket.forEach {
            assertThat(it.values.size).isEqualTo(LOTTO_NUMBER_SIZE)
        }
        assertThat(testTicket.size).isEqualTo(2)
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
        const val LOTTO_MAX_REWARD = 2_000_000_000
        const val LOTTO_TICKET_PRICE = 1_000
    }
}
