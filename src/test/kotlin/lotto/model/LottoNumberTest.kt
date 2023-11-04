package lotto.model

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class LottoNumberTest : StringSpec({
    "1~46 사이의 수 이어야한다" {
        shouldNotThrow<IllegalArgumentException> {
            TODO()
        }
    }

    "1~46 범위에 벗어나는 경우 IllegalArgumentException throw" {
        shouldThrow<IllegalArgumentException> { }
        TODO()
    }

})
