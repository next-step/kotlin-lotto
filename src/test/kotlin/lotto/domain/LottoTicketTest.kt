package lotto.domain

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class LottoTicketTest {
    @Test
    fun `클래스 생성자 성공 테스트`() {
        assertDoesNotThrow {
            LottoTicket(
                listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) },
            )
        }
    }

    @Test
    fun `클래스 생성자 실패 테스트`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            LottoTicket(
                makeLottoNumbers(1, 2, 3, 4, 5, 6, 7),
            )
            LottoTicket(
                makeLottoNumbers(1, 2, 3, 4, 5),
            )
        }
    }

    @Test
    fun `생성 확인`() {
        val tickets =
            LottoTicket.generateLottoTickets(1) {
                listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) }
            }

        val winner = LottoTicket(makeLottoNumbers(1, 2, 3, 4, 5, 6))
        winner.correctNumberCount(tickets[0]) shouldBe 6
    }

    @Test
    fun `1등 확인`() {
        val ticket = LottoTicket(makeLottoNumbers(1, 2, 3, 4, 5, 6))
        val winner = LottoTicket(makeLottoNumbers(1, 2, 3, 4, 5, 6))
        winner.correctNumberCount(ticket) shouldBe 6
    }

    @Test
    fun `3등 확인`() {
        val ticket = LottoTicket(makeLottoNumbers(1, 2, 3, 4, 7, 8))
        val winner = LottoTicket(makeLottoNumbers(1, 2, 3, 4, 5, 6))
        winner.correctNumberCount(ticket) shouldBe 4
    }

    companion object {
        fun makeLottoNumbers(vararg elements: Int): List<LottoNumber> {
            return elements.map { LottoNumber.from(it) }
        }
    }
}
