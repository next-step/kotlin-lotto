package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CoincidenceTest {
    @Test
    fun match() {
        // given
        val myLotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(7))

        // when
        val matchResult: Coincidence = Coincidence.match(myLotto, winningLotto)

        // then
        assertThat(matchResult).isEqualTo(Coincidence.SECOND)
    }
}
