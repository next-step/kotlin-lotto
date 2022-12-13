package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoRankTest : StringSpec({
    "matchCount에 따른 LottoRank를 반환한다" {
        forAll(
            row(3, false, LottoRank.FIFTH),
            row(4, false, LottoRank.FOURTH),
            row(5, false, LottoRank.THIRD),
            row(5, true, LottoRank.SECOND),
            row(6, false, LottoRank.FIRST),
        ) { matchCount, bonus, expected ->
            LottoRank.of(matchCount, bonus) shouldBe expected
        }
    }
})
