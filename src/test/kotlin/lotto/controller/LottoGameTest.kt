package lotto.controller

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class LottoGameTest {
    @Test
    fun `구입 금액에 맞는 수량만큼 발행한다`() {
        Assertions.assertThat(LottoGame().purchaseLottoTicket(10).size).isSameAs(10)
    }
}
