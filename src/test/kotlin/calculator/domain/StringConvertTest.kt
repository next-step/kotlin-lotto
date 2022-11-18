package calculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec

class StringConvertTest : FreeSpec({

    "음수가 있으면 에러를 반환한다." {
        val input = "-1"

        shouldThrow<RuntimeException> {
            StringConvert.toInt(input)
        }
    }
})
