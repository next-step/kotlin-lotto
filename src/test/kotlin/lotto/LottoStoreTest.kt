package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoStoreTest {

    private lateinit var lottoStore: LottoStore

    @BeforeEach
    fun setUp() {
        lottoStore = LottoStore()
    }

    @ParameterizedTest(name = "로또 구입 금액은 1장에 1000원으로 계산된 만큼의 로또가 발급된다. {0} 원은 {1} 장으로 계산된다.")
    @CsvSource(
        value = [
            "14000|14",
            "0|0",
            "37500|37"
        ],
        delimiter = '|'
    )
    fun lottoShopCount(amount: Int, count: Int) {
        val resultCount = lottoStore.buy(amount)
        assertThat(resultCount).isEqualTo(count)
    }
}
