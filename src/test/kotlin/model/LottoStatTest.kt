package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoStatTest {

    @Test
    @DisplayName("해당 stat 의 grade 를 반환한다")
    fun `grade`() {
        val lottoStatThird = LottoStat(Rank.THIRD, 3)
        assertThat(lottoStatThird.grade()).isEqualTo(Rank.THIRD.grade)
    }

    @Test
    @DisplayName("특정 grade를 넘었는지 알 수 있다")
    fun `isOverGrade`() {
        val lottoStatThird = LottoStat(Rank.THIRD, 3)
        assertThat(lottoStatThird.isOverGrade(Rank.SECOND.grade)).isEqualTo(false)
    }

    @Test
    @DisplayName("당첨회수를 가지고 당첨 금액을 합산할 수 있다")
    fun `sumPrizeMoney`() {
        val lottoStatThird = LottoStat(Rank.THIRD, 3)
        assertThat(lottoStatThird.sumPrizeMoney()).isEqualTo(Rank.THIRD.prizeMoney * 3)
    }
}
