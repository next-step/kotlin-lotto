package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class WinningStatisticsTest : FunSpec({
    context("로또번호 일치 개수별 당첨된 로또 개수를 확인한다.") {
        val lottos = Lottos(
            listOf(
                Lotto(listOf(1, 10, 11, 12, 13, 14)), // 1개
                Lotto(listOf(1, 10, 11, 12, 13, 14)), // 1개

                Lotto(listOf(1, 2, 10, 11, 12, 13)), // 2개

                Lotto(listOf(1, 2, 3, 10, 11, 12)), // 3개

                Lotto(listOf(1, 2, 3, 4, 10, 11)), // 4개

                Lotto(listOf(1, 2, 3, 4, 5, 10)), // 5개

                Lotto(listOf(1, 2, 3, 4, 5, 6)), // 6개
                Lotto(listOf(1, 2, 3, 4, 5, 6)), // 6개
            ),
        )
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val winningStatistics = WinningStatistics.of(lottos, winningLotto)

        winningStatistics[1] shouldBe 2
        winningStatistics[2] shouldBe 1
        winningStatistics[3] shouldBe 1
        winningStatistics[4] shouldBe 1
        winningStatistics[5] shouldBe 1
        winningStatistics[6] shouldBe 2
    }
})
