package lotto.service

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto

class LottoCalculatorTest : FunSpec({
    context("로또의 일치 개수를 확인한다.") {
        withData(
            Pair(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(1, 2, 3, 4, 5, 6))) to 6,
            Pair(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(1, 2, 3, 4, 5, 7))) to 5,
            Pair(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(1, 2, 3, 4, 7, 8))) to 4,
            Pair(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(7, 8, 9, 10, 11, 12))) to 0,
        ) { (lottoAndWinningLotto, expectedCount) ->
            val (lotto, winningLotto) = lottoAndWinningLotto
            val matchCount = LottoCalculator.countMatch(lotto, winningLotto)
            matchCount shouldBe expectedCount
        }
    }
})
