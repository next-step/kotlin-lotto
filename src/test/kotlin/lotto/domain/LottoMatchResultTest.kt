package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.comparables.shouldBeGreaterThanOrEqualTo
import io.kotest.matchers.ints.shouldBeGreaterThan

class LottoMatchResultTest : FunSpec({

    val lottoMatchResult = LottoMatchResult(
        WinningLotto(listOf(1, 2, 3, 4, 5, 6)),
        listOf(Lotto(listOf(1, 2, 3, 7, 8, 9)), Lotto(), Lotto(), Lotto(), Lotto())
    )

    test("matchingCountBy") {
        lottoMatchResult.matchingCountBy(3) shouldBeGreaterThan 0
    }

    test("rateOfReturn") {
        lottoMatchResult.rateOfReturn().toDouble() shouldBeGreaterThanOrEqualTo 1.0
    }
})
