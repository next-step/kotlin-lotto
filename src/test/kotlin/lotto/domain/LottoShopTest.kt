package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoShopTest {
    val payment = Payment(5000)

    @DisplayName("구입금액을 입력하면 로또 구입개수를 알 수 있다")
    @Test
    fun `purchase amount`() {
        assertThat(LottoShop.sellLottos(payment).size).isEqualTo(5)
    }

    @Test
    fun `sold quantity`() {
        assertThat(LottoShop.quantitySold(Payment(500))).isEqualTo(0)
        assertThat(LottoShop.quantitySold(Payment(1500))).isEqualTo(1)
    }
}
