package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoMachine.Companion.LOTTO_PRICE

class LottoMachineTest : FunSpec({
    val lottoMachine = LottoMachine()

    test("로또 자동 발급이 가능하다.") {
        val lottoList = lottoMachine.purchaseAuto(LottoMachine.LOTTO_PRICE)
        lottoList.size shouldBe 1
        lottoList[0].numbers.size shouldBe 6
    }

    test("금액에 맞춰 로또가 여러개 발급된다. (로또 1장의 가격은 1000원)") {
        lottoMachine.purchaseAuto(0).size shouldBe 0
        lottoMachine.purchaseAuto(LOTTO_PRICE / 2).size shouldBe 0
        lottoMachine.purchaseAuto(LOTTO_PRICE).size shouldBe 1
        lottoMachine.purchaseAuto(LOTTO_PRICE * 10).size shouldBe 10
    }
})
