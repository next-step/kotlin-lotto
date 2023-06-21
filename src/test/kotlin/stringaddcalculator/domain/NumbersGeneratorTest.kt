package stringaddcalculator.domain

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource

class NumbersGeneratorTest {

    @ParameterizedTest
    @EmptySource
    fun `빈 문자열을 입력할 경우 IllegalArgumentException 발생`(input: String) {
        assertThatIllegalArgumentException()
            .isThrownBy { NumbersGenerator(input) }
    }
}
