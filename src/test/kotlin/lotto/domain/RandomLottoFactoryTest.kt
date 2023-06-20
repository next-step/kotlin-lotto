package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.FreeSpec

class RandomLottoFactoryTest : FreeSpec({

    "로또를 생성한다." {
        val randomLottoFactory = RandomLottoFactory()
        shouldNotThrowAny {
            repeat(10) { randomLottoFactory.create() }
        }
    }
})
