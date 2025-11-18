package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoTest : FreeSpec({

    "로또 생성 시 1~45 사이 숫자 6개로 구성된다." {
        val lotto = Lotto()
        lotto.numbers.size shouldBe 6
        lotto.numbers.all { it in 1..45 } shouldBe true
    }
})
