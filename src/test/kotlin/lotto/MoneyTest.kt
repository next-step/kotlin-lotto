package lotto

import lotto.domain.Money
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class MoneyTest {

    @ParameterizedTest(name = "Money를 나눌 수 있다.")
    @CsvSource(value = ["1300, 1000, 1", "2999, 1000, 2", "19000, 1000, 19"])
    fun `Money는 나눌 수 있다`(value1: String, value2: String, expected: Int) {
        val money1 = Money.of(value1)
        val money2 = Money.of(value2)

        assertThat(money1 / money2).isEqualTo(expected)
    }

    @ParameterizedTest(name = "Money는 비교할 수 있다.")
    @CsvSource(value = ["2000, 1000, true", "300, 1000, false", "999, 1000, false"])
    fun `Money는 비교할 수 있다`(value1: String, value2: String, expected: Boolean) {
        val money1 = Money.of(value1)
        val money2 = Money.of(value2)

        assertThat(money1 >= money2).isEqualTo(expected)
    }

    @ParameterizedTest(name = "Money는 숫자만 입력할 수 있다.")
    @ValueSource(strings = ["1ㅁ", "20ㅠ", "30b", "ads", "qwe", "!!", "!@#$%"])
    fun `Money는 숫자만 입력할 수 있다`(value: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Money.of(value)
        }.withMessage(Money.NUMBER_FORMAT_EXCEPTION_MESSAGE)
    }
}
