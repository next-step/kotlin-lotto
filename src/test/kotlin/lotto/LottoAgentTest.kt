package lotto

import lotto.LottoDrawMachineTest.LottoDrawMachine
import lotto.LottoDrawMachineTest.LottoNumber
import lotto.LottoTicketTest.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoAgentTest {
    @Test
    fun `구매수량만큼 로또번호를 생성한다`() {
        val exchange: Exchange = LottoAgent(LottoDrawMachine((1..45))).exchange()
        exchange.pay(Money(14_000))
        assertThat(exchange.product()).isNotNull
    }

    class LottoAgent(lottoDrawMachine: LottoDrawMachine) {
        fun exchange(): Exchange = Exchange()
    }

    class Exchange {
        fun pay(money: Money) {
        }

        fun product(): List<LottoNumber> = listOf()
    }
}
