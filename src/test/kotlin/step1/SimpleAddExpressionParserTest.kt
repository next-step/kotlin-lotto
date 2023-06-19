package step1

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class SimpleAddExpressionParserTest : StringSpec({
    "수식에 음수가 포함되어 있을때, RuntimeException을 throw 한다" {
        shouldThrow<RuntimeException> {
            val parser = SimpleAddExpressionParser()
            parser.parse("-1:0:0")
        }
    }
})
