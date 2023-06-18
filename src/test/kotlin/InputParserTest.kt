import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputParserTest {

    @ValueSource(strings = ["1:2:3", "1,2,3", "1,2:3"])
    @ParameterizedTest
    fun `기본 구분자로 파싱이 가능하다`(input: String) {
        InputParser.parse(input).size shouldBe 3
    }

    @ValueSource(strings = ["//!\n1!3!3", "//@\n3@3@1"])
    @ParameterizedTest
    fun `커스텀 구분자로 파싱이 가능하다`(input: String) {
        InputParser.parse(input).size shouldBe 3
    }
}
