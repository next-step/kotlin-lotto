package lotto_auto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto_auto.lotto.Lotto

class LottoTest : FunSpec({
    test("자동으로 생성된 번호는 6개이다") {
        val lotto = Lotto()
        val expected = 6

        lotto.number.count() shouldBe expected
    }
})
