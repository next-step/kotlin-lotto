package lottery.domain

import fixture.LotteryFixture.TEST_GENERATOR
import fixture.LotteryFixture.TEST_LOTTERY_NUMBERS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LotteryFactoryTest {
    @ParameterizedTest
    @CsvSource("5000, 5", "2400, 2", "1100, 1")
    fun `금액에 따라 로또 생성 개수를 정해진다`(inputPrice: Int, expectCount: Int) {
        val factory = LotteryFactory(inputPrice)

        val buyLotteries = factory.buy(TEST_GENERATOR, Numbers(listOf()))

        assertThat(buyLotteries.lotteries).hasSize(expectCount)
    }

    @ParameterizedTest
    @ValueSource(ints = [-2000, 0, 900, 999])
    fun `개당 금액이 1000원 이하인 경우 생성을 실패한다`(wrongInputPrice: Int) {
        assertThrows<IllegalArgumentException> {
            LotteryFactory(wrongInputPrice)
        }
    }

    @ParameterizedTest
    @CsvSource("2000, 2", "2400, 2", "1100, 1")
    fun `입력한 금액에 따른 개수만큼 로또를 구매한다`(price: Int, expectdLotteryCount: Int) {
        val lotteryFactory = LotteryFactory(price)
        val lotteries = lotteryFactory.buy(TEST_GENERATOR, Numbers(listOf()))

        assertThat(lotteries.lotteries.size).isEqualTo(expectdLotteryCount)
    }

    @Test
    fun `수동 로또 번호를 입력받아 로또들을 생성한다`() {
        val factory = LotteryFactory(30000)

        val buyLotteries = factory.buy(TEST_GENERATOR, Numbers(listOf(TEST_LOTTERY_NUMBERS)))

        assertThat(buyLotteries.lotteries).hasSize(30)
    }
}
