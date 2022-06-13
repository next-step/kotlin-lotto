package lotto.view.inputconverter

import lotto.domain.model.LottoNumber
import lotto.domain.model.UserInputResult
import lotto.domain.model.result
import lotto.isA
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberConverterTest {
    @ParameterizedTest
    @CsvSource(value = ["1:1", "2:2", "10:10", "33:33", "45:45"], delimiter = ':')
    fun `StringToIntConverter는 string input을 Int로 변환한다`(input: String, expected: Int) {
        val result = LottoNumberConverter.convert(input)
        assertThat(result.result).isEqualTo(LottoNumber[expected])
    }

    @Test
    fun `Int로 변환시킬 수 없는 입력값이 들어오면 UserInputResult_Failed가 반환된다`() {
        assertThat(LottoNumberConverter.convert("ㅋㅋㅋ")).isA<UserInputResult.Failed>()
    }

    @ParameterizedTest
    @ValueSource(strings = ["100", "57", "46", "0", "111"])
    fun `LottoNumber로 변환시킬 수 없는 입력값이 들어오면 UserInputResult_Failed가 반환된다`(input: String) {
        assertThat(LottoNumberConverter.convert(input)).isA<UserInputResult.Failed>()
    }
}
