package lotto.domain

import lotto.view.ResultView.floorPowerOfTwo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoResultTest {
    // given
    private val lottoResult = LottoResult()

    @BeforeEach
    fun setUp() {
        lottoResult.add(LottoRank.FIFTH)
    }

    @DisplayName("로또 결과 확인 테스트")
    @Test
    fun `로또 결과 확인 테스트`() {
        // when, then
        assertThat(lottoResult.getLottoRankCount(LottoRank.FIRST)).isEqualTo(0)
        assertThat(lottoResult.getLottoRankCount(LottoRank.THIRD)).isEqualTo(0)
        assertThat(lottoResult.getLottoRankCount(LottoRank.FOURTH)).isEqualTo(0)
        assertThat(lottoResult.getLottoRankCount(LottoRank.FIFTH)).isEqualTo(1)
        assertThat(lottoResult.getLottoRankCount(LottoRank.MISS)).isEqualTo(0)
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    fun `수익률 계산 테스트`() {
        // given
        val amount = 14_000
        val expected = 0.35f

        // when
        val result = lottoResult.calculateProfitRate(amount)
        val actual = floorPowerOfTwo(result)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("당첨 결과 계산 테스트")
    @Test
    fun `당첨 결과 계산 테스트`() {
        // given
        lottoResult.add(LottoRank.FIFTH)

        // when
        val actual = lottoResult.getLottoRankCount(LottoRank.FIFTH)

        // then
        assertThat(actual).isEqualTo(2)
    }
}
