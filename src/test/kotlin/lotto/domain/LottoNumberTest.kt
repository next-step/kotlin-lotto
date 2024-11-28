package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class LottoNumberTest : StringSpec({
    "should throw exception for invalid LottoNumber" {
        shouldThrow<IllegalArgumentException> { LottoNumber.of(46) }
        shouldThrow<IllegalArgumentException> { LottoNumber.of(-5) }
    }
})
