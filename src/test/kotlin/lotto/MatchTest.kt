package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MatchTest {
    val winningNumber = listOf(1, 2, 3, 14, 15, 16)
    val userNumber = listOf(1, 2, 3, 4, 5, 6)

    @Test
    @DisplayName("count lottonumber match")
    fun count() {
        Assertions.assertThat(Match().match(userNumber, winningNumber)).isEqualTo(3)
    }
}
