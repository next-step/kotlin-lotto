package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto

class LottoTest: StringSpec({

    "1~45 사이의 6자리 숫자를 만들어야 한다" {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        lotto.numbers.size shouldBe 6
    }

})