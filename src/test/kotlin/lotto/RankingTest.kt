package lotto

import org.junit.jupiter.api.Test

class RankingTest {
    @Test
    fun `두 번호그룹을 비교하여 일치수를 알 수 있다`() {
        assertThat(
            Ranking(LottoNumber(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(listOf(1, 2, 3, 4, 5, 6)).rank())
        ).isEqualTo(Rank.FIRST)
    }
}
