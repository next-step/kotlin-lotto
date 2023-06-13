package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.mockLottery

class PurchasedLotteriesTest : StringSpec({

    "구매한 복권 리스트를 생성할 수 있다." {
        val expect = listOf(
            mockLottery(1, 2, 3, 4, 5, 6),
            mockLottery(2, 3, 4, 5, 6, 7),
            mockLottery(21, 33, 24, 15, 6, 27),
        )

        val purchasedLotteries = PurchasedLotteries(lotteries = expect)

        purchasedLotteries shouldBe expect
    }
})
