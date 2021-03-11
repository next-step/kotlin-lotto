package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoPrizeTest {

    @Test
    fun `로또번호가 6개 일치하는 경우 1등이다`() {
        val lotto = Lotto((1..6).map { LottoNumber(it) })
        val winningLotto = WinningLotto((1..6).map { LottoNumber(it) })
        val expected = LottoPrize.FIRST_PRIZE

        val result = LottoPrize.match(lotto, winningLotto)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `로또번호가 5개 일치하는 경우 3등이다`() {
        val lotto = Lotto((1..6).map { LottoNumber(it) })
        val winningLotto = WinningLotto((2..7).map { LottoNumber(it) })
        val expected = LottoPrize.THIRD_PRIZE

        val result = LottoPrize.match(lotto, winningLotto)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `로또번호가 4개 일치하는 경우 4등이다`() {
        val lotto = Lotto((1..6).map { LottoNumber(it) })
        val winningLotto = WinningLotto((3..8).map { LottoNumber(it) })
        val expected = LottoPrize.FOURTH_PRIZE

        val result = LottoPrize.match(lotto, winningLotto)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `로또번호가 3개 일치하는 경우 5등이다`() {
        val lotto = Lotto((1..6).map { LottoNumber(it) })
        val winningLotto = WinningLotto((4..9).map { LottoNumber(it) })
        val expected = LottoPrize.FIFTH_PRIZE

        val result = LottoPrize.match(lotto, winningLotto)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `로또번호가 2개 일치하는 경우 꽝이다`() {
        val lotto = Lotto((1..6).map { LottoNumber(it) })
        val winningLotto = WinningLotto((5..10).map { LottoNumber(it) })
        val expected = LottoPrize.WHACK

        val result = LottoPrize.match(lotto, winningLotto)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `로또번호가 1개 일치하는 경우 꽝이다`() {
        val lotto = Lotto((1..6).map { LottoNumber(it) })
        val winningLotto = WinningLotto((6..11).map { LottoNumber(it) })
        val expected = LottoPrize.WHACK

        val result = LottoPrize.match(lotto, winningLotto)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `로또번호가 0개 일치하는 경우 꽝이다`() {
        val lotto = Lotto((1..6).map { LottoNumber(it) })
        val winningLotto = WinningLotto((7..12).map { LottoNumber(it) })
        val expected = LottoPrize.WHACK

        val result = LottoPrize.match(lotto, winningLotto)

        assertThat(result).isEqualTo(expected)
    }
}
