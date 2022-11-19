package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PrizeTest : StringSpec() {
    init {
        "로또 일치 개수의 상금을 알 수 있다" {
            Prize.prizeOfMatchCount(6) shouldBe Prize.FIRST.prize
            Prize.prizeOfMatchCount(5) shouldBe Prize.SECOND.prize
            Prize.prizeOfMatchCount(4) shouldBe Prize.THIRD.prize
            Prize.prizeOfMatchCount(3) shouldBe Prize.FOURTH.prize
        }

    }
}
