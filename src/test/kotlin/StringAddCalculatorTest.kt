import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringAddCalculatorTest {

    @Test
    fun `문자열을 입력받았을 때, 쉼표 또는 콜론을 구분자로 나눈다면, 숫자 리스트를 배출한다`() {
        // given : "1,3,5"를 입력받았을 때
        val stringAddCalculator = StringAddCalculator("1,3:6")

        // when :  쉼표 또는 클론을 구분자로 하여 나눈다
        val actual: List<Int> = stringAddCalculator.splitInput()

        // then :
        assertThat(actual).isEqualTo(listOf(1,3,6))
    }
}
