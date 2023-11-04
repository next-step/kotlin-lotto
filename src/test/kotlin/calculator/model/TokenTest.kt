package calculator.model

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class TokenTest : StringSpec({

    "음수를 전달할 경우 IllegalArgumentException throw" {
        shouldThrow<IllegalArgumentException> {
            Token(-1)
        }
    }

    "0과 양수는 허용됩니다" {
        shouldNotThrow<IllegalArgumentException> {
            (0..30).forEach {
                Token(it)
            }
        }
    }
})
