package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoRankSpec : FunSpec({
    test("보너스 볼이 맞지 않은 경우 Rank가 결정된다") {
        forAll(
            row(6, LottoRank.FIRST),
            row(5, LottoRank.THIRD),
            row(4, LottoRank.FOURTH),
            row(3, LottoRank.FIFTH),
            row(2, LottoRank.MISS),
            row(1, LottoRank.MISS),
            row(0, LottoRank.MISS),
        ) { countOfMatch, expect ->
            val result = LottoRank.valueOf(countOfMatch, false)
            result shouldBe expect
        }
    }

    test("보너스 볼이 맞은 경우 Rank가 결정된다") {
        forAll(
            row(6, LottoRank.FIRST),
            row(5, LottoRank.SECOND),
            row(4, LottoRank.FOURTH),
            row(3, LottoRank.FIFTH),
            row(2, LottoRank.MISS),
            row(1, LottoRank.MISS),
            row(0, LottoRank.MISS),
        ) { countOfMatch, expect ->
            val result = LottoRank.valueOf(countOfMatch, true)
            result shouldBe expect
        }
    }
})
