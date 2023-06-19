package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.test.FixedPurchaseCommand
import lotto.test.lottoNumbersOf
import lotto.vo.Money

class LottoShopTest : FreeSpec({
    "로또 상점은 주문과 금액을 받아 로또를 최대한 많이 판매한다." - {
        forAll(
            row(
                3999,
                FixedPurchaseCommand(
                    listOf(
                        Lotto.from(lottoNumbersOf(1, 2, 3, 4, 5, 6)),
                        Lotto.from(lottoNumbersOf(3, 42, 44, 4, 5, 6)),
                        Lotto.from(lottoNumbersOf(7, 8, 9, 10, 11, 12)),
                    )
                ),
            ),
        ) { totalCash, lottoOrder ->

            val result = LottoShop.sell(Money(totalCash), lottoOrder)

            result shouldBe Lottos(
                listOf(
                    Lotto.from(lottoNumbersOf(1, 2, 3, 4, 5, 6)),
                    Lotto.from(lottoNumbersOf(3, 42, 44, 4, 5, 6)),
                    Lotto.from(lottoNumbersOf(7, 8, 9, 10, 11, 12)),
                )
            )
        }
    }
})

