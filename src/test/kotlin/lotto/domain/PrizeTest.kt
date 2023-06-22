package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PrizeTest : StringSpec({
    "주어진 매치 개수에 대해 정확한 등수를 반환해야 한다" {
        Prize.prizeFor(3, false) shouldBe Prize.FIFTH
        Prize.prizeFor(4, false) shouldBe Prize.FOURTH
        Prize.prizeFor(5, false) shouldBe Prize.THIRD
        Prize.prizeFor(5, true) shouldBe Prize.SECOND
        Prize.prizeFor(6, false) shouldBe Prize.FIRST
        Prize.prizeFor(2, false) shouldBe Prize.NO_PRIZE
    }
})
