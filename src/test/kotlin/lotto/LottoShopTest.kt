package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoShopTest {
    
    @Test
    fun `로또 n장 사기`() {
        val lottoShop = LottoShop()
        val count = 5
        val lottos = lottoShop.buy(5)
        lottos.size shouldBe count
    }
}
