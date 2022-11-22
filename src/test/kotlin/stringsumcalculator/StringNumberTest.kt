package stringsumcalculator

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

class StringNumberTest : StringSpec({
    "StringNumber는 0, 자연수이다" {
        (0..9).toList()
            .forAll {
                shouldNotThrowAny { StringNumber(it.toString()) }
            }
    }

    "StringNumber가 0, 자연수가 아니면 RuntimeException 예외를 던진다" {
        shouldThrowExactly<RuntimeException> { StringNumber("-1") }
    }
})
