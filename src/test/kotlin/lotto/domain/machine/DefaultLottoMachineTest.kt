package lotto.domain.machine

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class DefaultLottoMachineTest {

    @Test
    internal fun `수기 발행이 처리된다`() {
        // given
        val machine = DefaultLottoMachine(Money.of(2000))

        // when
        val tickets = machine.publishManual(
            listOf(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(2, 3, 4, 5, 6, 7)
            )
        )

        // then
        assertAll(
            { assertThat(machine.money).isEqualTo(Money.of(0)) },
            { assertThat(tickets.count()).isEqualTo(2) },
            { assertThat(tickets.items).containsExactlyInAnyOrder(LottoTicket(1, 2, 3, 4, 5, 6), LottoTicket(2, 3, 4, 5, 6, 7)) }
        )
    }

    @Test
    internal fun `남은 금액만큼 랜덤 티켓이 발행된다`() {
        // given
        val machine = DefaultLottoMachine(Money.of(2000))

        // when
        val tickets = machine.publishRandom(LottoNumber.RANGE)
        // then

        assertThat(tickets.count()).isEqualTo(2)
    }

    @Test
    internal fun `LottoNumber의 지정한 RANGE 내에서 티켓이 발급된다`() {
        // given
        val machine = DefaultLottoMachine(Money.of(1000))

        // when
        val tickets = machine.publishRandom((1..6))

        // then
        assertThat(tickets.items).containsExactly(LottoTicket(1, 2, 3, 4, 5, 6))
    }
}
