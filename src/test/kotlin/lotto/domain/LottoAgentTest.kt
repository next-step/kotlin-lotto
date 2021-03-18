package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoAgentTest {
    @Test
    fun `수동,자동 구매수량만큼 로또번호를 생성한다`() {
        val exchange: Exchange<LottoNumbers> = LottoAgent(LottoDrawMachine((1..45))).exchange
        val manualPick = LottoNumbers(1, 2, 3, 4, 5, 6)
        exchange.pay(Money(14_000), listOf(manualPick))
        assertThat(exchange.product()).hasSize(14)
            .contains(manualPick)
    }
}
