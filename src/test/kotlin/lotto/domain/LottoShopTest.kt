@file:Suppress("NonAsciiCharacters")

package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoShopTest {
    @Test
    fun `로또 구입 금액과 수동 로또 번호가 주어지면, 수동 로또를 발급하고 나머지 금액으로 자동 로또를 발급한다`() {
        val purchaseAmount = Won(14000)
        val manualLottoNumbers = (1..6).map(::LottoNumber)
        val autoNumbers = (2..7).toList()
        val lottoNumberGenerator = FakeLottoNumberGenerator(autoNumbers)
        val lottoShop = LottoShop(lottoNumberGenerator)

        val actual = lottoShop.purchaseLottos(purchaseAmount, listOf(manualLottoNumbers))

        assertThat(actual).hasSize((purchaseAmount / Lotto.PRICE).amount.toInt())
        assertThat(actual.first()).usingRecursiveComparison()
            .isEqualTo(Lotto(manualLottoNumbers))
        assertThat(actual.drop(1)).usingRecursiveFieldByFieldElementComparator()
            .containsOnly(Lotto(autoNumbers.map(::LottoNumber)))
    }

    @Test
    fun `주어진 구입 금액으로 주어진 수만큼의 수동 로또를 구매할 수 없으면 IllegalArgumentException이 발생한다`() {
        val purchaseAmount = Lotto.PRICE
        val manualLottoNumbers = List(2) { (1..6).map(::LottoNumber) }
        val autoNumbers = (2..7).toList()
        val lottoNumberGenerator = FakeLottoNumberGenerator(autoNumbers)
        val lottoShop = LottoShop(lottoNumberGenerator)

        val actual = assertThrows<IllegalArgumentException> {
            lottoShop.purchaseLottos(purchaseAmount, manualLottoNumbers)
        }

        assertThat(actual).hasMessageContaining("Not enough money to purchase lotto")
    }
}
