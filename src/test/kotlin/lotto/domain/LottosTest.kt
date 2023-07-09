package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottosTest : FunSpec({
    context("로또번호 일치 개수별 당첨된 로또 개수를 확인한다.") {
        val lottos = Lottos(
            listOf(
                // 꽝
                createSimpleLotto(1, 10, 11, 12, 13, 14), // 1개
                createSimpleLotto(1, 10, 11, 12, 13, 14), // 1개

                createSimpleLotto(1, 2, 10, 11, 12, 13), // 2개

                // 5등
                createSimpleLotto(1, 2, 3, 10, 11, 12), // 3개

                // 4등
                createSimpleLotto(1, 2, 3, 4, 10, 11), // 4개

                // 3등
                createSimpleLotto(1, 2, 3, 4, 5, 10), // 5개

                // 2등
                createSimpleLotto(1, 2, 3, 4, 5, 7), // 5개 + 보너스

                // 1등
                createSimpleLotto(1, 2, 3, 4, 5, 6), // 6개
                createSimpleLotto(1, 2, 3, 4, 5, 6), // 6개
            ),
        )
        val winningLotto = WinningLotto(createSimpleLottoNumbers(1, 2, 3, 4, 5, 6), 7)

        val winningStatistics = lottos.match(winningLotto)

        winningStatistics.winningStatistics[Rank.MISS] shouldBe 3
        winningStatistics.winningStatistics[Rank.FIFTH] shouldBe 1
        winningStatistics.winningStatistics[Rank.FOURTH] shouldBe 1
        winningStatistics.winningStatistics[Rank.THIRD] shouldBe 1
        winningStatistics.winningStatistics[Rank.SECOND] shouldBe 1
        winningStatistics.winningStatistics[Rank.FIRST] shouldBe 2
    }
})
