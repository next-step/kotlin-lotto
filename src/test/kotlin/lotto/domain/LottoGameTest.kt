package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoGameTest {

    @Test
    fun `3등 로또 번호 2개가 들어 있는 경우`() {
        val lotto1 = Lotto(1, 2, 3, 4, 9, 11)
        val lotto2 = Lotto(1, 2, 3, 4, 10, 12)
        val lotto3 = Lotto(45, 44, 43, 42, 41, 40)
        val winningLotto = Lotto(1, 2, 3, 4, 5, 6)
        val lottoGame = LottoGame(listOf(lotto1, lotto2, lotto3))
        assertThat(lottoGame.matchLotto(winningLotto)[LottoRank.THIRD]).isEqualTo(2)
    }

    @Test
    fun `4등 로또 번호 2개가 들어 있는 경우`() {
        val lotto1 = Lotto(1, 7, 3, 4, 9, 11)
        val lotto2 = Lotto(1, 8, 3, 4, 10, 12)
        val lotto3 = Lotto(45, 44, 43, 42, 41, 40)
        val winningLotto = Lotto(1, 2, 3, 4, 5, 6)
        val lottoGame = LottoGame(listOf(lotto1, lotto2, lotto3))
        assertThat(lottoGame.matchLotto(winningLotto)[LottoRank.FOURTH]).isEqualTo(2)
    }

    @Test
    fun `2등 로또 번호 2개가 들어 있는 경우`() {
        val lotto1 = Lotto(1, 2, 3, 4, 5, 11)
        val lotto2 = Lotto(1, 2, 3, 4, 5, 12)
        val lotto3 = Lotto(45, 44, 43, 42, 41, 40)
        val winningLotto = Lotto(1, 2, 3, 4, 5, 6)
        val lottoGame = LottoGame(listOf(lotto1, lotto2, lotto3))
        assertThat(lottoGame.matchLotto(winningLotto)[LottoRank.SECOND]).isEqualTo(2)
    }

    @Test
    fun `1등 로또 번호 2개가 들어 있는 경우`() {
        val lotto1 = Lotto(1, 2, 3, 4, 5, 6)
        val lotto2 = Lotto(1, 2, 3, 4, 5, 6)
        val lotto3 = Lotto(45, 44, 43, 42, 41, 40)
        val winningLotto = Lotto(1, 2, 3, 4, 5, 6)
        val lottoGame = LottoGame(listOf(lotto1, lotto2, lotto3))
        assertThat(lottoGame.matchLotto(winningLotto)[LottoRank.FIRST]).isEqualTo(2)
    }

    private fun Lotto(vararg numbers: Int): Lotto {
        return Lotto(numbers.map { LottoNumber.from(it) })
    }
}
