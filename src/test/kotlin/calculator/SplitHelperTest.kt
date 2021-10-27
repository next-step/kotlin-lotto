package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SplitHelperTest {

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1,+,3",
            "4,&,("
        ]
    )
    fun `주어진 문자열을 구분자로 분리할 수 있다`(input: String) {
        val helper = SplitHelper()

        val expected = input.split(",")
        val actual = helper.split(input)
        assertEquals(expected, actual)
    }

    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @ValueSource(
        strings = [
            "1:+:3",
            "4,&:("
        ]
    )
    fun `구분자를 컴마 이외에 콜론을 사용할 수 있다`(input: String) {
        val helper = SplitHelper()

        val expected = input.split(",", ":")
        val actual = helper.split(input)
        assertEquals(expected, actual)
    }
}
