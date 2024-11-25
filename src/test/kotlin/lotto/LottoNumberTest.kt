package lotto

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec

class LottoNumberTest : StringSpec({
    "로또 번호를 생성한다." {
        (1..45).forEach { number -> LottoNumber(number) }
    }

    "로또 번호가 1 미만이라면 예외를 던진다." {
        shouldThrowWithMessage<IllegalArgumentException>("로또 번호는 1부터 45 사이여야 합니다.") {
            LottoNumber(0)
        }
    }

    "로또 번호가 45 초과라면 예외를 던진다." {
        shouldThrowWithMessage<IllegalArgumentException>("로또 번호는 1부터 45 사이여야 합니다.") {
            LottoNumber(46)
        }
    }
})
