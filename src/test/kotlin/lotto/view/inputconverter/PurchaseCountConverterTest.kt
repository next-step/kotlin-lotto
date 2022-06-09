package lotto.view.inputconverter

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PurchaseCountConverterTest {
    @ParameterizedTest
    @CsvSource(value = ["1:1", "2:2", "100:100", "0:0", "20:20"], delimiter = ':')
    fun `PurchaseCountConverter는 string input을 PurchaseCount로 변환한다`(input: String, expected: Int) {
        Assertions.assertThat(PurchaseCountConverter.convert(input).value).isEqualTo(expected)
    }

    @Test
    fun `PurchaseCountConverter에 Int로 변환시킬 수 없는 입력값이 들어오면 NumberFormatException이 발생한다`() {
        assertThrows<NumberFormatException> {
            PurchaseCountConverter.convert("ㅋㅋㅋ")
        }
    }
}
