package lotto.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.LottoFixture

class RoundTest : StringSpec({
    "6개의 로또 번호가 일치 하면 1등 당첨자로 집계 해야 한다" {
        val actual = LottoFixture.Round.winnerAggregate(LottoFixture.matched6)
        actual.countOf1st shouldBe 1
        actual.countOf3rd shouldBe 0
        actual.countOf4th shouldBe 0
        actual.countOf5th shouldBe 0
    }

    "5개의 로또 번호가 일치 하면 3등 당첨자로 집계 해야 한다" {
        val actual = LottoFixture.Round.winnerAggregate(LottoFixture.matched5)
        actual.countOf1st shouldBe 0
        actual.countOf3rd shouldBe 1
        actual.countOf4th shouldBe 0
        actual.countOf5th shouldBe 0
    }

    "4개의 로또 번호가 일치 하면 4등 당첨자로 집계 해야 한다" {
        val actual = LottoFixture.Round.winnerAggregate(LottoFixture.matched4)
        actual.countOf1st shouldBe 0
        actual.countOf3rd shouldBe 0
        actual.countOf4th shouldBe 1
        actual.countOf5th shouldBe 0
    }

    "3개의 로또 번호가 일치 하면 5등 당첨자로 집계 해야 한다" {
        val actual = LottoFixture.Round.winnerAggregate(LottoFixture.matched3)
        actual.countOf1st shouldBe 0
        actual.countOf3rd shouldBe 0
        actual.countOf4th shouldBe 0
        actual.countOf5th shouldBe 1
    }
})
