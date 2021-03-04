import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

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

    @Test
    fun convertToNumber() {
        // given
        val splitInput = listOf("1", "2", "22", "4")

        // when
        val actual: List<Int> = InputUtils.convertToNumber(splitInput)

        // then
        assertThat(actual).contains(1, 2, 22, 4)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, -222, -52])
    fun convertToNumberWhenNegativeNumber(negativeInput: Int) {
        // given
        val splitInput = listOf(negativeInput.toString(), "2", "11", "554")

        // when, then
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { InputUtils.convertToNumber(splitInput) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["*", "d", "ㄹ", "/", "("])
    fun convertToNumberWhenNotInteger(invalidInput: String) {
        // given
        val splitInput = listOf(invalidInput, "2", "13", "555", "77")

        // when, then
        assertThatExceptionOfType(java.lang.RuntimeException::class.java)
            .isThrownBy { InputUtils.convertToNumber(splitInput) }
    }
}
