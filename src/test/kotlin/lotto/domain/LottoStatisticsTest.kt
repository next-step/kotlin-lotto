package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LottoStatisticsTest {

    val winningLotto = WinningLotto(Lotto(setOf(1, 2, 3, 4, 5, 6)))
    var lottos: MutableList<Lotto> = mutableListOf()
    lateinit var lottoStatistics: LottoStatistics

    @BeforeEach
    fun setUp() {
        lottos.add(Lotto(setOf(8, 21, 23, 41, 42, 43)))
        lottos.add(Lotto(setOf(3, 5, 11, 16, 32, 38)))
        lottos.add(Lotto(setOf(7, 11, 16, 35, 36, 44)))
        lottos.add(Lotto(setOf(1, 8, 11, 31, 41, 42)))
        lottos.add(Lotto(setOf(13, 14, 16, 38, 42, 45)))
        lottos.add(Lotto(setOf(7, 11, 30, 40, 42, 43)))
        lottos.add(Lotto(setOf(2, 13, 22, 32, 38, 45)))
        lottos.add(Lotto(setOf(23, 25, 33, 36, 39, 41)))
        lottos.add(Lotto(setOf(1, 3, 5, 14, 22, 45)))
        lottos.add(Lotto(setOf(5, 9, 38, 41, 43, 44)))
        lottos.add(Lotto(setOf(2, 8, 9, 18, 19, 21)))
        lottos.add(Lotto(setOf(13, 14, 18, 21, 23, 35)))
        lottos.add(Lotto(setOf(17, 21, 29, 37, 42, 45)))
        lottos.add(Lotto(setOf(3, 8, 27, 30, 35, 44)))
        lottoStatistics =
            LottoStatistics(winningLotto.getMatchesCount(lottos), lottos.size * LottoFactory.LOTTE_PRICE)
    }

    @ParameterizedTest
    @CsvSource("1 2 3 4 5 6,6", "1 2 3 4 5 16,5", "2 5 3 4 25 16,4", "11 2 3 4 19 8,3")
    fun `당첨 번호와 로또 티켓을 비교하여 등수 결과를 생성한다`(numbers: String, matchesCount: Int) {
        var lottos: List<Lotto> = listOf(Lotto(numbers.split(" ").map { it.toInt() }.toSet()))
        var lottoStatistics =
            LottoStatistics(winningLotto.getMatchesCount(lottos), lottos.size * LottoFactory.LOTTE_PRICE)
        assertThat(lottoStatistics.matchesResult.getValue(LottoRule.ofMatchesCount(matchesCount))).isEqualTo(1)
    }

    @Test
    fun `등수 결과로 당첨 통계의 수익율을 계산한다`() {
        assertThat(lottoStatistics.rateOfReward).isEqualTo(0.35)
    }
}
