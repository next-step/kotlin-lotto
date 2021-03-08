package lotto

import lotto.LottoDrawMachineTest.LottoDrawMachine
import lotto.LottoDrawMachineTest.LottoNumber
import lotto.LottoTicketTest.LottoTicket
import lotto.LottoTicketTest.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoAgentTest {
    @Test
    fun `구매수량만큼 로또번호를 생성한다`() {
        val exchange: Exchange<LottoNumber> = LottoAgent(LottoDrawMachine((1..45))).exchange
        exchange.pay(Money(14_000))
        assertThat(exchange.product()).isNotNull
    }

    class LottoAgent(val exchange: Exchange<LottoNumber>) {
        constructor(lottoExchange: LottoDrawMachine) : this(Exchange.Lotto(lottoExchange))
    }

    interface Exchange<Product> {
        fun pay(money: Money)

        fun product(): List<Product>

        class Lotto(private val lottoDrawMachine: LottoDrawMachine) : Exchange<LottoNumber> {
            private lateinit var lottoTicket: LottoTicket
            override fun pay(money: Money) {
                lottoTicket = LottoTicket(money)
            }

            override fun product(): List<LottoNumber> = (0 until lottoTicket.count)
                .map { lottoDrawMachine.lottoNumber() }
        }
    }
}
