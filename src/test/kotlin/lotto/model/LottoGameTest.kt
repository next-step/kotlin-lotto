package lotto.model

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class LottoGameTest : StringSpec({

    "6개의 숫자만을 가져야한다" {
        shouldNotThrow<IllegalArgumentException> {
            LottoGame(11, 22, 33, 4, 5, 6)
        }
    }

    "6개보다 부족하거나, 초과하면 IllegalArgumentException throw" {
        shouldThrow<IllegalArgumentException> {
            LottoGame(11, 22, 33, 4, 5)
        }
        shouldThrow<IllegalArgumentException> {
            LottoGame(11, 22, 33, 4, 5, 6, 7)
        }
    }
})
