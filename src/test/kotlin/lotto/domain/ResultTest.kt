package lotto.domain

import lotto.domain.Result.Companion.getResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResultTest {

    @Test
    fun `get result`() {
        assertThat(getResult(success = 3)).isEqualTo(Result.FOURTH)
        assertThat(getResult(success = 4)).isEqualTo(Result.THIRD)
        assertThat(getResult(success = 5)).isEqualTo(Result.SECOND)
        assertThat(getResult(success = 6)).isEqualTo(Result.FIRST)
        assertThat(getResult(success = 0)).isEqualTo(Result.ELSE)
    }

    @Test
    fun `matches index`() {
        assertThat(getResult(success = 3).MatchResultsIndex).isEqualTo(0)
        assertThat(getResult(success = 4).MatchResultsIndex).isEqualTo(1)
        assertThat(getResult(success = 5).MatchResultsIndex).isEqualTo(2)
        assertThat(getResult(success = 6).MatchResultsIndex).isEqualTo(3)
        assertThat(getResult(success = 0).MatchResultsIndex).isEqualTo(4)
    }
}
