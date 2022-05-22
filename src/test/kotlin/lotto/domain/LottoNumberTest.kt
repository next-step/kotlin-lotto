package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import lotto.exception.InvalidLottoNumberException

class LottoNumberTest : FunSpec({
    test("로또 숫자는 1부터 45 사이의 숫자입니다.") {
        shouldNotThrow<InvalidLottoNumberException> {
            (1..4).forEach { LottoNumber(it) }
        }
        shouldThrow<InvalidLottoNumberException> {
            LottoNumber(-1)
        }
        shouldThrow<InvalidLottoNumberException> {
            LottoNumber(0)
        }
        shouldThrow<InvalidLottoNumberException> {
            LottoNumber(46)
        }
    }
})
