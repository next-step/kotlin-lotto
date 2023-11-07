package study.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    fun `Lottos 객체는 올바른 개수의 Lotto 객체를 포함한다`() {
        val purchaseAmount = 3000
        val lottos = Lottos.generateLottos(purchaseAmount)
        assertEquals(purchaseAmount / Lotto.PRICE_PER_TICKET, lottos.count())
    }
}
