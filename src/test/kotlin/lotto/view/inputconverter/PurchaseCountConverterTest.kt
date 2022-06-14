package lotto.view.inputconverter

import lotto.domain.model.UserInputResult
import lotto.domain.model.result
import lotto.isA
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PurchaseCountConverterTest {
    @ParameterizedTest
    @CsvSource(value = ["1:1", "2:2", "100:100", "0:0", "20:20"], delimiter = ':')
    fun `PurchaseCountConverter는 string input을 PurchaseCount로 변환한다`(input: String, expected: Int) {
        assertThat(PurchaseCountConverter.convert(input).result.value).isEqualTo(expected)
    }

    @Test
    fun `PurchaseCountConverter에 Int로 변환시킬 수 없는 입력값이 들어오면 UserInputResult_Failed가 반환된다`() {
        assertThat(PurchaseCountConverter.convert("ㅋㅋㅋ")).isA<UserInputResult.Failed>()
    }
}
