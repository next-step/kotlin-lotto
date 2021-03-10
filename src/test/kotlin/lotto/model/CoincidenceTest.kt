package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CoincidenceTest {
    @Test
    fun `나의 Lotto와 WinningLotto(보너스볼+당첨번호)를 인자로 주면, match 결과를 반환한다 (2등인 경우)`() {
        // given
        val myLotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(7))

        // when
        val matchResult: Coincidence = Coincidence.match(myLotto, winningLotto)

        // then
        assertThat(matchResult).isEqualTo(Coincidence.SECOND)
    }

    @Test
    fun `나의 Lotto와 WinningLotto(보너스볼+당첨번호)를 인자로 주면, match 결과를 반환한다 (꽝인 경우)`() {
        // given
        val myLotto = Lotto(listOf(11, 12, 13, 4, 5, 7))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(7))

        // when
        val matchResult: Coincidence = Coincidence.match(myLotto, winningLotto)

        // then
        assertThat(matchResult).isEqualTo(Coincidence.MISS)
    }
}
