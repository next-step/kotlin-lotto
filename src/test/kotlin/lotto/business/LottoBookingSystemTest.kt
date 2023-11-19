package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LottoBookingSystemTest {

    @Test
    fun `로또 티켓을 개수만큼 생성한다`() {
        // given
        val lottoBookingSystem = LottoBookingSystem()

        // when
        val lottoTickets = lottoBookingSystem.generateMultipleTickets(3)

        // then
        Assertions.assertAll(
            { Assertions.assertEquals(3, lottoTickets.size) },
        )
    }

    @Test
    fun `로또 숫자와 일치 한 로또 번호를 돌려준다`() {
        // when
        val lottoNumber = LottoBookingSystem.getLottoNumber(1)

        // then
        Assertions.assertAll(
            { assertThat(lottoNumber.number).isEqualTo(1) },
        )
    }

    @Test
    fun `로또 숫자와 정확하지 않으면 예외를 던진다`() {
        // when,then
        assertThatThrownBy {
            LottoBookingSystem.getLottoNumber(0)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessage("로또 번호는 1~45 사이의 숫자여야 합니다.")
    }

    @Test
    fun `로또 숫자 리스트로 로또 티켓을 생성한다`() {
        // given
        val lottoBookingSystem = LottoBookingSystem()
        val manualTicketsNumbers = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(2, 3, 4, 5, 6, 7)
        )

        // when
        val lottoTicket = lottoBookingSystem.generateManualTickets(manualTicketsNumbers)

        // then
        Assertions.assertAll(
            {
                assertThat(lottoTicket[0].lottoNumbers).containsExactlyInAnyOrder(
                    LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6)
                )
                assertThat(lottoTicket[1].lottoNumbers).containsExactlyInAnyOrder(
                    LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6), LottoNumber(7)
                )
            },
        )
    }
}
