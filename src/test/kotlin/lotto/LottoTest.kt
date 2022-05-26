package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoTest : FreeSpec({
    "로또의 숫자는" - {
        "중복되지 않는 6개의 숫자이다" {
            val numbers = listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber).toSet()
            val lotto = Lotto(numbers)
            lotto.numbers.size shouldBe 6
        }
    }
})
