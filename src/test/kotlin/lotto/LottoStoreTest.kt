package lotto

import lotto.domain.LottoStore
import lotto.domain.dto.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoStoreTest {

    @ParameterizedTest
    @CsvSource(value = ["15000:15", "14800:14", "23111:23"], delimiter = ':')
    fun `구매 갯수 확인`(input: Int, count: Int) {
        val purchasableCount = LottoStore(input, emptyList()).autoPurchasableCount
        assertThat(purchasableCount).isEqualTo(count)
    }

    @ParameterizedTest
    @CsvSource(value = ["15000:15", "14800:14", "23111:23"], delimiter = ':')
    internal fun `로또 구매`(input: Int, count: Int) {
        val purchasedLotto = LottoStore(input, emptyList()).purchased()
        assertThat(purchasedLotto.count()).isEqualTo(count)
    }

    @ParameterizedTest
    @CsvSource(value = ["15000:15", "14800:14", "23111:23"], delimiter = ':')
    fun `수동 구매 갯수 확인`(input: Int, count: Int) {
        val purchasableCount = LottoStore(input, List(count) { LottoNumber(emptyList()) }).autoPurchasableCount
        assertThat(purchasableCount).isEqualTo(0)
    }

    @ParameterizedTest
    @CsvSource(value = ["15000:15", "14800:14", "23111:23"], delimiter = ':')
    fun `수동 구매 불가`(input: Int, count: Int) {
        assertThrows<IllegalArgumentException> {
            LottoStore(
                input,
                List(count + 1) { LottoNumber(emptyList()) }
            ).autoPurchasableCount
        }
    }
}
