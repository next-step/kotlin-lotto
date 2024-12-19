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
    fun `클래스 생성자 실패 테스트-5개번호`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            LottoTicket(DEFAULT_NUMBERS.take(5))
        }
    }

    @Test
    fun `클래스 생성자 실패 테스트-7개번호`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            LottoTicket(DEFAULT_NUMBERS + LottoNumber(7))
        }
    }

    @Test
    fun `비교 - 같은 번호 6개 확인`() {
        val ticket = LottoTicket(makeLottoNumbers(1, 2, 3, 4, 5, 6))
        DEFAULT_LOTTO_TICKET.correctNumberCount(ticket) shouldBe 6
    }

    @Test
    fun `비교 - 같은 번호 4개 확인`() {
        val ticket = LottoTicket(makeLottoNumbers(1, 2, 3, 4, 7, 8))
        DEFAULT_LOTTO_TICKET.correctNumberCount(ticket) shouldBe 4
    }

    companion object {
        val DEFAULT_NUMBERS = makeLottoNumbers(1, 2, 3, 4, 5, 6)
        val DEFAULT_LOTTO_TICKET = LottoTicket(DEFAULT_NUMBERS)

        fun makeLottoNumbers(vararg elements: Int): List<LottoNumber> {
            return elements.map { LottoNumber.from(it) }
        }
    }
}
