package lotto

import lotto.domain.LottoStore
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoStoreTest {

    @ParameterizedTest
    @CsvSource(value = ["15000:15", "14800:14", "23111:23"], delimiter = ':')
    fun `구매 갯수 확인`(input: Int, count: Int) {
        val purchasableCount = LottoStore(input, 0).purchasable
        assertThat(purchasableCount).isEqualTo(count)
    }

    @ParameterizedTest
    @CsvSource(value = ["15000:15", "14800:14", "23111:23"], delimiter = ':')
    internal fun `로또 구매`(input: Int, count: Int) {
        val purchasedLotto = LottoStore(input, 0).purchase()
        assertThat(purchasedLotto.count()).isEqualTo(count)
    }

    @ParameterizedTest
    @CsvSource(value = ["15000:15", "14800:14", "23111:23"], delimiter = ':')
    fun `수동 구매 갯수 확인`(input: Int, count: Int) {
        val purchasableCount = LottoStore(input, count).purchasable
        assertThat(purchasableCount).isEqualTo(0)
    }

    @ParameterizedTest
    @CsvSource(value = ["15000:15", "14800:14", "23111:23"], delimiter = ':')
    fun `수동 구매 불가`(input: Int, count: Int) {
        assertThrows<IllegalArgumentException> { LottoStore(input, count + 1).purchasable }
    }
}
