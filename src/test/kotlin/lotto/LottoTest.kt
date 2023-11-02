package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoTest : FunSpec({

    test("로또 1장의 가격은 1000원이다.") {
        val lotto = Lotto()
        lotto.price shouldBe 1000
    }
})
