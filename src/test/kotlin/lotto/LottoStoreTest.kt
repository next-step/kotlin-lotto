package lotto

import lotto.domain.LottoStore
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoStoreTest {

    @ParameterizedTest
    @CsvSource(value = ["15000:15", "14800:14", "23111:23"], delimiter = ':')
    fun `구매 갯수 확인`(input: Int, count: Int) {
        val ableToPurchaseCount = LottoStore(input).purchasable
        assertThat(ableToPurchaseCount).isEqualTo(count)
    }

    @ParameterizedTest
    @CsvSource(value = ["15000:15", "14800:14", "23111:23"], delimiter = ':')
    internal fun `로또 구매`(input: Int, count: Int) {
        val purchasedLotto = LottoStore(input).purchase()
        assertThat(purchasedLotto.count()).isEqualTo(count)
    }
}
