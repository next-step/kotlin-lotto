package lotto.domain

import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LotteryMachineTest {
    lateinit var sut: LotteryMachine

    @BeforeEach
    fun beforeEach() {
        sut = LotteryMachine()
    }

    @DisplayName("구입 금액에 해당하는 로또를 발급한다")
    @Test
    fun buyLottery() {
        listOf(
            1000 to 1,
            1500 to 1,
            3900 to 3,
            10000 to 10
        ).map { (payAmount, howManyBought) ->
            {
                val result = sut.buyLotteries(payAmount)

                result.count() shouldBe howManyBought
                result.lotteries.shouldForAll {
                    it.numbers.size shouldBe 6
                }
            }
        }
    }
}
