package calculator

import calculator.vo.Delimiters
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class DelimiterBasedTokenizerTest : FreeSpec({

    "구분자를 기반으로 토큰으로 분리할 수 있어야 한다." - {
        forAll(
            row(
                Delimiters.of('a'),
                "1a2a3a4",
                listOf("1", "2", "3", "4")
            ),
            row(
                Delimiters.of('a', 'b'),
                "1a2b3a4",
                listOf("1", "2", "3", "4")
            ),
            row(
                Delimiters.of(';', ',', 'c'),
                "1;2,3c4",
                listOf("1", "2", "3", "4")
            ),

            ) { delimiters, target, expected ->

            val result = DelimiterBasedTokenizer.tokenize(target, delimiters)

            result shouldBe expected
        }
    }
})
