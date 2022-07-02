package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class WinningLottoTest {
    @Test
    fun `Winning Lotto와 bonus number는 중복되면 안된다`() {
        val winningNumbers = Lotto((1..6).map { LottoNumber.of(it) })
        val bonusNumber = LottoNumber.of(6)

        assertThrows<IllegalArgumentException> { WinningLotto(winningNumbers, bonusNumber) }
    }

    @Test
    fun `Bonus number가 일치 한다`() {
        val winningLotto = WinningLotto(Lotto((1..6).map { LottoNumber.of(it) }), LottoNumber.of(10))
        val lotto = Lotto((10..15).map { LottoNumber.of(it) })

        assertThat(winningLotto.matchedBonus(lotto)).isTrue
    }

    @Test
    fun `Bonus number가 일치 하지 않는다`() {
        val winningLotto = WinningLotto(Lotto((1..6).map { LottoNumber.of(it) }), LottoNumber.of(10))
        val lotto = Lotto((1..6).map { LottoNumber.of(it) })

        assertThat(winningLotto.matchedBonus(lotto)).isFalse
    }
}
