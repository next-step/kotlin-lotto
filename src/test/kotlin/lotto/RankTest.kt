package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.WithDataTestName
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import lotto.domain.Rank

class RankTest : FunSpec({

    context("랭크 순위, 상금 확인") {
        withData(
            RankSet(6, false, Rank.FIRST, 2_000_000_000),
            RankSet(5, true, Rank.SECOND, 30_000_000),
            RankSet(5, false, Rank.THIRD, 1_500_000),
            RankSet(4, false, Rank.FOURTH, 50_000),
            RankSet(3, false, Rank.FIFTH, 5_000),
            RankSet(2, false, Rank.NO_RANK, 0),
            RankSet(0, false, Rank.NO_RANK, 0),
        ) { (matchCount, matchBonus, rank, prize) ->
            rank shouldBe Rank.from(matchCount, matchBonus)
            prize shouldBe rank.prize
        }
    }
})

data class RankSet(val matchCount: Int, val matchBonus: Boolean, val rank: Rank, val prize: Int) : WithDataTestName {
    override fun dataTestName(): String {
        return if (matchBonus)
            "${matchCount}개 일치와 보너스 볼 포함시 랭크: $rank, 상금: ${prize}원"
        else
            "${matchCount}개 일치와 보너스 볼 미 포함시 랭크: $rank, 상금: ${prize}원"
    }
}
