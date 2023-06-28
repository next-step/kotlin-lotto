package lotto

import lotto.domain.LottoNumber
import lotto.domain.WinningLotto
import lotto.fixture.createLotto
import lotto.fixture.createWinningLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {
    @Test
    fun `지난 주 당첨 번호와 몇 개가 일치하는지 확인할 수 있다`() {
        val myLotto1 = createLotto(1, 2, 3, 4, 5, 6)
        val winningLotto = createWinningLotto(7, 1, 2, 3, 4, 5, 6)
        val myLotto2 = createLotto(10, 11, 12, 13, 14, 15)

        assertThat(myLotto1.numberOfMatch(winningLotto)).isEqualTo(6)
        assertThat(myLotto2.numberOfMatch(winningLotto)).isEqualTo(0)
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(createLotto(1, 2, 3, 4, 5, 6), LottoNumber.create(6))
        }
    }

    @Test
    fun `보너스 번호를 맞췄는지 확인할 수 있다`() {
        val winningLotto = WinningLotto(createLotto(1, 2, 3, 4, 5, 6), LottoNumber.create(7))
        val myLotto1 = createLotto(10, 11, 12, 13, 14, 15)
        val myLotto2 = createLotto(7, 8, 9, 10, 11, 12)

        assertThat(myLotto1.isCatchBonus(winningLotto)).isEqualTo(false)
        assertThat(myLotto2.isCatchBonus(winningLotto)).isEqualTo(true)
    }
}
