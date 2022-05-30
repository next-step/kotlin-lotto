package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * Created by Jaesungchi on 2022.05.30..
 */
class LottoResultsTest {
    @Test
    internal fun `5등이 2장 당첨된 로또 결과에서 상금을 잘 뽑아낸다`() {
        val lottoResults = LottoResults(listOf(LottoResult(Prize.FIFTH, 2)))
        assertThat(lottoResults.getReward()).isEqualTo(10000)
    }

    @Test
    internal fun `5등이 2장 당첨된 로또 결과에서 당첨갯수를 잘 뽑아낸다`() {
        val lottoResults = LottoResults(listOf(LottoResult(Prize.FIFTH, 2)))
        assertThat(lottoResults.getPrizeCount(Prize.FIFTH)).isEqualTo(2)
    }
}
