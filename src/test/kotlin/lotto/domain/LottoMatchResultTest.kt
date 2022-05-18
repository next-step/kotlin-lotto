package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.comparables.shouldBeGreaterThanOrEqualTo
import io.kotest.matchers.ints.shouldBeGreaterThan
import lotto.domain.enums.LottoRank

class LottoMatchResultTest : FunSpec({

    val lottoMatchResult = LottoMatchResult(
        WinningLotto(listOf(1, 2, 3, 4, 5, 6)),
        listOf(Lotto(listOf(1, 2, 3, 7, 8, 9)), Lotto(), Lotto(), Lotto(), Lotto())
    )

    test("matchingCountBy") {
        lottoMatchResult.matchingCountBy(LottoRank.FIFTH) shouldBeGreaterThan 0
    }

    test("rateOfReturn") {
        lottoMatchResult.rateOfReturn().toDouble() shouldBeGreaterThanOrEqualTo 1.0
    }
})
