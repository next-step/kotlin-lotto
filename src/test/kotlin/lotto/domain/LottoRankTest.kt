package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoRankTest : StringSpec({
    "일치하는 숫자의 개수에 따라서 LottoRank가 정해진다." {
        listOf(
            0 to LottoRank.NONE,
            2 to LottoRank.NONE,
            3 to LottoRank.FOURTH,
            4 to LottoRank.THIRD,
            5 to LottoRank.SECOND,
            6 to LottoRank.FIRST
        ).forEach { (matchingCount, rank) ->
            LottoRank.of(matchingCount) shouldBe rank
        }
    }
})
