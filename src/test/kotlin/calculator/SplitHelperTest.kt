package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SplitHelperTest {

    private lateinit var helper: SplitHelper

    @BeforeEach
    fun setup() {
        helper = SplitHelper()
    }

    @Test
    fun `주어진 문자열을 구분자로 분리할 수 있다`() {
        val expected = listOf("1", "+", "3")
        val actual = helper.split("1,+,3")
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    @Test
    fun `구분자를 컴마 이외에 콜론을 사용할 수 있다`() {
        val expected = listOf("4", "&", "(")
        val actual = helper.split("4:&:(")
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = """ "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다. """)
    @ValueSource(
        strings = [
            "//;\n1;2;3",
            "//=\n1=2=3"
        ]
    )
    fun `문자 사이에 커스텀 구분자를 지정할 수 있다`(input: String) {
        val expected = listOf("1", "2", "3")
        val actual = helper.split(input)
        assertThat(actual).isEqualTo(expected)
    }
}
