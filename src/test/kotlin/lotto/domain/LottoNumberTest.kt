package lotto.domain

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoNumberTest {
    @CsvSource(value = ["-1", "asdf", "100"])
    @ParameterizedTest
    fun `로또번호는 1~45 까지의 숫자이다`(number: String) {
        assertThrows<IllegalArgumentException> { LottoNumber(number.toInt()) }
    }
}
