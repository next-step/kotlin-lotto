package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoSellerTest : FunSpec({

    val lottoSeller = LottoSeller()

    test("금액에 맞춰 로또가 여러개 발급된다. (로또 1장의 가격은 1000원)") {
        lottoSeller.purchaseAuto(0).size shouldBe 0
        lottoSeller.purchaseAuto(500).size shouldBe 0
        lottoSeller.purchaseAuto(1_000).size shouldBe 1
        lottoSeller.purchaseAuto(10_000).size shouldBe 10
    }
})
