package lotto

import lotto.Ranking.Rank.FIRST
import lotto.Ranking.Rank.MISS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGameTest {
    @Test
    fun `구매 수량만큼 비교한다`() {
        val pickLottoNumbers: List<LottoNumbers> = listOf(
            LottoNumbers(1, 2, 3, 4, 5, 6),
            LottoNumbers(1, 2, 3, 4, 5, 6),
            LottoNumbers(11, 12, 13, 14, 15, 16)
        )

        val winningNumbers: WinningNumbers = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 6), 7)

        assertThat(LottoGame(winningNumbers, pickLottoNumbers).result)
            .containsExactlyInAnyOrder(FIRST, FIRST, MISS)
    }
}
