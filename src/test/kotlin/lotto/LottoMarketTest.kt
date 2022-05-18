package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoMachine

class LottoMarketTest : FunSpec({
    val lottoShop = LottoSeller

    test("금액에 맞춰 로또가 여러개 발급된다. (로또 1장의 가격은 1000원)") {
        lottoShop.purchaseAuto(0).size shouldBe 0
        lottoShop.purchaseAuto(LottoMachine.LOTTO_PRICE / 2).size shouldBe 0
        lottoShop.purchaseAuto(LottoMachine.LOTTO_PRICE).size shouldBe 1
        lottoShop.purchaseAuto(LottoMachine.LOTTO_PRICE * 10).size shouldBe 10
    }
})
