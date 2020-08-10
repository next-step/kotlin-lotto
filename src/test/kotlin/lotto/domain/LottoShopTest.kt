package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoShopTest {

    @DisplayName("주어진 금액만큼 구입한 로또 개수를 반환한다 (수동로또 =1, 자동로또 =4 이므로 총 5를 반환")
    @Test
    fun `total purchase quantity`() {
        // given
        val payment = Payment(5000)
        val manualLottoNumbers =
            listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.of(it) }

        val manualLottos = listOf(Lotto(manualLottoNumbers))

        // when
        val totalQuantity = LottoShop.sellTickets(payment, manualLottos).size()

        // then
        assertThat(totalQuantity).isEqualTo(5)
    }
}
