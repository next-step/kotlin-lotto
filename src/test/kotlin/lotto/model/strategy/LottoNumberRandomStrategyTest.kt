package lotto.model.strategy

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.StringSpec

class LottoNumberRandomStrategyTest : StringSpec({
    "LottoNumber 의 value 가 1~46 사이에 있다" {
        shouldNotThrow<IllegalArgumentException> {
            (1..100).forEach { _ ->
                LottoNumberRandomStrategy.pick()
            }
        }
    }
})
