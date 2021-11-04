package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoShopTest {

    private lateinit var shop: LottoShop

    @BeforeEach
    fun setup() {
        shop = LottoShop()
    }

    @DisplayName("구입 금액이 0원보다 작으면 0개의 로또를 반환한다.")
    @Test
    fun lottoShopNegative() {
        val actual = shop.buy(Amount(-1500)).size
        assertThat(actual).isZero
    }

    @ParameterizedTest(name = "구매한 금액 만큼의 로또가 발급되어야 한다.")
    @CsvSource(
        value = [
            "14000|14",
            "0|0",
            "37500|37"
        ],
        delimiter = '|'
    )
    fun lottoShopCount(amount: Int, count: Int) {
        val actual = shop.buy(Amount(amount)).size
        assertThat(actual).isEqualTo(count)
    }

    @DisplayName("수동으로 구매하는 로또 개수는 구입 금액을 초과할 수 없다.")
    @Test
    fun lottoShopPurchaseOver() {
        val amount = 14000
        val lottoNumbers = List(20) { LottoNumbers.random() }

        val expected = 14
        val actual = shop.buy(Amount(amount), lottoNumbers).size
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("수동으로 구매하는 로또를 제외한 나머지는 자동으로 발급한다.")
    fun lottoShopPurchaseAuto() {
        val amount = 14000
        val lottoNumbers = List(10) { LottoNumbers.random() }

        val expected = 4
        val actual = shop.buy(Amount(amount), lottoNumbers).count { it.isAuto }
        assertThat(actual).isEqualTo(expected)
    }
}
