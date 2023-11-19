package lotto.domain.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LastWeekMatchLottoTest : StringSpec({
    "지난주 로또 당첨 번호는 6개 번호가 있다." {
        val numbers = setOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val lastWeekMatchLotto = LastWeekMatchLotto.valueOf(numbers, bonusNumber)
        lastWeekMatchLotto.numbers shouldBe numbers.mapTo(mutableSetOf()) { LottoNumber.get(it) }
    }

    "지난주 로또 당첨 번호는 보너스 번호가 있다." {
        val numbers = setOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val lastWeekMatchLotto = LastWeekMatchLotto.valueOf(numbers, bonusNumber)
        lastWeekMatchLotto.bonusNumber shouldBe LottoNumber.get(bonusNumber)
    }
})
