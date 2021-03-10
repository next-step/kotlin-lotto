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

    @Test
    fun `나의 Lottos를 주면, Coincidence 상태와 match되는 Lotto 갯수 반환`() {
        val myLotto1 = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val myLotto2 = Lotto(listOf(1, 2, 3, 14, 15, 17))
        val myLottos = Lottos(listOf(myLotto1, myLotto2))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(7))

        // when
        val firstCount = Coincidence.FIRST.getMatchedCount(myLottos, winningLotto)
        val secondCount = Coincidence.SECOND.getMatchedCount(myLottos, winningLotto)
        val thirdCount = Coincidence.THIRD.getMatchedCount(myLottos, winningLotto)
        val fourthCount = Coincidence.FOURTH.getMatchedCount(myLottos, winningLotto)
        val fifthCount = Coincidence.FIFTH.getMatchedCount(myLottos, winningLotto)

        // then
        assertThat(firstCount).isEqualTo(0)
        assertThat(secondCount).isEqualTo(1)
        assertThat(thirdCount).isEqualTo(0)
        assertThat(fourthCount).isEqualTo(0)
        assertThat(fifthCount).isEqualTo(1)
    }
}
