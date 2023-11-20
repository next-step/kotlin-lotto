package lotto.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row

class LottoNumberTest : FunSpec({
    test("로또 번호가 1~45 범위 내 자연수가 아닐 경우 IllegalArgumentException 예외 발생 테스트") {
        forAll(
            row(0),
            row(-1),
            row(46),
        ) { lottoNumber ->
            shouldThrow<IllegalArgumentException> {
                LottoNumber.from(lottoNumber)
            }
        }
    }
})
