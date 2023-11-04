package lotto.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.LottoFixture

class RoundTest : StringSpec({
    "1등 당첨번호를 입력하면 1등 당첨자를 집계할수 있어야한다" {
        val actual = LottoFixture.Round.winnerAggregate(LottoFixture.winner1st)
        actual.countOf1st shouldBe 1
        actual.countOf3rd shouldBe 0
        actual.countOf4th shouldBe 0
        actual.countOf5th shouldBe 0
    }

    "3등 당첨번호를 입력하면 1등 당첨자를 집계할수 있어야한다" {
        val actual = LottoFixture.Round.winnerAggregate(LottoFixture.winner3rd)
        actual.countOf1st shouldBe 0
        actual.countOf3rd shouldBe 1
        actual.countOf4th shouldBe 0
        actual.countOf5th shouldBe 0
    }

    "4등 당첨번호를 입력하면 1등 당첨자를 집계할수 있어야한다" {
        val actual = LottoFixture.Round.winnerAggregate(LottoFixture.winner4rd)
        actual.countOf1st shouldBe 0
        actual.countOf3rd shouldBe 0
        actual.countOf4th shouldBe 1
        actual.countOf5th shouldBe 0
    }

    "5등 당첨번호를 입력하면 1등 당첨자를 집계할수 있어야한다" {
        val actual = LottoFixture.Round.winnerAggregate(LottoFixture.winner5rd)
        actual.countOf1st shouldBe 0
        actual.countOf3rd shouldBe 0
        actual.countOf4th shouldBe 0
        actual.countOf5th shouldBe 1
    }
})
