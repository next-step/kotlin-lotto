package simulator.lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class RankTest {
    @Test
    fun `등수별로 상금을 반환한다`() {
        assertThat(Rank.FIRST.winningMoney).isEqualTo(2_000_000_000)
        assertThat(Rank.SECOND.winningMoney).isEqualTo(30_000_000)
        assertThat(Rank.THIRD.winningMoney).isEqualTo(1_500_000)
        assertThat(Rank.FOURTH.winningMoney).isEqualTo(50_000)
        assertThat(Rank.FIFTH.winningMoney).isEqualTo(5_000)
        assertThat(Rank.MISS.winningMoney).isEqualTo(0)
    }

    @Test
    fun `숫자 여섯개가 일치하면 FIRST`() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST)
        assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `숫자 다섯개가 일치하고 보너스 숫자까지 일치한다면 SECOND`() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND)
        assertThat(Rank.valueOf(5, false)).isNotEqualTo(Rank.SECOND)
    }

    @Test
    fun `숫자 다섯개가 일치하고 보너스 숫자는 일치하지 않다면 THIRD`() {
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD)
        assertThat(Rank.valueOf(5, true)).isNotEqualTo(Rank.THIRD)
    }

    @Test
    fun `숫자 네개가 일치하면 FOURTH`() {
        assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH)
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `숫자 세개가 일치하면 FIFTH`() {
        assertThat(Rank.valueOf(3, true)).isEqualTo(Rank.FIFTH)
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `일치하는 숫자가 없거나 두개 이하면 MISS`() {
        assertThat(Rank.valueOf(2, true)).isEqualTo(Rank.MISS)
        assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.MISS)
        assertThat(Rank.valueOf(1, true)).isEqualTo(Rank.MISS)
        assertThat(Rank.valueOf(1, false)).isEqualTo(Rank.MISS)
        assertThat(Rank.valueOf(0, true)).isEqualTo(Rank.MISS)
        assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.MISS)
    }

    @Test
    fun `맞는 로또 갯수가 존재하지 않는다면 MISS를 반환한다`() {
        assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.MISS)
        assertThat(Rank.valueOf(1, false)).isEqualTo(Rank.MISS)
    }

    @Test
    fun `로또와 당첨 번호를 통해 등수를 구분할 수 있다`() {
        val number = Number(sortedSetOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7

        val actual = Rank.match(Lotto(number), WinningNumber(number, bonusNumber))
        assertThat(actual).isEqualTo(Rank.FIRST)
    }
}