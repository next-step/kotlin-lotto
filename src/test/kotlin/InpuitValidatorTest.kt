import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InpuitValidatorTest {
    @ValueSource(strings = ["-1", "a"])
    @ParameterizedTest
    fun `음수 값, 숫자가아닌 인풋이 들어오면 런타임 익셉션 던진다`(input: String) {

        assertThrows<RuntimeException> {
            InputValidator.checkNatualAndZero(input)
        }
    }
}
