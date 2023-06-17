package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoNumberGeneratorTest:StringSpec({

    "6자리의 로또 넘버를 생선한다."{
        LottoNumberGenerator.generate().size shouldBe 6
    }
})
