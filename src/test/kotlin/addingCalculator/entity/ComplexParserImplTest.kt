package addingCalculator.entity

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class ComplexParserImplTest {

    @Test
    fun `1,2 colon 3 를 넣으면 listOf(1,2,3)를 리턴한다`() {
        // given
        val testNotation = "1,2:3"
        val expected = listOf("1", "2", "3")

        // when
        val result = ComplexParserImpl().parse(testNotation)

        // then
        Assertions.assertThat(result).isEqualTo(expected)
    }
}
