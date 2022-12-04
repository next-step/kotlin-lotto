package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.EnumMap

class LottoResultTest {
    @Test
    fun `로또 결과 - 순위별 당첨 개수 확인 테스트`() {
        // given
        val lottoResult = initLottoResult()

        // when, then
        assertThat(lottoResult.value[LottoRank.FIRST]).isEqualTo(0)
        assertThat(lottoResult.value[LottoRank.SECOND]).isEqualTo(0)
        assertThat(lottoResult.value[LottoRank.THIRD]).isEqualTo(0)
        assertThat(lottoResult.value[LottoRank.FOURTH]).isEqualTo(0)
        assertThat(lottoResult.value[LottoRank.FIFTH]).isEqualTo(1)
        assertThat(lottoResult.value[LottoRank.MISS]).isEqualTo(0)
    }

    @Test
    fun `로또 결과 - 수익률 계산 테스트`() {
        // given
        val lottoResult = initLottoResult()
        val amount = 14_000
        val expected = 0.35f

        // when
        val actual = lottoResult.calculateProfitRate(amount)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    private fun initLottoResult(): LottoResult {
        val lottoResult: EnumMap<LottoRank, Int> = EnumMap(LottoRank::class.java)
        lottoResult[LottoRank.FIRST] = 0
        lottoResult[LottoRank.SECOND] = 0
        lottoResult[LottoRank.THIRD] = 0
        lottoResult[LottoRank.FOURTH] = 0
        lottoResult[LottoRank.FIFTH] = 1
        lottoResult[LottoRank.MISS] = 0
        return LottoResult(lottoResult)
    }
}
