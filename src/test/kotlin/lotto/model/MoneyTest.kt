package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigDecimal

class MoneyTest {

    @Test
    fun `Money를 더한다`() {
        // given
        val money1 = Money.of(9876)
        val money2 = Money.of(4321)

        // when
        val result = money1 + money2

        // then
        assertThat(result).isEqualTo(Money.of(14197))
    }

    @Test
    fun `Money를 뺀다`() {
        // given
        val money1 = Money.of(9876)
        val money2 = Money.of(4321)

        // when
        val result = money1 - money2

        // then
        assertThat(result).isEqualTo(Money.of(5555))
    }

    @Test
    fun `Money를 곱한다`() {
        // given
        val money1 = Money.of(9876)
        val money2 = 4321

        // when
        val result = money1 * money2

        // then
        assertThat(result).isEqualTo(Money.of(42_674_196))
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "2000:2001 : -1",
            "2000:2000 : 0",
            "2000:1999 : 1"
        ],
        delimiter = ':'
    )
    fun `Money를 비교한다`(input1: String, input2: String, expected: Int) {
        // given
        val money1 = Money.of(input1)
        val money2 = Money.of(input2)

        // when
        val actual = money1.compareTo(money2)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `어떤 가격의 제품을 몇개까지 구매할 수 있는지 구한다`() {
        // given
        val money = Money.of(1_234_567)
        val price = Money.of(987)

        // when
        val result = money.getBuyCountOf(price)

        // then
        assertThat(result).isEqualTo(1_250)
    }

    @Test
    fun `구매 가격 대비 수익률을 계산한다`() {
        // given
        val money = Money.of(1_234_567)
        val price = Money.of(3_456_789)

        // when
        val result = money.getReturnRatioOf(price)

        // then
        assertThat(result).isEqualTo(BigDecimal("0.36"))
    }
}
