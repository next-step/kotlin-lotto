package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.dto.LotterySellDTO
import lotto.vo.Money

internal class LotterySellerTest : StringSpec({

    "셀러는 주어진 금액만큼 로또를 반환한다." {
        val wallet = Wallet(Money(4000))
        val seller = LotterySeller(
            LotteryMachine(StubNumberGenerator(listOf(1, 2, 3, 4, 5, 6))),
        )
        val autoLotteryCount = 2
        val manualLotteries = listOf(
            listOf(1, 2, 3, 4, 5, 6).toLotteryNumberSet(),
            listOf(1, 2, 3, 4, 5, 6).toLotteryNumberSet(),
        )
        val lotterySellDTO = LotterySellDTO(manualLotteries, autoLotteryCount)

        val lotteries = seller.sell(wallet, lotterySellDTO)

        lotteries.autoLotteries.size shouldBe 2
        lotteries.manualLotteries.size shouldBe 2
    }
})
