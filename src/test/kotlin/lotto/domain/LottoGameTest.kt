package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class LottoGameTest {

    private lateinit var lottoGame: LottoGame

    @BeforeEach
    fun setup() {
        lottoGame = LottoGame(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `당첨 숫자와 일치하는 숫자가 3개 이다`() {
        val lottoNumbers = listOf(1, 2, 3, 7, 8, 9)
        assertThat(lottoGame.findMatchCount(lottoNumbers)).isEqualTo(3)
    }

    @Test
    fun `당첨 숫자와 일치하는 숫자가 4개 이다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 8, 9)
        assertThat(lottoGame.findMatchCount(lottoNumbers)).isEqualTo(4)
    }

    @Test
    fun `당첨 숫자와 일치하는 숫자가 5개 이다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 9)
        assertThat(lottoGame.findMatchCount(lottoNumbers)).isEqualTo(5)
    }

    @Test
    fun `3등이 1개인 경우`() {
        lottoGame.addMatchedLottoRankCount(LottoRank.THIRD)
        assertThat(lottoGame.getRankCount(LottoRank.THIRD)).isEqualTo(1)
    }

    @Test
    fun `2등이 3개인 경우`() {
        lottoGame.addMatchedLottoRankCount(LottoRank.SECOND)
        lottoGame.addMatchedLottoRankCount(LottoRank.SECOND)
        lottoGame.addMatchedLottoRankCount(LottoRank.SECOND)
        assertThat(lottoGame.getRankCount(LottoRank.SECOND)).isEqualTo(3)
    }
}
