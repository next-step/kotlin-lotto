package lotto.domain.machine

import lotto.domain.LottoTicket
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ManualLottoMachineTest {

    @Test
    internal fun `수동으로 로또를 구매한다`() {
        // given
        val lottoMachine = ManualLottoMachine(
            listOf(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(2, 3, 4, 5, 6, 7)
            )
        )

        // when
        val lottoTickets = lottoMachine.publish()

        // then
        assertThat(lottoTickets.items).containsExactly(
            LottoTicket(1, 2, 3, 4, 5, 6),
            LottoTicket(2, 3, 4, 5, 6, 7),
        )
    }
}
