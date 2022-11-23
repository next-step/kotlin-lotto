package simulator.lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class RankTest{
    @Test
    fun `등수별로 상금을 반환한다`(){
        assertThat(Rank.FIRST.prize()).isEqualTo(2000000000)
        assertThat(Rank.SECOND.prize()).isEqualTo(1500000)

    }

    @Test
    fun `맞는 로또 번호의 갯수에 따라 등수를 매긴다`(){
        val first = Rank.match(6)
        val second = Rank.match(5)
        val third = Rank.match(4)
        val fourth = Rank.match(3)

        assertThat(first).isEqualTo(Rank.FIRST)
        assertThat(second).isEqualTo(Rank.SECOND)
        assertThat(third).isEqualTo(Rank.THIRD)
        assertThat(fourth).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `등수를 매기지 않는 값이라면 null을 반환한다`(){
        assertThat(Rank.match(7)).isNull()
        assertThat(Rank.match(2)).isNull()
    }
}