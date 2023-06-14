package domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@Suppress("NonAsciiCharacters")
class SeparatorTest {

    @ValueSource(strings = ["1,2,3", "100,2,3", "5,3,1"])
    @ParameterizedTest
    fun `문자열이 입력되면 , 구분자를 통해 숫자들을 반환한다`(input: String) {
        val separator = Separator()
        val result = separator.extractIntegers(input)

        result shouldBe resultMap[input]
    }

    companion object {
        private val resultMap = mapOf(
            "1,2,3" to listOf(1, 2, 3),
            "100,2,3" to listOf(100, 2, 3),
            "5,3,1" to listOf(5, 3, 1),
        )
    }
}
