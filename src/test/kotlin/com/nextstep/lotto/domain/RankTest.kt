package com.nextstep.lotto.domain

import com.nextstep.lotto.domain.Rank.FIFTH
import com.nextstep.lotto.domain.Rank.FIRST
import com.nextstep.lotto.domain.Rank.FOURTH
import com.nextstep.lotto.domain.Rank.SECOND
import com.nextstep.lotto.domain.Rank.SEVENTH
import com.nextstep.lotto.domain.Rank.SIXTH
import com.nextstep.lotto.domain.Rank.THIRD
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class RankTest : BehaviorSpec({
    Given("Rank.from()") {
        When("일치한 숫자의 개수를 입력하면") {
            Then("당첨 등수를 찾을 수 있다") {
                forAll(
                    row(0, SEVENTH),
                    row(1, SIXTH),
                    row(2, FIFTH),
                    row(3, FOURTH),
                    row(4, THIRD),
                    row(5, SECOND),
                    row(6, FIRST)
                ) {
                    matchCount, expectedRank ->
                    val actual = Rank.from(matchCount)
                    actual shouldBe expectedRank
                }
            }
        }
    }
})
