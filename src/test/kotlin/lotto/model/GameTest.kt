package lotto.model

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class GameTest : StringSpec({
    "6개의 숫자만을 가져야한다" {
        shouldNotThrow<IllegalArgumentException> {

        }
    }

    "6개보다 부족하거나, 초과하면 throw" {
        shouldThrow<IllegalArgumentException> {

        }
    }
})
