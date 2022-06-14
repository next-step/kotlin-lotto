package camp.nextstep.lotto.ticket

import camp.nextstep.lotto.number.LottoNumber.Companion.toLottoNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class LottoTicketMachineTest {

    @DisplayName("티켓 머신에서 정상적인 로또 티켓을 발급받을 수 있다.")
    @Test
    fun issueTicketTest() {
        val machine = LottoTicketMachine()

        assertDoesNotThrow {
            val lottoTicket = machine.issueTicket()
            println(lottoTicket.numbers)
        }
    }

    @DisplayName("티켓 머신에서 자동으로 로또 티켓을 발급받을 수 있다.")
    @Test
    fun issueAutomaticallyTicketTest() {
        val machine = LottoTicketMachine()

        val lottoTicket = machine.issueTicket()
        assertThat(lottoTicket.isAutoGenerated).isTrue
    }

    @DisplayName("티켓 머신에서 수동으로 로또 티켓을 발급받을 수 있다.")
    @Test
    fun issueManuallyTicketTest() {
        val machine = LottoTicketMachine()

        val lottoTicket = machine.issueTicket(listOf(1, 2, 3, 4, 5, 6).toLottoNumbers())
        assertThat(lottoTicket.isAutoGenerated).isFalse
    }
}
