package calculator.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

class DelimiterTest {

    @ParameterizedTest
    @NullAndEmptySource
    fun `null 또는 빈 문자열이 들어오면 콤마와 세미콜론을 구분자로 사용한다`(value: String?) {
        Assertions.assertThat(Delimiter.of(value)).isEqualTo(Delimiter.DEFAULT_DELIMITER)
    }
}
