package calculator

import calculator.vo.PositiveNum
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumberExtractorTest {
    private lateinit var numberExtractor: NumberExtractor

    @BeforeEach
    fun setUp() {
        numberExtractor = NumberExtractor
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2"])
    fun `숫자 두개를 쉼표(,) 구분자로 입력할 경우, 문자열에서 숫자 2개를 추출한다`(text: String) {
        assertEquals(numberExtractor.extract(text).size(), 2)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun `구분자에 쉼표 및 콜론을 사용하여, 문자열에서 숫자 3개를 추출한다`(text: String) {
        assertEquals(numberExtractor.extract(text).size(), 3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun `커스텀 구분자를 입력받아 1,2,3 을 추출한다`(text: String) {
        assertEquals(
            numberExtractor.extract(text).positiveNums,
            listOf(PositiveNum(1), PositiveNum(2), PositiveNum(3))
        )
    }
}
