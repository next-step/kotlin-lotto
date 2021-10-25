package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {

    @ParameterizedTest
    @EmptySource
    fun `빈 문자열 값을 입력할 경우 0을 반환해야 한다`(text: String) {
        // given
        val stringAddCalculator = StringAddCalculator(text)

        // when
        val sum = stringAddCalculator.add()

        // then
        assertThat(sum).isZero
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(text: String) {
        // given
        val stringAddCalculator = StringAddCalculator(text)

        // when
        val sum = stringAddCalculator.add()

        // then
        assertThat(sum).isSameAs(text.toInt())
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2"])
    fun `숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다`(text: String) {
        // given
        val stringAddCalculator = StringAddCalculator(text)

        // when
        val sum = stringAddCalculator.add()

        // then
        assertThat(sum).isSameAs(3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun `구분자를 쉼표(,) 이외에 콜론을 사용할 수 있다`(text: String) {
        // given
        val stringAddCalculator = StringAddCalculator(text)

        // when
        val sum = stringAddCalculator.add()

        // then
        assertThat(sum).isSameAs(6)
    }
}
