package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import org.junit.jupiter.api.Assertions.assertDoesNotThrow

class LottoNumberTest : FunSpec({
    test("create lotto number") {
        assertDoesNotThrow {
            LottoNumber(1)
        }
    }

    test("number must be between 1 to 45 (inclusive)") {
        listOf(1, 2, 3, 4, 5, 40, 41, 42, 43, 44, 45).forAll {
            assertDoesNotThrow {
                LottoNumber(it)
            }
        }
    }
})
