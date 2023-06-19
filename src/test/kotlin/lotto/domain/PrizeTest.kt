package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PrizeTest : StringSpec({
    "주어진 매치 개수에 대해 정확한 등수를 반환해야 한다" {
        Prize.prizeForMatchCount(3) shouldBe Prize.FIFTH
        Prize.prizeForMatchCount(4) shouldBe Prize.FOURTH
        Prize.prizeForMatchCount(5) shouldBe Prize.THIRD
        Prize.prizeForMatchCount(6) shouldBe Prize.FIRST
        Prize.prizeForMatchCount(2) shouldBe Prize.NO_PRIZE
    }
})
