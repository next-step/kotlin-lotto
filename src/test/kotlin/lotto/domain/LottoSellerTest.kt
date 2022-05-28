package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoSellerTest : FunSpec({

    val lottoSeller = LottoSeller()

    test("금액에 맞춰 로또가 여러개 발급된다. (로또 1장의 가격은 1000원)") {
        lottoSeller.purchase(0, listOf()).size shouldBe 0
        lottoSeller.purchase(500, listOf()).size shouldBe 0
        lottoSeller.purchase(1_000, listOf()).size shouldBe 1
        lottoSeller.purchase(10_000, listOf()).size shouldBe 10
    }

    test("수동 로또 구매 후 나머지 금액은 자동으로 발급된다.") {
        val lottoNumbers = LottoNumbers.of(1, 2, 3, 4, 5, 6)
        lottoSeller.purchase(0, listOf(lottoNumbers)).size shouldBe 0
        lottoSeller.purchase(500, listOf(lottoNumbers)).size shouldBe 0
        lottoSeller.purchase(1_000, listOf(lottoNumbers)).size shouldBe 1
        lottoSeller.purchase(10_000, listOf(lottoNumbers))
            .apply {
                this.size shouldBe 10
                this.filter { !it.isAutoPick }.size shouldBe 1
                this.filter { it.isAutoPick }.size shouldBe 9
            }
    }
})
