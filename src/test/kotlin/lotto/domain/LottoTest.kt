package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.StringSpec

class LottoTest : StringSpec({
    "로또를 발급한다." {
        shouldNotThrowAny {
            Lotto()
        }
    }
})
