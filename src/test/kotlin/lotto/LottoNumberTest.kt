package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 11, 25, 45])
    fun `로또 번호는 1부터 45까지 가능하다`(num: Int) {
        // when, then
        assertDoesNotThrow { LottoNumber(num) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, -22, -45, -100])
    fun `1보다 작거나 45보다 큰 수는 로또 번호가 될 수 없다`(num: Int) {
        // when, then
        assertThrows<IllegalArgumentException> { LottoNumber(num) }
    }

    @ParameterizedTest
    @CsvSource(value = ["1:1", "2:2", "35:35", "45:45"], delimiter = ':')
    fun `로또 번호를 문자열 인자로 주면 LottoNumber 객체가 생성된다`(stringNumber: String, number: Int) {
        // when
        val lottoNumber = LottoNumber(stringNumber)

        // then
        assertThat(lottoNumber).isEqualTo(LottoNumber(number))
    }
}
