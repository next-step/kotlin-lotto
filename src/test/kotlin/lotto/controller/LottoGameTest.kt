package lotto.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoGameTest {
    @Test
    fun `구입 금액에 맞는 수량만큼 자동 번호 로또를 발행한다`() {
        assertThat(LottoGame().purchaseAutomaticLottoTicket(10).size).isSameAs(10)
    }
}
