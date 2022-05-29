package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class MoneyTest {

    @Test
    fun `Money 객체 생성`() {
        val money = Money(BigDecimal(1000))
        assertThat(money.get).isEqualTo(1000)
    }

    @Test
    fun `Money 의 값이 음수인 경우 예외처리`() {
        assertThatIllegalArgumentException()
            .isThrownBy { Money(BigDecimal(-1)) }
    }

    @Test
    fun `Money 값 나누기`() {
        val money = Money(BigDecimal(1000))
        val divideMoney = money.divide(1000)
        assertThat(divideMoney.get).isEqualTo(1)
    }
}
