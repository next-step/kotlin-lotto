package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.vo.Money

internal class LotterySellerTest : StringSpec({

    "셀러는 주어진 금액만큼 로또를 반환한다." {
        val wallet = Wallet(Money(3000))
        val seller = LotterySeller(
            LotteryStore(StubNumberGenerator(listOf(1, 2, 3, 4, 5, 6))),
        )

        val lotteries = seller.sell(wallet, 3)

        lotteries.size shouldBe 3
    }
})
