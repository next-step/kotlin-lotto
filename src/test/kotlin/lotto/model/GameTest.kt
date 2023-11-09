package lotto.model

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import lotto.LottoFixture

class GameTest : StringSpec({
    "6개의 숫자만을 가져야한다" {
        shouldNotThrow<IllegalArgumentException> {
            LottoFixture.gameOf(11, 22, 33, 4, 5, 6)
        }
    }

    "6개보다 부족하거나, 초과하면 IllegalArgumentException throw" {
        shouldThrow<IllegalArgumentException> {
            LottoFixture.gameOf(11, 22, 33, 4, 5)
        }
        shouldThrow<IllegalArgumentException> {
            LottoFixture.gameOf(11, 22, 33, 4, 5, 6, 7)
        }
    }
})
