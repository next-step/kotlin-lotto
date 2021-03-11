package calculator.adder

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PositiveAdderTest {
    @Test
    fun `주어진 값을 모두 더해서 반환한다`() {
        // given
        val values = listOf("1", "2", "3")

        // when
        val sum = PositiveAdder().sum(values)

        // then
        assertThat(sum).isEqualTo(6)
    }
}
