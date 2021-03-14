package lotto.domain.result

import lotto.domain.createLottoResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoResultTest {
    @DisplayName("로또 결과 Map 을 받아서 수익률 반환")
    @Test
    fun getEarning() {
        val result = createLottoResult()
        result[LottoRank.FOURTH] = 1
        val expected = 5.0

        val actual = LottoResult(result).earning

        assertThat(actual).isEqualTo(expected)
    }
}
