package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class AmountTest {
    @Test
    fun `음수는 예외발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            Amount(-1)
        }
    }

    @Test
    fun `multiply 계산 가능`() {
        val first = Amount(1)

        val actual = first.times(2)

        assertThat(actual).isEqualTo(Amount(2))
    }

    @Test
    fun `divide 계산가능`() {
        val first = Amount(4)
        val second = Amount(2)

        val actual = first.div(second)

        assertThat(actual).isEqualTo(2)
    }
}
