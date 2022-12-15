package com.nextstep.lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class RankTest : FunSpec({
    context("Rank") {
        test("주어진 matchCount로 Rank를 반환한다. ") {
            listOf(
                listOf(6, Rank.FIRST, false),
                listOf(5, Rank.SECOND, true),
                listOf(5, Rank.THIRD, false),
                listOf(4, Rank.FOURTH, false),
                listOf(3, Rank.FIFTH, false),
                listOf(0, Rank.MISS, false)
            ).forAll { (count, rank, matchBonus) ->
                run {
                    Rank.from(count as Int, matchBonus as Boolean) shouldBe rank
                }
            }
        }
    }
})
