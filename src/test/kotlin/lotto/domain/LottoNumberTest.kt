package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class LottoNumberTest {

    @Test
    fun `same object`() {
        val number1 = LottoNumber.of(1)
        val number2 = LottoNumber.of(1)
        assertThat(number1).isEqualTo(number2)
    }

    @Test
    fun `invalid input type`() {
        Assertions.assertThatThrownBy {
            // when
            LottoNumber.of(null)

            // then
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Non-numeric value")
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46, -1])
    fun `out of bounds`(value: Int) {
        Assertions.assertThatThrownBy {
            // when
            LottoNumber.of(value)

            // then
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("LottoNumber($value) should be between 1 and 45")
    }
}
