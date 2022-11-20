package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({
    "로또는 중복되지 않는 6개의 숫자를 가지고 있다" {
        val lotto = Lotto()

        lotto.numbers shouldHaveSize 6
        lotto.numbers shouldBe lotto.numbers.distinct()
    }
})
