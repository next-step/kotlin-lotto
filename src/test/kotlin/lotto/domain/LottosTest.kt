package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottosTest : FunSpec({
    context("로또번호 일치 개수별 당첨된 로또 개수를 확인한다.") {
        val lottos = Lottos(
            listOf(
                // 꽝
                createSimpleLottoNumbers(1, 10, 11, 12, 13, 14), // 1개
                createSimpleLottoNumbers(1, 10, 11, 12, 13, 14), // 1개

                createSimpleLottoNumbers(1, 2, 10, 11, 12, 13), // 2개

                // 5등
                createSimpleLottoNumbers(1, 2, 3, 10, 11, 12), // 3개

                // 4등
                createSimpleLottoNumbers(1, 2, 3, 4, 10, 11), // 4개

                // 3등
                createSimpleLottoNumbers(1, 2, 3, 4, 5, 10), // 5개

                // 2등
                createSimpleLottoNumbers(1, 2, 3, 4, 5, 7), // 5개 + 보너스

                // 1등
                createSimpleLottoNumbers(1, 2, 3, 4, 5, 6), // 6개
                createSimpleLottoNumbers(1, 2, 3, 4, 5, 6), // 6개
            ),
        )
        val winningLotto = WinningLotto(createSimpleLottoNumbers(1, 2, 3, 4, 5, 6), 7)

        val winningStatistics = lottos.match(winningLotto)

        winningStatistics.getCountByRank(Rank.MISS) shouldBe 3
        winningStatistics.getCountByRank(Rank.FIFTH) shouldBe 1
        winningStatistics.getCountByRank(Rank.FOURTH) shouldBe 1
        winningStatistics.getCountByRank(Rank.THIRD) shouldBe 1
        winningStatistics.getCountByRank(Rank.SECOND) shouldBe 1
        winningStatistics.getCountByRank(Rank.FIRST) shouldBe 2
    }
})
