package lotto.domain

import lotto.view.LottoOutputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertAll

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LottoStatisticsTest {

    val winningLotto = WinningLotto(Lotto(mutableSetOf(1, 2, 3, 4, 5, 6)))
    var lottos: MutableList<Lotto> = mutableListOf()
    lateinit var lottoStatistics: LottoStatistics

    @BeforeEach
    fun setUp() {
        lottos.add(Lotto(mutableSetOf(8, 21, 23, 41, 42, 43)))
        lottos.add(Lotto(mutableSetOf(3, 5, 11, 16, 32, 38)))
        lottos.add(Lotto(mutableSetOf(7, 11, 16, 35, 36, 44)))
        lottos.add(Lotto(mutableSetOf(1, 8, 11, 31, 41, 42)))
        lottos.add(Lotto(mutableSetOf(13, 14, 16, 38, 42, 45)))
        lottos.add(Lotto(mutableSetOf(7, 11, 30, 40, 42, 43)))
        lottos.add(Lotto(mutableSetOf(2, 13, 22, 32, 38, 45)))
        lottos.add(Lotto(mutableSetOf(23, 25, 33, 36, 39, 41)))
        lottos.add(Lotto(mutableSetOf(1, 3, 5, 14, 22, 45)))
        lottos.add(Lotto(mutableSetOf(5, 9, 38, 41, 43, 44)))
        lottos.add(Lotto(mutableSetOf(2, 8, 9, 18, 19, 21)))
        lottos.add(Lotto(mutableSetOf(13, 14, 18, 21, 23, 35)))
        lottos.add(Lotto(mutableSetOf(17, 21, 29, 37, 42, 45)))
        lottos.add(Lotto(mutableSetOf(3, 8, 27, 30, 35, 44)))
    }

    @Test
    fun `당첨 번호와 로또 티켓을 비교하여 등수 결과를 생성한다`() {
        val winningLotto = WinningLotto(Lotto(mutableSetOf(1, 2, 3, 4, 5, 6)))
        var lottos: MutableList<Lotto> = mutableListOf()
        lottos.add(Lotto(mutableSetOf(1, 2, 3, 4, 5, 6))) // 1등
        lottos.add(Lotto(mutableSetOf(1, 2, 3, 4, 5, 16))) // 2등
        lottos.add(Lotto(mutableSetOf(1, 2, 3, 24, 5, 6))) // 2등
        lottos.add(Lotto(mutableSetOf(2, 5, 3, 4, 25, 16))) // 3등
        lottos.add(Lotto(mutableSetOf(11, 2, 3, 4, 6, 8))) // 3등
        lottos.add(Lotto(mutableSetOf(11, 2, 3, 4, 25, 16))) // 4등
        lottos.add(Lotto(mutableSetOf(31, 12, 3, 4, 15, 16))) // 미당첨
        var lottoStatistics =
            LottoStatistics(winningLotto.getMatchesCount(lottos), lottos.size * LottoFactory.LOTTE_PRICE)
        LottoOutputView.printWinningStatistics(lottoStatistics)
        assertAll(
            { assertThat(lottoStatistics.firstPlace).isEqualTo(1) },
            { assertThat(lottoStatistics.secondPlace).isEqualTo(2) },
            { assertThat(lottoStatistics.thirdPlace).isEqualTo(2) },
            { assertThat(lottoStatistics.lastPlace).isEqualTo(1) }
        )
    }

    @Test
    fun `등수 결과로 당첨 통계의 수익율을 계산한다`() {
        lottoStatistics =
            LottoStatistics(winningLotto.getMatchesCount(lottos), lottos.size * LottoFactory.LOTTE_PRICE)
        assertThat(lottoStatistics.rateOfReward).isEqualTo(0.35)
    }
}
