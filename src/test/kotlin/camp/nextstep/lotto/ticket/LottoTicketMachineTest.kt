package camp.nextstep.lotto.ticket

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
}
