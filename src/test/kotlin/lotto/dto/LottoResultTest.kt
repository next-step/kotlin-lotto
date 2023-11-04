package lotto.dto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `로또 결과 생성`() {
        val lottoResult = LottoResult()
        for (i in 0..3) {
            lottoResult.updateExact(i)
        }
        assertThat(lottoResult.getExact(0)).isEqualTo(1)
        assertThat(lottoResult.getExact(1)).isEqualTo(1)
        assertThat(lottoResult.getExact(2)).isEqualTo(1)
        assertThat(lottoResult.getExact(3)).isEqualTo(1)
        assertThat(lottoResult.getExact(4)).isEqualTo(0)
        assertThat(lottoResult.getExact(5)).isEqualTo(0)
        assertThat(lottoResult.getExact(6)).isEqualTo(0)
        assertThat(lottoResult.getRatio(6000)).isEqualTo(5000.0 / 6000.0)
    }
}
