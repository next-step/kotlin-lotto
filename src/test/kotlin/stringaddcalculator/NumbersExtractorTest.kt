package stringaddcalculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class NumbersExtractorTest {
    @Test
    fun `커스텀 구분자가 없으면 콤마 또는 콜론으로 숫자를 추출한다`() {
        val text = "1,2:3,4:5"

        val numbers = NumbersExtractor.extract(text)

        assertThat(numbers).containsExactly(1, 2, 3, 4, 5)
    }

    @Test
    fun `커스텀 구분자가 있으면 커스텀 구분자를 기준으로 숫자를 추출한다`() {
        val text = "//;\n1;2;3;4;5"

        val numbers = NumbersExtractor.extract(text)

        assertThat(numbers).containsExactly(1, 2, 3, 4, 5)
    }
}