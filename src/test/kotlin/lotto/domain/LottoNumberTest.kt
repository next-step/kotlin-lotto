package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec

/**
 * @see LottoNumber
 */
class LottoNumberTest : FunSpec({

    val lottoNumber = LottoNumber(1)

    context("LottoNumber") {

        test("로또 숫자는 1부터 45까지이다.") {
            val allowedLottoNumberList = 1..45
            allowedLottoNumberList.forEach { eachNumber ->
                shouldNotThrowAny {
                    LottoNumber(eachNumber)
                }
            }
        }

        test("1부터 45사이가 아닌 숫자는 로또 번호가 될 수 없다.") {
            val notAllowedLottoNumberList = listOf(-1, 0, 46)

            notAllowedLottoNumberList.forEach { eachNumber ->
                shouldThrowExactly<IllegalArgumentException> {
                    LottoNumber(eachNumber)
                }
            }
        }
    }
})
