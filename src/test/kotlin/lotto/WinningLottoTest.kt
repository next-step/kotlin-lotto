package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.WinningLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {
    @Test
    fun `지난 주 당첨 번호와 몇 개가 일치하는지 확인할 수 있다`() {
        val lottoNumbers1 = listOf(1, 2, 3, 4, 5, 6)
        val myLotto1 = Lotto.manualCreate(lottoNumbers1)
        val winningLotto = WinningLotto(myLotto1, LottoNumber.create(7))

        val lottoNumbers2 = listOf(10, 11, 12, 13, 14, 15)
        val myLotto2 = Lotto.manualCreate(lottoNumbers2)
        assertThat(myLotto1.numberOfMatch(winningLotto)).isEqualTo(6)
        assertThat(myLotto2.numberOfMatch(winningLotto)).isEqualTo(0)
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            val lottoNumbers1 = listOf(1, 2, 3, 4, 5, 6)
            val myLotto1 = Lotto.manualCreate(lottoNumbers1)
            WinningLotto(myLotto1, LottoNumber.create(6))
        }
    }

    @Test
    fun `보너스 번호를 맞췄는지 확인할 수 있다`() {
        val winningLottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lottoOfwinningLotto = Lotto.manualCreate(winningLottoNumbers)
        val winningLotto = WinningLotto(lottoOfwinningLotto, LottoNumber.create(7))

        val lottoNumbers1 = listOf(10, 11, 12, 13, 14, 15)
        val myLotto1 = Lotto.manualCreate(lottoNumbers1)

        val lottoNumbers2 = listOf(7, 8, 9, 10, 11, 12)
        val myLotto2 = Lotto.manualCreate(lottoNumbers2)
        assertThat(myLotto1.isCatchBonus(winningLotto)).isEqualTo(false)
        assertThat(myLotto2.isCatchBonus(winningLotto)).isEqualTo(true)
    }
}
