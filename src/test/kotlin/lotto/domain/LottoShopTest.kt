package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoShopTest {
    private val payment = Payment(5000)

    @DisplayName("주어진 금액만큼 구입한 로또 개수를 반환한다")
    @Test
    fun `purchase amount`() {
        // given
        val payment = Payment(5000)

        // when
        val amount = LottoShop(payment).sellTickets().size

        // then
        assertThat(amount).isEqualTo(5)
    }
}
