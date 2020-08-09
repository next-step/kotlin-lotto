package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoResultsTest {

    @CsvSource("FIRST,1", "SECOND_BONUS,2", "SECOND,3", "THIRD,4", "FOURTH,5")
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
                LottoResult.THIRD to 1,
                LottoResult.FOURTH to 2,
                LottoResult.LOSE to 5
            )
        )
        val totalPrize = LottoMoney(LottoResult.THIRD.prize + LottoResult.FOURTH.prize * 2)

        // then
        assertThat(lottoResults.getTotalPrize()).isEqualTo(totalPrize)
    }
}
