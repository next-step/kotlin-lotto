package lotto.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoShopTest {

    private lateinit var shop: LottoShop

    @BeforeEach
    fun setup() {
        shop = LottoShop()
    }

    @DisplayName("구입 금액이 0원보다 작으면 RuntimeException 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(
        ints = [-10000, -50000]
    )
    fun lottoShopNegative(price: Int) {
        assertThrows<RuntimeException> { shop.buyLotto(price) }
    }

    @DisplayName("구매한 금액 만큼의 로또가 발급되어야 한다.")
    @ParameterizedTest
    @CsvSource(
        value = [
            "14000|14",
            "0|0",
            "37500|37"
        ],
        delimiter = '|'
    )
    fun lottoShopCount(amount: String, count: String) {
        val expected = count.toInt()
        val actual = shop.buyLotto(amount.toInt()).size
        Assertions.assertEquals(expected, actual)
    }
}
