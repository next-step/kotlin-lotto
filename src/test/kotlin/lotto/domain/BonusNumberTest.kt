package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class BonusNumberTest : StringSpec({

    "보너스 번호가 매칭되는지 확인" {
        val number = Numbers(listOf(1, 2, 3, 4, 5, 7))
        val bonusNumber = BonusNumber(6)
        bonusNumber.getMatchingBonus(number) shouldBe false
    }
})
