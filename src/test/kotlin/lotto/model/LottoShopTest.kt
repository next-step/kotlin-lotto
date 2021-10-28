package lotto.model

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
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
}
