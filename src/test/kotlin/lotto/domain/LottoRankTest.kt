package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoRankTest : StringSpec({
    "matchCount에 따른 LottoRank를 반환한다" {
        forAll(
            row(3, LottoRank.FIFTH),
            row(4, LottoRank.FOURTH),
            row(5, LottoRank.THIRD),
            row(6, LottoRank.FIRST),
        ) { matchCount, expected ->
            LottoRank.of(matchCount) shouldBe expected
        }
    }
})
