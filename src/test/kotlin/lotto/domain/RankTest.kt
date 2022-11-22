package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RankTest : StringSpec({
    "로또 일치 개수의 상금을 알 수 있다" {
        Rank.prizeOfMatchCount(6) shouldBe Rank.FIRST.prize
        Rank.prizeOfMatchCount(5) shouldBe Rank.SECOND.prize
        Rank.prizeOfMatchCount(4) shouldBe Rank.THIRD.prize
        Rank.prizeOfMatchCount(3) shouldBe Rank.FOURTH.prize
    }
})
