package lotto.domain

import lotto.domain.machine.RandomLottoMachine
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class TicketStoreTest {

    @CsvSource(value = ["1000:1", "14000:14"], delimiter = ':')
    @ParameterizedTest
    internal fun `로또 티켓 구매가 된다`(inputMoney: Int, expectedSize: Int) {
        // given
        // when
        val lottoTickets = TicketStore.buyTickets(RandomLottoMachine(inputMoney))

        // then
        assertThat(lottoTickets.items).hasSize(expectedSize)
    }

    @ValueSource(ints = [900, 12100])
    @ParameterizedTest
    internal fun `로또 티켓 가격보다 낮거나, 잔금이 남으면 구매가 실패한다`(inputMoney: Int) {
        // given

        // when, then
        assertThatIllegalArgumentException().isThrownBy { TicketStore.buyTickets(RandomLottoMachine(inputMoney)) }
    }


    @Test
    internal fun `수익률이 반환된다`() {
        // given
        val lottoTickets = LottoTickets(
            listOf(
                LottoTicket(1, 2, 3, 10, 11, 12),
                LottoTicket(1, 2, 3, 10, 11, 12)
            )
        )
        val winningTicket = LottoTicket(1, 2, 3, 4, 5, 6)
        val awardResults = lottoTickets.awardResults(winningTicket)

        // when
        val profitability = TicketStore.profitability(awardResults)
        // then
        assertThat(profitability).isEqualTo(5.0)

    }

    @Test
    internal fun `입력받은 번호대로 로또 티켓이 생성된다`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        // when
        val winningTicket = TicketStore.createWinningTicket(numbers)

        // then
        assertThat(
            winningTicket.numbers
        ).containsExactly(
            LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
            LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)
        )

    }
}
