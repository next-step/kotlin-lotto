package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import step2.domain.Lotto
import step2.domain.Lottos
import step2.domain.Statistics

class StatisticsTest {

    @Test
    @DisplayName("5개의 로또중 숫자 3개가 매칭된 경우가 2개일 경우")
    fun matchingTest() {
        val lotto1 = Lotto(listOf(1, 10, 20, 30, 40, 45))
        val lotto2 = Lotto(listOf(1, 11, 21, 31, 41, 45))
        val lotto3 = Lotto(listOf(1, 12, 22, 32, 42, 45))
        val lotto4 = Lotto(listOf(1, 13, 23, 33, 43, 45))
        val lotto5 = Lotto(listOf(1, 14, 24, 34, 44, 45))
        val answer = Lotto(listOf(1, 10, 20, 31, 41, 44))

        val lottos = Lottos(listOf(lotto1, lotto2, lotto3, lotto4, lotto5))

        val matchCount = lottos.getAnswerCountList(answer)

        Statistics().matchCount(matchCount)
        assertThat(Statistics.matchThreeCount).isEqualTo(2)
    }
}
