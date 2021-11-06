package lotto

import lotto.domain.Money
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class MoneyTest {

    @ParameterizedTest(name = "로또는 1000money 당 1장 살 수 있다.")
    @CsvSource(value = ["1000, 1", "1500, 1", "2300, 2", "12315, 12", "9232, 9"])
    fun `로또는 1000money 당 1장 살 수 있다`(value: String, expected: Int) {
        assertThat(Money.of(value).lottoCount).isEqualTo(expected)
    }

    @ParameterizedTest(name = "Money는 1000이하일 수 없다.")
    @ValueSource(strings = ["1", "20", "30", "40", "400", "600", "999"])
    fun `Money는 1000이하일 수 없다`(value: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Money.of(value)
        }.withMessage(Money.NOT_ENOUGH_MONEY_MESSAGE)
    }

    @ParameterizedTest(name = "Money는 숫자만 입력할 수 있다.")
    @ValueSource(strings = ["1ㅁ", "20ㅠ", "30b", "ads", "qwe", "!!", "!@#$%"])
    fun `Money는 숫자만 입력할 수 있다`(value: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Money.of(value)
        }.withMessage(Money.NUMBER_FORMAT_EXCEPTION_MESSAGE)
    }
}
