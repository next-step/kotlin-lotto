package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class AmountTest {
    @Test
    fun `음수는 예외발생`() {
        assertThrows(IllegalArgumentException::class.java) {
            Amount(-1)
        }
    }

    @Test
    fun `plus 가능`() {
        val first = Amount(1)
        val second = Amount(2)

        val actual = first.plus(second)

        assertThat(actual).isEqualTo(Amount(3))
    }

    @Test
    fun `rate 계산가능`() {
        val first = Amount(1)
        val second = Amount(2)

        val actual = first.rate(second)

        assertThat(actual.compareTo(BigDecimal("0.5"))).isEqualTo(0) // 값 비교 (scale 무시)
    }

    @Test
    fun `multiply 계산 가능`() {
        val first = Amount(1)

        val actual = first.multiply(2)

        assertThat(actual).isEqualTo(Amount(2))
    }

    @Test
    fun `divide 계산가능`() {
        val first = Amount(4)
        val second = Amount(2)

        val actual = first.divide(second)

        assertThat(actual).isEqualTo(2)
    }
}
