package lotto

import lotto.LottoDrawMachineTest.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankingTest {
    @Test
    fun `두 번호그룹을 비교하여 일치수를 알 수 있다`() {
        assertThat(
            Ranking(LottoNumber(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(listOf(1, 2, 3, 4, 5, 6))).rank()
        ).isEqualTo(Ranking.Rank.FIRST)
    }

    class Ranking(lottoNumber: LottoNumber, otherNumber: LottoNumber) {
        fun rank(): Rank = Rank.FIRST

        enum class Rank {
            FIRST
        }
    }
}
