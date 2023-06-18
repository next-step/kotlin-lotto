package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PrizeTest : StringSpec({
    "주어진 매치 개수에 대해 정확한 등수를 반환해야 한다" {
        Prize.prizeForMatchCount(3) shouldBe Prize.THIRD
        Prize.prizeForMatchCount(4) shouldBe Prize.FOURTH
        Prize.prizeForMatchCount(5) shouldBe Prize.FIFTH
        Prize.prizeForMatchCount(6) shouldBe Prize.SIXTH
        Prize.prizeForMatchCount(2) shouldBe null
    }

    " 주어진 매치들을 기반으로 총 상금 금액을 계산해야 한다" {
        val matches = mapOf(3 to 2, 4 to 1, 5 to 0, 6 to 1)
        val expectedTotalPrice = (Prize.THIRD.amount * 2) + (Prize.FOURTH.amount * 1) + (Prize.SIXTH.amount * 1)
        Prize.calculateTotalPrice(matches) shouldBe expectedTotalPrice
    }
})
