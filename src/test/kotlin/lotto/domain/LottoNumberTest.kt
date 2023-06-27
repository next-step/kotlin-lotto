package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class LottoNumberTest : StringSpec({

    "1~45의 수가 입력되면 정상적으로 로또 넘버가 생성된다." {
        shouldNotThrowAny {
            LottoNumber(11)
        }
    }

    "1~45 이외의 수가 입력되면 로또 넘버를 생성하지 못한다." {
        shouldThrow<IllegalArgumentException> {
            LottoNumber(50)
        }
    }
})
