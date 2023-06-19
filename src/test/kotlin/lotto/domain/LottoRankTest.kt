package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoRankTest : StringSpec({
    "보너스공이 일치, 공 5개 일치하면 LottoRank.SECOND_BONUS이다" {
        LottoRank.of(5, true) shouldBe LottoRank.SECOND_BONUS

    }
    "보너스공이 불일치, 공 5개 일치하면 LottoRank.SECOND" {
        LottoRank.of(5, false) shouldBe LottoRank.SECOND

    }

    "공이 일치하는 개수가 5개가 아니라면 보너스공 일치여부와 상관없이 Rank를 구할 수 있다." {
        LottoRank.of(5, false) shouldBe LottoRank.SECOND

        listOf(
            0 to LottoRank.NONE,
            2 to LottoRank.NONE,
            3 to LottoRank.FOURTH,
            4 to LottoRank.THIRD,
            6 to LottoRank.FIRST
        ).forEach { (matchingCount, rank) ->
            LottoRank.of(matchingCount, false) shouldBe rank
            LottoRank.of(matchingCount, true) shouldBe rank
        }

    }
})
