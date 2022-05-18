import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringAddTest {
    @ValueSource(ints = [-1, 0])
    @ParameterizedTest
    fun `음수 값이 들어오면 런타임 익셉션 던진다`(input: Int) {
        val inputValidator = InputValidator()

        if (input < 0) {
            assertThrows<RuntimeException> {
                inputValidator.checkNatualAndZero(input)
            }
        }
    }
}
