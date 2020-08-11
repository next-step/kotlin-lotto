package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RankTest {
    @DisplayName("match count가 3보다 작은 숫자이면 NONE을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `when matchCount less than 3 than return NONE`(value: Int) {
        assertThat(Rank.of(value)).isEqualTo(Rank.NONE)
    }

    @DisplayName("match count가 3이상의 숫자이면 count가 일치하는 Rank 반환한다.")
    @Test
    fun `when matchCount greater than 3 than return the matching Rank`() {
        assertAll(
            { assertThat(Rank.of(3)).isEqualTo(Rank.FOURTH) },
            { assertThat(Rank.of(4)).isEqualTo(Rank.THIRD) },
            { assertThat(Rank.of(5)).isEqualTo(Rank.SECOND) },
            { assertThat(Rank.of(6)).isEqualTo(Rank.FIRST) }
        )
    }
}
