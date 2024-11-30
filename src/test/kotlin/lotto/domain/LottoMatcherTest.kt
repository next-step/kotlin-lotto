package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoMatcherTest : StringSpec({
    "로또 번호가 일치하는 개수를 계산한다" {
        val winningLotto = Lotto.create(listOf(1, 2, 3, 4, 5, 6))
        val lotto = Lotto.create(listOf(1, 2, 3, 4, 5, 7))

        val matchingCount = LottoMatcher.matchLottoNumberCount(winningLotto, lotto)

        matchingCount shouldBe 5
    }

    "로또 번호가 일치하지 않으면 일치 개수는 0이다" {
        val winningLotto = Lotto.create(listOf(1, 2, 3, 4, 5, 6))
        val lotto = Lotto.create(listOf(7, 8, 9, 10, 11, 12))

        val matchingCount = LottoMatcher.matchLottoNumberCount(winningLotto, lotto)

        matchingCount shouldBe 0
    }
})
