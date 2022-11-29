package com.nextstep.lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class RankTest : FunSpec({
    context("Rank") {
        test("주어진 matchCount로 Rank를 반환한다. ") {
            listOf(
                listOf(6, Rank.FIRST),
                listOf(5, Rank.THIRD),
                listOf(4, Rank.FOURTH),
                listOf(3, Rank.FIFTH),
                listOf(0, Rank.MISS)
            ).forAll { (count, rank) ->
                run {
                    Rank.from(count as Int) shouldBe rank
                }
            }
        }
    }
})
