import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class InputUtilsTest {

    @ParameterizedTest
    @CsvSource(value = ["1,2,3,45,6:5", "22;28,2:3", "26;2;33:3"], delimiter = ':')
    fun splitByDefault(input: String, size: Int) {
        // when
        val actual = InputUtils.split(input)

        // then
        assertThat(actual.size).isEqualTo(size)
    }

    @Test
    fun splitByDefaultWhenEmptyString() {
        // given
        val input = ""

        // when
        val actual = InputUtils.split(input)

        // then
        assertThat(actual).isEqualTo(listOf("0"))
    }

    @ParameterizedTest
    @CsvSource(value = ["//;\\n1;2;3:3", "//-\\n12-2-3:3"], delimiter = ':')
    fun splitByCustom(input: String, size: Int) {
        // when
        val actual = InputUtils.split(input)

        // then
        assertThat(actual.size).isEqualTo(size)
    }
}