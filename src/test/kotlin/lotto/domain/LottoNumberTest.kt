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
        val number1 = LottoNumber(1)
        val number2 = LottoNumber(1)
        assertThat(number1).isEqualTo(number2)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `out of bounds`(value: Int) {
        Assertions.assertThatThrownBy {
            // when
            LottoNumber.of(value)

            // then
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Out of bounds : $value should be in 1 to 45")
    }
}
