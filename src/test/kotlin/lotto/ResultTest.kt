package lotto

import lotto.Result.Companion.findResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResultTest {

    @Test
    fun `find result`() {
        assertThat(findResult(match = 3)).isEqualTo(Result.FOURTH)
        assertThat(findResult(match = 4)).isEqualTo(Result.THIRD)
        assertThat(findResult(match = 5)).isEqualTo(Result.SECOND)
        assertThat(findResult(match = 6)).isEqualTo(Result.FIRST)
        assertThat(findResult(match = 0)).isEqualTo(Result.ELSE)
    }

    @Test
    fun `prize index`() {
        assertThat(findResult(match = 3).prizeIndex).isEqualTo(0)
        assertThat(findResult(match = 4).prizeIndex).isEqualTo(1)
        assertThat(findResult(match = 5).prizeIndex).isEqualTo(2)
        assertThat(findResult(match = 6).prizeIndex).isEqualTo(3)
        assertThat(findResult(match = 0).prizeIndex).isEqualTo(4)
    }
}
