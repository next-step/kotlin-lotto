package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoShopTest {
    @Test
    fun getNumberOfPurchaseTest() {
        assertThat(LottoShop.getNumberOfPurchase(1000)).isEqualTo(1)
    }

    @Test
    fun getNumberOfPurchaseExceptionTest() {
        assertThrows<RuntimeException> {
            LottoShop.getNumberOfPurchase(777)
        }
    }

    @Test
    fun getLottoNumbersTest() {
        assertThat(LottoShop.getLottoNumbers(7).count()).isEqualTo(7)
    }
}
