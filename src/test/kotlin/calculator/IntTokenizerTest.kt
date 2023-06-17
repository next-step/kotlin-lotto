package calculator

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class IntTokenizerTest : FreeSpec({

    "커스텀 구분자로 받은 숫자 문자열을 커스텀 구분자로 분리할 수 있어야 한다." - {
        forAll(
            row("//a\\n1a2a3a4", listOf(1, 2, 3, 4)),
            row("//;\\n1;2;3;4", listOf(1, 2, 3, 4)),
            row("//$\\n1$2$3$4", listOf(1, 2, 3, 4)),
        ) { input, expected ->

            val result = IntTokenizer.tokenize(input)

            result shouldBe expected
        }
    }
})
