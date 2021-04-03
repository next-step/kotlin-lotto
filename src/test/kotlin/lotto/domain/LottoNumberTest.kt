package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest(name = "로또번호는 {0} 이/가 될 수 있다")
    @ValueSource(ints = [1, 11, 45])
    fun `1~45 로또번호를 생성할 수 있다`(value: Int) {
        val result = LottoNumber(value)
        assertThat(result).isNotNull
    }

    @ParameterizedTest(name = "로또번호는 {0} 이/가 될 수 없다")
    @ValueSource(ints = [-1, 0, 46, 100])
    fun `1~45 이외의 로또번호 생성 시 예외를 반환한다`(value: Int) {
        val expectedMessage = "로또번호를 생성할 수 없는 값이다. value: $value"
        val result: IllegalArgumentException = assertThrows { LottoNumber(value) }
        assertThat(result.message).isEqualTo(expectedMessage)
    }

    @Test
    fun `로또번호의 값이 같으면 동등하다`() {
        val expected = LottoNumber(1)
        val result = LottoNumber(1)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `로또번호의 값이 다르면 동등하지 않다`() {
        val one = LottoNumber(1)
        val two = LottoNumber(2)
        assertThat(one).isNotEqualTo(two)
    }
}
