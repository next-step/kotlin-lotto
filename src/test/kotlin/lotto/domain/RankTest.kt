package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RankTest : StringSpec({
    "FirstPlace test" {
        Rank.of(6, false) shouldBe Rank.FirstPlace
        Rank.of(6, true) shouldBe Rank.FirstPlace
    }

    "SecondPlace test" {
        Rank.of(5, true) shouldBe Rank.SecondPlace
    }

    "ThirdPlace test" {
        Rank.of(5, false) shouldBe Rank.ThirdPlace
    }

    "FourthPlace test" {
        Rank.of(4, false) shouldBe Rank.FourthPlace
    }

    "FifthPlace test" {
        Rank.of(3, false) shouldBe Rank.FifthPlace
    }

    "LastPlace test 1" {
        Rank.of(2, false) shouldBe Rank.LastPlace
    }

    "LastPlace test 2" {
        Rank.of(1, false) shouldBe Rank.LastPlace
    }

    "LastPlace test 3" {
        Rank.of(1, true) shouldBe Rank.LastPlace
    }
})
