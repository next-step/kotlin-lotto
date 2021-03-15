package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class LotteryFactoryTest {
    @ParameterizedTest
    @CsvSource("5000, 5", "2400, 2", "1100, 1")
    fun `금액에 따라 로또 생성 개수를 정해진다`(inputPrice: Int, expectCount: Int) {
        val factory = LotteryFactory(inputPrice)

        val count = factory.calculateLotteryCountByPrice()

        assertThat(count).isEqualTo(expectCount)
    }

    @ParameterizedTest
    @ValueSource(ints = [-2000, 0, 900, 999])
    internal fun `개당 금액이 1000원 이하인 경우 생성을 실패한다`(wrongInputPrice: Int) {
        assertThrows<IllegalArgumentException> {
            LotteryFactory(wrongInputPrice)
        }
    }
}
