package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class SplitHelperTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "1,+,3|,",
            "4,&,(|,"
        ],
        delimiter = '|'
    )
    fun `주어진 문자열을 구분자로 분리할 수 있다`(input: String, delimiter: String) {
        val helper = SplitHelper(delimiter)

        val expected = input.split(delimiter)
        val actual = helper.split(input)
        assertEquals(expected, actual)
    }
}
