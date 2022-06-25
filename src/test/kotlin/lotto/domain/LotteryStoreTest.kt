package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class LotteryStoreTest : StringSpec({

    "주어진 개수만큼 복권을 반환한다." {
        val store = LotteryMachine(StubNumberGenerator(listOf(1, 2, 3, 4, 5, 6)))
        val number = 5

        val lotteries = store.getLotteries(number)

        lotteries.size shouldBe 5
    }

    "주어진 복권 번호를 통해 복권을 생성한다." {
        val store = LotteryMachine(StubNumberGenerator(listOf(1, 2, 3, 4, 5, 6)))
        val numbers = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(7, 8, 9, 10, 11, 12)
        ).map { it.toLotteryNumberSet() }

        val manualLotteries = store.getManualLotteries(numbers)

        manualLotteries.size shouldBe 2
    }
})
