package simulator.lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class RankTest{
    @Test
    fun `등수별로 상금을 반환한다`(){
        assertThat(Rank.FIRST.prize()).isEqualTo(2_000_000_000)
        assertThat(Rank.SECOND.prize()).isEqualTo(1_500_000)
        assertThat(Rank.THIRD.prize()).isEqualTo(50_000)
        assertThat(Rank.FOURTH.prize()).isEqualTo(5_000)
    }

    @Test
    fun `맞는 로또 갯수에 따라 등수를 반환한다`(){
        assertThat(Rank.aggregate(6)).isEqualTo(Rank.FIRST)
        assertThat(Rank.aggregate(5)).isEqualTo(Rank.SECOND)
        assertThat(Rank.aggregate(4)).isEqualTo(Rank.THIRD)
        assertThat(Rank.aggregate(3)).isEqualTo(Rank.FOURTH)
    }
}