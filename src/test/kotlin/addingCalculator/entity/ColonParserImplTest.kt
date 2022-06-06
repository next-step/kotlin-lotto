package addingCalculator.entity

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class ColonParserImplTest {

    @Test
    fun `1 colon 2 를 넣으면 listOf(1,2)를 리턴한다`() {
        // given
        val testNotation = "1:2"
        val expected = listOf("1", "2")

        // when
        val result = ColonParserImpl().parse(testNotation)

        // then
        Assertions.assertThat(result).isEqualTo(expected)
    }
}
