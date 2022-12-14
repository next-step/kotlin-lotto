package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

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
            }
        }
    }

    @Test
    fun getResult() {

        val result = sut.getResult(
            Lotteries(
                Lottery(1, 2, 13, 14, 15, 16),
                Lottery(11, 12, 13, 4, 5, 6),
                Lottery(1, 2, 3, 14, 15, 16)
            ),
            Lottery(1, 2, 3, 4, 5, 6)
        )
        assertAll(
            { result.matchCount(2) shouldBe 1 },
            { result.matchCount(3) shouldBe 2 }
        )
    }
}
