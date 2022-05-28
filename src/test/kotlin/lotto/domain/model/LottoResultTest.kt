package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoResultTest {
    @Test
    fun `LottoResult는 1등부터 4등까지의 당첨 결과를 모두 보관한다`() {
        val lottoWinningList = listOf(
            LottoWinning(LottoRank.FOURTH, 2),
            LottoWinning(LottoRank.THIRD, 1),
            LottoWinning(LottoRank.SECOND, 1),
            LottoWinning(LottoRank.FIRST, 0)
        )

        val lottoResult = LottoResult(lottoWinningList)

        assertThat(lottoResult.value).isEqualTo(lottoWinningList)
    }

    @Test
    fun `1등부터 4등까지의 당첨 결과 중 빠진 게 있다면 IllegalArgumentException이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val lottoWinningList = listOf(
                LottoWinning(LottoRank.FOURTH, 2),
                LottoWinning(LottoRank.THIRD, 1)
            )

            val lottoResult = LottoResult(lottoWinningList)

            assertThat(lottoResult.value).isEqualTo(lottoWinningList)
        }
    }

    @Test
    fun `한 등수의 당첨 결과가 여러 개 들어갔다면 IllegalArgumentException이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val lottoWinningList = listOf(
                LottoWinning(LottoRank.FOURTH, 2),
                LottoWinning(LottoRank.THIRD, 1),
                LottoWinning(LottoRank.SECOND, 1),
                LottoWinning(LottoRank.FIRST, 0),
                LottoWinning(LottoRank.FIRST, 100)
            )

            val lottoResult = LottoResult(lottoWinningList)

            assertThat(lottoResult.value).isEqualTo(lottoWinningList)
        }
    }

    @Test
    fun `get operator를 통해 적절한 LottoWinning을 가져올 수 있다`() {
        val lottoWinningList = listOf(
            LottoWinning(LottoRank.FOURTH, 2),
            LottoWinning(LottoRank.THIRD, 1),
            LottoWinning(LottoRank.SECOND, 1),
            LottoWinning(LottoRank.FIRST, 0)
        )
        val lottoResult = LottoResult(lottoWinningList)

        val expected = LottoWinning(LottoRank.FOURTH, 2)

        assertThat(lottoResult[LottoRank.FOURTH]).isEqualTo(expected)
    }

    @Test
    fun `Int, Int를 key-value로 하는 Map을 넘겨서 LottoResult를 만들 수 있다`() {
        val lottoWinningMap = mapOf(
            NumberOfMatches(3) to 3,
            NumberOfMatches(4) to 1,
            NumberOfMatches(6) to 1
        )
        val lottoResult = LottoResult.from(lottoWinningMap)

        assertThat(lottoResult[LottoRank.FOURTH].count).isEqualTo(3)
        assertThat(lottoResult[LottoRank.THIRD].count).isEqualTo(1)
        assertThat(lottoResult[LottoRank.SECOND].count).isEqualTo(0)
        assertThat(lottoResult[LottoRank.FIRST].count).isEqualTo(1)
    }

    @Test
    fun `getTotalEarns를 통해 총 복권 당첨금을 구할 수 있다`() {
        val lottoWinningList = listOf(
            LottoWinning(LottoRank.FOURTH, 2),
            LottoWinning(LottoRank.THIRD, 1),
            LottoWinning(LottoRank.SECOND, 1),
            LottoWinning(LottoRank.FIRST, 0)
        )
        val lottoResult = LottoResult(lottoWinningList)

        val expected = lottoWinningList.sumOf { lottoWinning ->
            lottoWinning.rank.winnings * lottoWinning.count
        }

        assertThat(lottoResult.getTotalEarns()).isEqualTo(expected)
    }
}
