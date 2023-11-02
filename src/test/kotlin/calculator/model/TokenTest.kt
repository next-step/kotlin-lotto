package calculator.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class TokenTest : StringSpec({

    "음수를 전달할 경우 IllegalArgumentException throw" {
        shouldThrow<IllegalArgumentException> {
            Token(-1)
        }
    }
})
