package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RanksTest {

    @Test
    fun `1등이 하나 있으면 firstCount 1 나머지는 0, 총 금액 2_000_000_000원`() {
        val ranksThatIsInFirst = Ranks(listOf(Rank.FIRST))

        assertThat(ranksThatIsInFirst.firstCount()).isEqualTo(1)
        assertThat(ranksThatIsInFirst.totalPrize()).isEqualTo(2_000_000_000)
    }

    @Test
    fun `2등이 하나 있으면 secondCount 1 나머지는 0, 총 금액 30_000_000`() {
        val ranksThatIsInFirst = Ranks(listOf(Rank.SECOND))

        assertThat(ranksThatIsInFirst.secondCount()).isEqualTo(1)
        assertThat(ranksThatIsInFirst.totalPrize()).isEqualTo(30_000_000)
    }

    @Test
    fun `3등이 하나 있으면 thirdCount 1 나머지는 0, 1_500_000`() {
        val ranksThatIsInFirst = Ranks(listOf(Rank.THIRD))

        assertThat(ranksThatIsInFirst.thirdCount()).isEqualTo(1)
        assertThat(ranksThatIsInFirst.totalPrize()).isEqualTo(1_500_000)
    }

    @Test
    fun `4등이 하나 있으면 fourthCount 1 나머지는 0, 50_000`() {
        val ranksThatIsInFirst = Ranks(listOf(Rank.FOURTH))

        assertThat(ranksThatIsInFirst.fourthCount()).isEqualTo(1)
        assertThat(ranksThatIsInFirst.totalPrize()).isEqualTo(50_000)
    }

    @Test
    fun `5등이 하나 있으면 fifthCount 1 나머지는 0, 5_000`() {
        val ranksThatIsInFirst = Ranks(listOf(Rank.FIFTH))

        assertThat(ranksThatIsInFirst.fifthCount()).isEqualTo(1)
        assertThat(ranksThatIsInFirst.totalPrize()).isEqualTo(5_000)
    }

    @Test
    fun `꽝이 하나 있으면 missCount 1 나머지는 0, 0`() {
        val ranksThatIsInFirst = Ranks(listOf(Rank.MISS))

        assertThat(ranksThatIsInFirst.missCount()).isEqualTo(1)
        assertThat(ranksThatIsInFirst.totalPrize()).isEqualTo(0)
    }
}
