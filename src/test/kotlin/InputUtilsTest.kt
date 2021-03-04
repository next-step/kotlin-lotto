import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class InputUtilsTest {

    @ParameterizedTest
    @CsvSource(value = ["1,2,3,45,6:5", "22;28,2:3", "26;2;33:3"], delimiter = ':')
    fun splitByDefault(input: String, size: Int) {
        // when
        val actual = InputUtils.splitByDefault(input)

        // then
        assertThat(actual.size).isEqualTo(size)
    }
}