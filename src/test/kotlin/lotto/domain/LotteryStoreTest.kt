package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.vo.LotteryNumber

internal class LotteryStoreTest : BehaviorSpec({

    given("구입 금액을 입력으로") {
        val money = 14_000
        val stubNumberGenerator = StubNumberGenerator(listOf(1, 2, 3, 4, 5, 6).map(LotteryNumber::of))
        val lotteryStore = LotteryStore(stubNumberGenerator)

        `when`("구매 시") {
            val result = lotteryStore.sell(money)

            then("개수만큼 복권이 포함된 복권 세트를 반환한다.") {
                result.size shouldBe 14
            }
        }
    }
})
