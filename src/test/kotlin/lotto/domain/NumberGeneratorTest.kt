package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("번호 생성기")
internal class NumberGeneratorTest {

    @ParameterizedTest(name = "번호 범위: {0} ~ {1}, 생성 개수={2}")
    @CsvSource(
        "1,45,6",
        "1,45,3",
        "-999,-1,10",
        "0,9999,100",
    )
    fun `인자에 따른 랜덤 번호 생성`(start: Int, end: Int, count: Int) {
        // given
        val range = start..end
        val numberGenerator = NumberGenerator(range)

        // when
        val extracted = numberGenerator.randomTake(count)

        // then
        assertThat(extracted).hasSize(count)
        assertThat(extracted).allMatch { range.contains(it) }
    }
}
