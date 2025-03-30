package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class WinningLottoTest {
    @Test
    fun `WinningLotto should have a lotto and a lotto number as a bonus number`() {
        // given
        val bonusNumber = LottoNumber(7)
        val lottoNumbers = (1..6).map { LottoNumber(it) }

        // when && then
        assertDoesNotThrow { WinningLotto(Lotto(lottoNumbers), bonusNumber) }
    }

    @Test
    fun `Return true a different lotto has bonus number`() {
        // given
        val bonusNumber = LottoNumber(7)
        val lottoNumbers = (1..6).map { LottoNumber(it) }
        val winningLotto = WinningLotto(Lotto(lottoNumbers), bonusNumber)

        val lotto = Lotto((7..12).map { LottoNumber(it) })
        val expected = true

        // when
        val actual = winningLotto.containBonusNumber(lotto)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `Return false a different lotto doesn't have bonus number`() {
        // given
        val bonusNumber = LottoNumber(7)
        val lottoNumbers = (1..6).map { LottoNumber(it) }
        val winningLotto = WinningLotto(Lotto(lottoNumbers), bonusNumber)

        val lotto = Lotto((8..13).map { LottoNumber(it) })
        val expected = false

        // when
        val actual = winningLotto.containBonusNumber(lotto)

        // then
        assertThat(actual).isEqualTo(expected)
    }
}
