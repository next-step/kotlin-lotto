package specific.lotto.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class WinningNumbersTest {
    @ParameterizedTest
    @CsvSource("1|2|3|4|5|5,7")
    fun `당첨 번호들은 중복을 허용하지 않는다`(mainNumbersInput: String, bonusNumberInput: String) {
        // given
        val mainNumbers = mainNumbersInput.split("|").map { it.toInt() }
        val bonusNumber = bonusNumberInput.toInt()

        // when, then
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> { WinningNumbers(mainNumbers, bonusNumber) }
    }

    @ParameterizedTest
    @CsvSource("1|2|3|4|5,7", "1|2|3|4|5|6|8,7")
    fun `당첨 번호들은 총 6개다`(mainNumbersInput: String, bonusNumberInput: String) {
        // given
        val mainNumbers = mainNumbersInput.split("|").map { it.toInt() }
        val bonusNumber = bonusNumberInput.toInt()

        // when, then
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> { WinningNumbers(mainNumbers, bonusNumber) }
    }

    @ParameterizedTest
    @CsvSource("1|2|3|4|5|6,6")
    fun `보너스 번호는 당첨 번호들과 중복되면 안된다`(mainNumbersInput: String, bonusNumberInput: String) {
        // given
        val mainNumbers = mainNumbersInput.split("|").map { it.toInt() }
        val bonusNumber = bonusNumberInput.toInt()

        // when, then
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> { WinningNumbers(mainNumbers, bonusNumber) }
    }
}
