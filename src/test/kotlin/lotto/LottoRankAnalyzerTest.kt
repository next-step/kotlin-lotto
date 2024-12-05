package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoStatistics
import lotto.domain.Rank

class LottoRankAnalyzerTest : StringSpec({
    "당첨 개수들을 그룹핑하여 결과를 만들어낸다." {
        val analyzedResult = LottoRankAnalyzer.analyze(listOf(Rank.FIFTH))
        val expected =
            listOf(
                LottoStatistics(1, Rank.FIFTH),
                LottoStatistics(0, Rank.FOURTH),
                LottoStatistics(0, Rank.THIRD),
                LottoStatistics(0, Rank.SECOND),
                LottoStatistics(0, Rank.FIRST),
            )

        analyzedResult shouldBe expected
    }
})
