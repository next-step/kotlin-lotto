package nextstep.mission.lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoShopTest : StringSpec({

    "로또 가게는 입력받은 금액만큼의 로또 숫자 리스트를 구매할 수 있다." {
        listOf(
            10_000 to 10,
            14_900 to 14,
            900 to 0,
        ).forEach { (purchasePrice: Int, expected: Int) ->
            val result: Lotto = LottoShop.purchaseBy(purchasePrice)

            result.lottoNumbers.size shouldBe expected
        }
    }
})
