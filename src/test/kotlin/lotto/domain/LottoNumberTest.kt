package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec

class LottoNumberTest : FunSpec({

    test("1과 45 사이의 수가 아닌 경우 IllegalArgumentException 이 발생한다.") {
        shouldThrow<IllegalArgumentException> {
            LottoNumber(46)
        }
    }
})
