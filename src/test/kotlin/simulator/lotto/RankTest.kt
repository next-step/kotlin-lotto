package simulator.lotto

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class RankTest {
    @Test
    fun `숫자 여섯개가 일치하면 FIRST(1등)이며 상금은 2_000_000_000이다`() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST)
        assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST)
        assertThat(Rank.FIRST.winningMoney).isEqualTo(2_000_000_000)
    }

    @Test
    fun `숫자 다섯개가 일치하고 보너스 숫자까지 일치한다면 SECOND(2등)이며 상금은 30_000_000이다`() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND)
        assertThat(Rank.valueOf(5, false)).isNotEqualTo(Rank.SECOND)
        assertThat(Rank.SECOND.winningMoney).isEqualTo(30_000_000)
    }

    @Test
    fun `숫자 다섯개가 일치하고 보너스 숫자는 일치하지 않다면 THIRD(3등)이며 상금은 1_500_000이다`() {
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD)
        assertThat(Rank.valueOf(5, true)).isNotEqualTo(Rank.THIRD)
        assertThat(Rank.THIRD.winningMoney).isEqualTo(1_500_000)
    }

    @Test
    fun `숫자 네개가 일치하면 FOURTH(4등)이며 상금은 50_000이다`() {
        assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH)
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH)
        assertThat(Rank.FOURTH.winningMoney).isEqualTo(50_000)
    }

    @Test
    fun `숫자 세개가 일치하면 FIFTH(5등)이며 상금은 5_000이다`() {
        assertThat(Rank.valueOf(3, true)).isEqualTo(Rank.FIFTH)
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH)
        assertThat(Rank.FIFTH.winningMoney).isEqualTo(5_000)
    }

    @Test
    fun `맞는 로또 갯수가 2개 이하라면 MISS이며 상금은 없다`() {
        assertThat(Rank.valueOf(2, true)).isEqualTo(Rank.MISS)
        assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.MISS)
        assertThat(Rank.valueOf(1, true)).isEqualTo(Rank.MISS)
        assertThat(Rank.valueOf(1, false)).isEqualTo(Rank.MISS)
        assertThat(Rank.valueOf(0, true)).isEqualTo(Rank.MISS)
        assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.MISS)
        assertThat(Rank.MISS.winningMoney).isEqualTo(0)
    }

    @Test
    fun `로또와 당첨 번호를 통해 등수를 구분할 수 있다`() {
        val numbers = Numbers.of(listOf(1, 2, 3, 4, 5, 6))
        val second = Numbers.of(listOf(1,2,3,4,5,7))
        val actual = Rank.match(Lotto(numbers), WinningNumber(numbers, Number(7)))
        actual shouldBe Rank.FIRST
        second shouldBe Rank.SECOND
    }
}