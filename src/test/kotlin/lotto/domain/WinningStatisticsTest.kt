package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class WinningStatisticsTest : StringSpec() {
    init {
        "로또의 3개, 4개, 5개 6개 일치 수를 알 수 있다" {
            val winningStatistics = WinningStatistics(WinningNumbers("1,2,3,4,5,6"))

            val lottos = Lottos(listOf(
                Lotto("1,2,3,4,5,6"),
                Lotto("1,2,3,4,5,7"),
                Lotto("1,2,3,4,7,8"),
                Lotto("1,2,3,7,8,9")))

            winningStatistics.rank(lottos)

            winningStatistics.countOfMatchCount(6) shouldBe 1
            winningStatistics.countOfMatchCount(5) shouldBe 1
            winningStatistics.countOfMatchCount(4) shouldBe 1
            winningStatistics.countOfMatchCount(3) shouldBe 1
        }

        "로또 수익률을 알 수 있다" {
            val winningStatistics = WinningStatistics(WinningNumbers("1,2,3,4,5,6"))
            val lottos = Lottos(listOf(Lotto("1,2,3,7,8,9")))

            winningStatistics.rank(lottos)

            winningStatistics.profit shouldBe 5.0f
        }

    }
}
