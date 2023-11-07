@file:Suppress("NonAsciiCharacters")

package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoShopTest {
    @Test
    fun `로또 구입 금액이 주어지면 구입 금액만큼 로또를 발급한다`() {
        val purchaseAmount = 14000L

        val actual = LottoShop.purchaseLottos(purchaseAmount)

        assertThat(actual).hasSize((purchaseAmount / Lotto.PRICE).toInt())
    }
}
