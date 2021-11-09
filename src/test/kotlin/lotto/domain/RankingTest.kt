package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

class RankingTest {

    @Test
    fun `숫자 5개가 일치했을 때 보너스 번호 일치여부에 따라 2등과 3등을 구분할 수 있다`() {
        // given
        val second = Ranking.calculate(5, true)
        val third = Ranking.calculate(5, false)

        // then
        assertAll(
            { assertThat(second).isEqualTo(Ranking.SECOND) },
            { assertThat(Ranking.isSecond(second)).isTrue },
            { assertThat(third).isEqualTo(Ranking.THIRD) }
        )
    }
}
