package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoSeller.Companion.LOTTO_PRICE

class LottoSellerTest : FunSpec({

    val lottoSeller = LottoSeller()

    test("금액에 맞춰 로또가 여러개 발급된다. (로또 1장의 가격은 1000원)") {
        lottoSeller.purchaseAuto(0).size shouldBe 0
        lottoSeller.purchaseAuto(LOTTO_PRICE / 2).size shouldBe 0
        lottoSeller.purchaseAuto(LOTTO_PRICE).size shouldBe 1
        lottoSeller.purchaseAuto(LOTTO_PRICE * 10).size shouldBe 10
    }
})
