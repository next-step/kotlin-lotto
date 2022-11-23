package lotto.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoMatcherTest {

    @DisplayName("당첨 된 숫자 개수를 확인한다")
    @Test
    fun matchingCount() {
        val numbers: List<Int> = listOf(8, 21, 23, 41, 42, 43)
        val list: List<Int> = listOf(9, 21, 27, 41, 42, 45)

        assertThat(LottoMatcher.match(numbers = numbers, list = list)).isEqualTo(3)
    }
}
