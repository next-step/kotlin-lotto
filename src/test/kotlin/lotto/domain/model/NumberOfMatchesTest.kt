package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumberOfMatchesTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 0])
    fun `NumberOfMatches는 로또 번호가 당첨 번호와 몇 개 일치하는지를 표시한다`(input: Int) {
        val numberOfMatches = NumberOfMatches(input)

        assertThat(numberOfMatches.value).isEqualTo(input)
    }
}
