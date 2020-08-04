package lotto.domain.value

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class MoneyTest {
    @Test
    fun `음수가 들어올 경우 IllegalArgumentException이 발생해야한다`() {
        assertThatThrownBy { Money(-1) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("음수는 Money로 사용될 수 없습니다.")
    }

    @Test
    fun `toString()은 원을 붙여 출력한다`() {
        val actual = Money(1000).toString()
        assertThat(actual).isEqualTo("1000원")
    }

    @Test
    fun `money 객체끼리 더할 수 있다`() {
        val number1 = 100
        val number2 = 200
        val actual = Money(number1) + Money(number2)
        assertThat(actual).isEqualTo(Money(number1 + number2))
    }

    @Test
    fun `money 객체끼리 뺄 수 있다`() {
        val number1 = 300
        val number2 = 200
        val actual = Money(number1) - Money(number2)
        assertThat(actual).isEqualTo(Money(number1 - number2))
    }

    @Test
    fun `money 객체에 Int를 곱할 수 있으며 그 결과는 Money 타입이다`() {
        val number1 = 300
        val number2 = 2
        val actual = Money(number1) * number2
        assertThat(actual).isEqualTo(Money(number1 * number2))
    }

    @Test
    fun `money 객체에 double을 나눌 수 있으며 그 결과는 Double타입 이다`() {
        val actual = Money(300) / 30.0
        assertThat(actual).isEqualTo(10.0)
    }

    @Test
    fun `money 객체에 int를 나눌 수 있으며 그 결과는 Int타입 이다`() {
        val actual = Money(300) / 30
        assertThat(actual).isEqualTo(10)
    }
}
