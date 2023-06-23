package step2Lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import step2Lotto.domain.LottoService

class LottoServiceTest {
    private val lottoService = LottoService()

    @Test
    fun `구매 금액에 따른 로또를 몇장 구매할 수 있는지 계산한다`() {
        val purchaseAmount = 5000
        lottoService.getLottoTicketQuantity(purchaseAmount) shouldBe 5
    }
}