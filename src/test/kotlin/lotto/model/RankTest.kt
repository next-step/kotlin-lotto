package lotto.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RankTest : StringSpec({

    "6개의 숫자가 일치하면 1등/First 를 반환해야한다" {
        val actual = Rank.of(6, false)
        actual shouldBe Rank.FIRST
    }

    "5개의 숫자와 보너스가 일치하면 2등/Second 를 반환해야한다" {
        val actual = Rank.of(5, true)
        actual shouldBe Rank.SECOND
    }

    "5개의 숫자와 보너스가 일치하지 않으면 3등/Third 를 반환해야한다" {
        val actual = Rank.of(5, false)
        actual shouldBe Rank.THIRD
    }

    "4개의 숫자가 일치하면 4등/Fourth 를 반환해야한다" {
        val actual1 = Rank.of(4, false)
        val actual2 = Rank.of(4, true)
        actual1 shouldBe Rank.FOURTH
        actual2 shouldBe Rank.FOURTH
    }

    "3개의 숫자가 일치하면 5등/Fifth 를 반환해야한다" {
        val actual1 = Rank.of(3, false)
        val actual2 = Rank.of(3, true)
        actual1 shouldBe Rank.FIFTH
        actual2 shouldBe Rank.FIFTH
    }

    "2~0 개의 숫자가 일치하면 꽝을 반환한다" {
        val actual0 = Rank.of(0, false)
        val actual1 = Rank.of(1, false)
        val actual2 = Rank.of(2, false)
        actual0 shouldBe Rank.BOOM
        actual1 shouldBe Rank.BOOM
        actual2 shouldBe Rank.BOOM
    }

    "잘못된 당첨번호갯수가 입력되면 throw" {
        shouldThrow<IllegalArgumentException> {
            Rank.of(7, false)
        }

        shouldThrow<IllegalArgumentException> {
            Rank.of(-1, false)
        }
    }
})
