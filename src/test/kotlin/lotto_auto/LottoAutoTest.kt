package lotto_auto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto_auto.lotto.LottoAuto

class LottoAutoTest : StringSpec({
    "입력된 개수 만큼 로또 용지가 생성 된다." {
        val input = 4
        val expected = 4

        LottoAuto.createLottoList(input).size shouldBe expected
    }
})
