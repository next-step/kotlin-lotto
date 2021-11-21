package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @ParameterizedTest
    @ValueSource(booleans = [true, false])
    fun `숫자 6개가 일치하면 보너스 볼 포함 여부에 관계없이 1등에 당첨된다`(bonus: Boolean) {
        // given
        val first = Ranking.calculate(6, bonus)

        // then
        assertThat(first).isEqualTo(Ranking.FIRST)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `일치하는 숫자가 3개 미만이면 꽝이다`(match: Int) {
        // given
        val none = Ranking.calculate(match, false)

        // then
        assertThat(none).isEqualTo(Ranking.NONE)
    }
}
