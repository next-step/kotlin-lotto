package lotto.dto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `로또 결과 생성`() {
        val lottoResult = LottoResult()
        for (price in listOf(LottoPrice.NOT_MATCHED, LottoPrice.ONE_MATCHED, LottoPrice.TWO_MATCHED, LottoPrice.THREE_MATCHED)) {
            lottoResult.updateExact(price)
        }
        assertThat(lottoResult.getExact(LottoPrice.NOT_MATCHED)).isEqualTo(1)
        assertThat(lottoResult.getExact(LottoPrice.ONE_MATCHED)).isEqualTo(1)
        assertThat(lottoResult.getExact(LottoPrice.TWO_MATCHED)).isEqualTo(1)
        assertThat(lottoResult.getExact(LottoPrice.THREE_MATCHED)).isEqualTo(1)
        assertThat(lottoResult.getExact(LottoPrice.FOUR_MATCHED)).isEqualTo(0)
        assertThat(lottoResult.getExact(LottoPrice.FIVE_MATCHED)).isEqualTo(0)
        assertThat(lottoResult.getExact(LottoPrice.FIVE_MATCHED_WITH_BONUS)).isEqualTo(0)
        assertThat(lottoResult.getExact(LottoPrice.ALL_MATCHED)).isEqualTo(0)
        assertThat(lottoResult.getRatio(6000)).isEqualTo(5000.0 / 6000.0)
    }
}
