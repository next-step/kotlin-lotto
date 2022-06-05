package lotto.view.inputconverter

import lotto.domain.model.LottoNumber
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberConverterTest {
    @ParameterizedTest
    @CsvSource(value = ["1:1", "2:2", "10:10", "33:33", "45:45"], delimiter = ':')
    fun `StringToIntConverter는 string input을 Int로 변환한다`(input: String, expected: Int) {

        Assertions.assertThat(LottoNumberConverter.convert(input)).isEqualTo(LottoNumber[expected])
    }

    @Test
    fun `Int로 변환시킬 수 없는 입력값이 들어오면 NumberFormatException이 발생한다`() {
        assertThrows<NumberFormatException> {
            LottoNumberConverter.convert("ㅋㅋㅋ")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["100", "57", "46", "0", "111"])
    fun `LottoNumber로 변환시킬 수 없는 입력값이 들어오면 IllegalArgumentException이 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> {
            LottoNumberConverter.convert(input)
        }
    }
}
