package lotto.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class DelimiterTest {
    @ParameterizedTest
    @ValueSource(strings = ["1, 2, 3, 4, 5, 6", "1,2,3,4,5,6"])
    fun `콤마로 구분한 숫자 6개 문자열을 인자로 주면, 콤마를 기준으로 구분된 6개의 문자열 리스트가 반환된다`(sixNumberString: String) {
        // when
        val stringNumbers: List<String> = Delimiter(sixNumberString).split()

        // then
        Assertions.assertThat(stringNumbers).isEqualTo(listOf("1", "2", "3", "4", "5", "6"))
    }
}
