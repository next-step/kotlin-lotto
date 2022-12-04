package nextstep.mission.lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoShopTest : StringSpec({

    "로또 가게에서 입력한 금액만큼의 로또를 구매할 수 있다." {
        listOf(
            10_000 to 10,
            14_900 to 14,
            900 to 0,
        ).forEach { (purchasePrice: Int, expected: Int) ->
            val result: Lotto = LottoShop.purchaseAutoLotto(purchasePrice)

            result.lottoNumbers.size shouldBe expected
        }
    }

    "로또 가게에서 수동으로 구매할 번호로 로또를 구매할 수 있다." {
        val manualLottoNumbers: List<List<Int>> = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(11, 12, 13, 14, 15, 16),
            listOf(11, 22, 33, 44, 21, 32)
        )

        val result: Lotto = LottoShop.purchaseManualLotto(manualLottoNumbers)

        result.lottoNumbers.size shouldBe 3
    }
})
