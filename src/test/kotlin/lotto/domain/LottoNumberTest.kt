package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import org.junit.jupiter.api.Assertions.assertDoesNotThrow

class LottoNumberTest : FunSpec({
    test("number must be between 1 to 45 (inclusive)") {
        listOf(1, 2, 3, 4, 5, 40, 41, 42, 43, 44, 45).forAll {
            assertDoesNotThrow {
                LottoNumber(it)
            }
        }
    }

    test("throw exception if number is less than 1 or greater than 45") {
        listOf(-1, 0, 46, 47).forAll {
            shouldThrow<IllegalArgumentException> {
                LottoNumber(it)
            }
        }
    }
})
