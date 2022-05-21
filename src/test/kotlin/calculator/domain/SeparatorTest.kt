package calculator.domain

import calculator.constants.Messages
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

/**
 * Created by Jaesungchi on 2022.05.21..
 */
class SeparatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["44", "3:"])
    fun `커스텀 구분자에 숫자가 들어가면 IllegalArgumentException을 발생시킨다`(source: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Separator(source)
        }.withMessageMatching(Messages.SEPARATE_HAVE_NUMBER)
    }
}
