package camp.nextstep.lotto.user

import camp.nextstep.lotto.ticket.LottoStore
import camp.nextstep.lotto.ticket.LottoTicketMachine
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class GamblerTest {

    @DisplayName("10,000원이 있는 사용자가 로또 한 장에 1,000원인 Store 에서 티켓을 10장 교환한다.")
    @Test
    fun gamblerBuyLottoTicketTest() {
        val user = Gambler(10_000)
        val store = LottoStore(1000, LottoTicketMachine())

        user.exchangeAll(store)

        assertEquals(10, user.tickets.size)
        assertEquals(0, user.balance)
    }
}
