package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoResultTest {
    @Test
    fun `LottoResult는 1등부터 5등까지의 당첨 결과를 모두 보관한다`() {
        val lottoWinnings = mapOf(
            LottoRank.FIFTH to 2,
            LottoRank.FOURTH to 2,
            LottoRank.THIRD to 1,
            LottoRank.SECOND to 1
        )

        val lottoResult = LottoResult.from(lottoWinnings)

        assertAll(
            { assertThat(lottoResult[LottoRank.FIFTH].count).isEqualTo(2) },
            { assertThat(lottoResult[LottoRank.FOURTH].count).isEqualTo(2) },
            { assertThat(lottoResult[LottoRank.THIRD].count).isEqualTo(1) },
            { assertThat(lottoResult[LottoRank.SECOND].count).isEqualTo(1) },
            { assertThat(lottoResult[LottoRank.FIRST].count).isEqualTo(0) }
        )
    }

    @Test
    fun `get operator를 통해 적절한 LottoWinning을 가져올 수 있다`() {
        val lottoWinnings = mapOf(
            LottoRank.FIFTH to 2,
            LottoRank.FOURTH to 2,
            LottoRank.THIRD to 1,
            LottoRank.SECOND to 1
        )

        val lottoResult = LottoResult.from(lottoWinnings)

        val expected = LottoWinning(LottoRank.FOURTH, 2)

        assertThat(lottoResult[LottoRank.FOURTH]).isEqualTo(expected)
    }

    @Test
    fun `getTotalEarns를 통해 총 복권 당첨금을 구할 수 있다`() {
        val lottoWinnings = mapOf(
            LottoRank.FIFTH to 2,
            LottoRank.FOURTH to 2,
            LottoRank.THIRD to 1,
            LottoRank.SECOND to 1
        )

        val lottoResult = LottoResult.from(lottoWinnings)

        val expected = lottoWinnings.entries.sumOf { (rank, count) ->
            rank.winnings * count
        }

        assertThat(lottoResult.getTotalEarns()).isEqualTo(expected)
    }
}
