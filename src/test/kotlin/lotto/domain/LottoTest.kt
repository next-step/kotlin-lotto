package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.FunSpec

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
                    )
                )
            }
        }

        test("with raw numbers") {
            shouldNotThrowAny {
                Lotto.fromRawNumbers(listOf(1, 2, 3, 4, 5, 6))
            }
        }
    }
})
