package lotto.view.inputconverter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class MoneyConverterTest {
    @ParameterizedTest
    @CsvSource(value = ["1:1", "2:2", "10:10", "512:512", "17547:17547"], delimiter = ':')
    fun `MoneyConverter는 string input을 Money로 변환한다`(input: String, expected: Int) {
        assertThat(MoneyConverter.convert(input).value).isEqualTo(expected)
    }

    @Test
    fun `MoneyConverter에 Int로 변환시킬 수 없는 입력값이 들어오면 NumberFormatException이 발생한다`() {
        assertThrows<NumberFormatException> {
            MoneyConverter.convert("ㅋㅋㅋ")
        }
    }
}
