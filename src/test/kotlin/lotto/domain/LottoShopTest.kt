@file:Suppress("NonAsciiCharacters")

package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoShopTest {
    @Test
    fun `로또 구입 금액이 주어지면 구입 금액만큼 로또를 발급한다`() {
        val purchaseAmount = 14000L
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lottoNumberGenerator = FakeLottoNumberGenerator(numbers)
        val lottoShop = LottoShop(lottoNumberGenerator)

        val actual = lottoShop.purchaseLottos(purchaseAmount)

        assertThat(actual).hasSize((purchaseAmount / Lotto.PRICE).toInt())
        assertThat(actual).usingRecursiveFieldByFieldElementComparator()
            .containsOnly(Lotto(numbers.map(::LottoNumber)))
    }
}
