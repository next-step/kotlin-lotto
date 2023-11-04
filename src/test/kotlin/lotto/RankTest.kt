package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.WithDataTestName
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class RankTest : FunSpec({

    context("랭크 순위, 상금 확인") {
        withData(
            RankSet(6, Rank.FIRST, 2_000_000_000),
            RankSet(5, Rank.SECOND, 1_500_000),
            RankSet(4, Rank.THIRD, 50_000),
            RankSet(3, Rank.FOURTH, 5_000),
            RankSet(2, Rank.NO_RANK, 0),
            RankSet(0, Rank.NO_RANK, 0),
        ) { (matchCount, rank, prize) ->
            rank shouldBe Rank.of(matchCount)
            prize shouldBe rank.prize
        }
    }
})

data class RankSet(val matchCount: Int, val rank: Rank, val prize: Int) : WithDataTestName {
    override fun dataTestName(): String {
        return "${matchCount}개 일치 시 랭크: ${rank}, 상금: ${prize}원"
    }

}