package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import step2.domain.Lotto
import step2.domain.Lottos
import step2.domain.Statistics

class StatisticsTest {

    @Test
    @DisplayName("당첨 숫자 5개인 로또 1개, 3개인 로또 2개에 대한 수익")
    fun matchingTest() {
        val answer = Lotto(listOf(1, 10, 20, 31, 41, 44))

        val lotto1 = Lotto(listOf(1, 10, 20, 30, 40, 45)) // 3개
        val lotto2 = Lotto(listOf(1, 11, 21, 31, 41, 45)) // 3개
        val lotto3 = Lotto(listOf(1, 12, 22, 32, 42, 45)) // 1개
        val lotto4 = Lotto(listOf(1, 13, 23, 33, 43, 45)) // 1개
        val lotto5 = Lotto(listOf(1, 10, 20, 31, 44, 45)) // 5개

        val lottos = Lottos(listOf(lotto1, lotto2, lotto3, lotto4, lotto5))

        val matchCount = lottos.getAnswerCountList(answer)

        val statistics = Statistics(matchCount)

        assertThat(statistics.revenue()).isEqualTo(1510000)
    }

    @ParameterizedTest
    @CsvSource(value = ["3,3:1.0", "5:150.0", "3,4:5.5"], delimiter = ':')
    @DisplayName("구입한 로또(10000원)의 금액 대비 당첨 금액에 대한 수익률")
    fun rateOfReturnTest(winLotto: String, result: Double) {
        val statistics = Statistics(winLotto.split(",").map { it.toInt() })
        val rateOfReturn = statistics.rateOfRevenue(statistics.revenue(), 10000)
        assertThat(rateOfReturn).isEqualTo(result)
    }
}
