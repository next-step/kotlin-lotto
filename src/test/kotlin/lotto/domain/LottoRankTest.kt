package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoRankTest : StringSpec({
    "각 등수에 해당하는 당첨금을 가지고 있다." {
        LottoRank.FIRST.prize shouldBe 2_000_000_000
        LottoRank.SECOND.prize shouldBe 30_000_000
        LottoRank.THIRD.prize shouldBe 1_500_000
        LottoRank.FOURTH.prize shouldBe 50_000
        LottoRank.FIFTH.prize shouldBe 5_000
        LottoRank.NO_RANK.prize shouldBe 0
    }

    "맞춘 숫자에 해당하는 등수를 반환할 수 있다." {
        forAll(
            row(6, false, LottoRank.FIRST),
            row(5, true, LottoRank.SECOND),
            row(5, false, LottoRank.THIRD),
            row(4, true, LottoRank.FOURTH),
            row(4, false, LottoRank.FOURTH),
            row(3, true, LottoRank.FIFTH),
            row(3, false, LottoRank.FIFTH),
            row(2, true, LottoRank.NO_RANK),
            row(2, false, LottoRank.NO_RANK),
            row(1, true, LottoRank.NO_RANK),
            row(0, true, LottoRank.NO_RANK),
            row(0, false, LottoRank.NO_RANK),
        ) { matchCount, bonus, expected ->
            LottoRank.fromMatchAndBonus(matchCount, bonus) shouldBe expected
        }
    }
})
