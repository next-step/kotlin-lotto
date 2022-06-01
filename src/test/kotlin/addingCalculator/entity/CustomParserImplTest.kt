package addingCalculator.entity

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test


internal class CustomParserImplTest {

  @Test
  fun `testNotation을 넣으면 listOf(1,2,3)를 리턴한다`() {
    // given
    val testNotation = "//;\n1;2;3"
    val expected = listOf("1","2","3")

    // when
    val result = CustomParserImpl().parse(testNotation)

    //then
    Assertions.assertThat(result).isEqualTo(expected)
  }
}