package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData

class LottoTest : FunSpec({
    context("lotto must contain 6 numbers") {
        test("with lotto numbers") {
            shouldNotThrowAny {
                Lotto(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    ),
                )
            }
        }

        test("with raw numbers") {
            shouldNotThrowAny {
                Lotto.fromRawNumbers(listOf(1, 2, 3, 4, 5, 6))
            }
        }

        context("throw exception if list is below or above 6") {
            withData(
                listOf(1),
                listOf(1, 2, 3, 4, 5),
                listOf(1, 2, 3, 4, 5, 6, 7),
                listOf(1, 2, 3, 4, 5, 6, 7, 8),
            ) {
                shouldThrow<IllegalArgumentException> {
                    Lotto.fromRawNumbers(it)
                }
            }
        }
    }
})
