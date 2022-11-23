package lotto.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoTicketsTest {

    @ValueSource(ints = [1, 5, 14])
    @ParameterizedTest
    internal fun `로또 티켓이 생성된다`(size: Int) {
        // given
        // when
        val lottoTickets = LottoTickets.randomTickets(size)

        // then
        assertThat(lottoTickets.count()).isEqualTo(size)
    }

    @ValueSource(ints = [0, -1])
    @ParameterizedTest
    internal fun `로또 티켓 생성시 0 또는 음수가 올 수없다`(input: Int) {
        // given

        // when, then
        assertThatIllegalArgumentException().isThrownBy { LottoTickets.randomTickets(input) }
    }

    @Test
    internal fun `로또 티켓의 수가 반환된다`() {
        // given
        val lottoTickets = LottoTickets(
            listOf(
                LottoTicket(1, 2, 3, 10, 11, 12),
                LottoTicket(1, 2, 3, 4, 11, 12)
            )
        )

        // when, then
        assertThat(lottoTickets.count()).isEqualTo(2)
    }

    @Test
    internal fun `상금 합계가 반환된다`() {
        // given
        val lottoTickets = LottoTickets(
            listOf(
                LottoTicket(1, 2, 3, 10, 11, 12),
                LottoTicket(1, 2, 3, 4, 11, 12)
            )
        )

        val winningTicket = LottoTicket(1, 2, 3, 4, 5, 6)

        // when
        val benefitPrice = lottoTickets.benefitPrice(winningTicket)

        // then
        assertThat(benefitPrice).isEqualTo(55000)
    }


    @Test
    internal fun `받을 수 있는 상금 타입이 반환된다`() {
        // given
        val lottoTickets = LottoTickets(
            listOf(
                LottoTicket(1, 2, 3, 10, 11, 12),
                LottoTicket(1, 2, 3, 10, 11, 12),
                LottoTicket(1, 2, 3, 4, 11, 12)
            )
        )

        val winningTicket = LottoTicket(1, 2, 3, 4, 5, 6)

        // when
        val result = lottoTickets.getResult(winningTicket)

        // then
        assertThat(result[Award.FIFTH_PLACE]).isEqualTo(2)
        assertThat(result[Award.FOURTH_PLACE]).isEqualTo(1)
        assertThat(result[Award.FIRST_PLACE]).isNull()
    }
}
