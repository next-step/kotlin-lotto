package lotto.controller

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LottoGameTest {
    @Test
    fun `구입 금액에 맞는 수량만큼 발행한다`() {
        assertEquals(10, LottoGame().purchaseLottoTicket(10).size)
    }
}
