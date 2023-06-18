package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.vo.Money

class LottoShopTest : FreeSpec({
    "로또 상점은 받은 금액으로 로또를 최대한 많이 발급한다 - 로또 가격 1000원" - {
        forAll(
            row(13400, 13),
            row(4000, 4),
            row(26400, 26)
        ) { totalCash, expectedLottoCount ->

            val result = LottoShop.sellLottos(
                Money(totalCash)
            )

            result.size shouldBe expectedLottoCount
        }
    }
})
