package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoMatchTest : StringSpec({
    "matchCount에 따른 LottoMatch를 반환한다" {
        forAll(
            row(3, LottoMatch.THREE),
            row(4, LottoMatch.FOUR),
            row(5, LottoMatch.FIVE),
            row(6, LottoMatch.SIX),
        ) { matchCount, expected ->
            LottoMatch.of(matchCount) shouldBe expected
        }
    }
})
