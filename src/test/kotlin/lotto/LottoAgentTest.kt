package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoAgentTest {
    @Test
    fun `구매수량만큼 로또번호를 생성한다`() {
        val exchange: Exchange<LottoNumbers> = LottoAgent(LottoDrawMachine((1..45))).exchange
        exchange.pay(Money(14_000))
        assertThat(exchange.product().size).isEqualTo(14)
    }
}
