package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoShopTest {
    @DisplayName("주어진 금액만큼 구입한 로또 개수를 반환한다")
    @Test
    fun `purchase amount`() {
        // given
        val payment = Payment(5000)
        val manualLottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )
        val manualLottos = listOf(Lotto(manualLottoNumbers))

        // when
        val totalAmount = LottoShop.sellTickets(payment, manualLottos).size()

        // then
        assertThat(totalAmount).isEqualTo(5)
    }
}
