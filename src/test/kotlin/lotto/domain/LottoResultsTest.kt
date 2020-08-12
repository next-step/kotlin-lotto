package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoResultsTest {

    @CsvSource("FIRST,1", "SECOND,2", "THIRD,3", "FOURTH,4", "FIFTH,5")
    @ParameterizedTest
    fun `해당 로또 결과의 개수르 잘 가져오는지 확인`(lottoResult: LottoResult, count: Int) {
        // given
        val lottoResults = LottoResults(
            mapOf(lottoResult to count)
        )

        // then
        assertThat(lottoResults.countOf(lottoResult)).isEqualTo(count)
    }

    @Test
    fun `로또 결과의 총 상금을 잘 계산하는지 확인`() {
        // given
        val lottoResults = LottoResults(
            mapOf(
                LottoResult.FOURTH to 1,
                LottoResult.FIFTH to 2,
                LottoResult.LOSE to 5
            )
        )
        val totalPrize = LottoMoney(LottoResult.FOURTH.prize + LottoResult.FIFTH.prize * 2)

        // then
        assertThat(lottoResults.getTotalPrize()).isEqualTo(totalPrize)
    }
}
