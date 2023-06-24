package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import lotto.test.lottoNumbersOf
import lotto.vo.Money

class RandomNumberLottoShopTest : FreeSpec({
    """로또 상점은 금액과 로또 번호를 받아 두 가지 유형의 로또 순서대로 발급한다.
    1. 주어진 로또 번호로 생성된 로또(입력 순서대로)
    2. 남은 금액으로 자동 생성된 로또""" - {
        forAll(
            row(
                5999,
                ManualPurchaseCommand(
                    listOf(
                        Lotto.from(lottoNumbersOf(1, 2, 3, 4, 5, 6)),
                        Lotto.from(lottoNumbersOf(3, 42, 44, 4, 5, 6)),
                        Lotto.from(lottoNumbersOf(7, 8, 9, 10, 11, 12)),
                    )
                ),
                5
            ),
            row(
                3999,
                ManualPurchaseCommand(
                    listOf(
                        Lotto.from(lottoNumbersOf(1, 2, 3, 4, 5, 6)),
                        Lotto.from(lottoNumbersOf(3, 42, 44, 4, 5, 6)),
                        Lotto.from(lottoNumbersOf(7, 8, 9, 10, 11, 12)),
                    )
                ),
                3
            ),
        ) { totalCash, lottoPurchaseRequest, expectedSize ->
            val result = RandomNumberLottoShop.sell(Money(totalCash), lottoPurchaseRequest)

            result.manualLottos shouldContainExactly
                    listOf(
                        Lotto.from(lottoNumbersOf(1, 2, 3, 4, 5, 6)),
                        Lotto.from(lottoNumbersOf(3, 42, 44, 4, 5, 6)),
                        Lotto.from(lottoNumbersOf(7, 8, 9, 10, 11, 12)),
                    )
            result.size shouldBe expectedSize
        }
    }
})
