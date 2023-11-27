package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class MoneyTest {
    @Test
    fun `구매금액이 로또 가격으로 나누어 떨어지지 않으면 로또를 구매할 수 없다`() {
        val price = 800
        Assertions.assertThatThrownBy {
            Money(price)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("구매금액을 정확히 입력해주세요. 로또 한장 가격은 1000 원입니다.")
    }

    @CsvSource("3000, 3", "14000, 14")
    @ParameterizedTest
    fun `구매할 금액을 입력하면 구매한 로또 개수를 출력해줄 수 있다`(price: Int, count: Int) {
        Assertions.assertThat(Money(price).getCounts()).isEqualTo(count)
    }

    @CsvSource("3000, 1, 2", "14000, 10, 4", "1000, 0, 1")
    @ParameterizedTest
    fun `수동으로 로또를 구매하면 나머지는 자동으로 구매할 수 있다`(price: Int, manualCount: Int, autoCount: Int) {
        Assertions.assertThat(Money(price, manualCount).getCounts()).isEqualTo(autoCount)
    }
}
