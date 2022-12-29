package lotto.domain

import lotto.model.LottoNumber
import lotto.model.LottoNumbers
import lotto.model.Rank
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

internal class WinningLottoTest {
    @Test
    fun `당첨 번호는 6개의 숫자로 구성된다`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)

        // when
        val winningLotto = WinningLotto(numbers)

        // then
        assertThat(winningLotto.numbers).isEqualTo(numbers)
    }

    @Test
    fun `담청 번호는 6개의 숫자가 아니면 예외가 발생한다`() {
        val numbers = listOf(1, 2, 3, 4, 5).map(::LottoNumber)

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { WinningLotto(numbers) }
            .withMessage("당첨 번호는 6개의 숫자여야 합니다.")
    }

    @Test
    fun `담청 번호는 중복되는 숫자가 있으면 예외가 발생한다`() {
        val numbers = listOf(1, 2, 1, 4, 5, 6).map(::LottoNumber)

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { WinningLotto(numbers) }
            .withMessage("당첨 번호는 중복되는 숫자가 없어야 합니다.")
    }

    @Test
    fun `당첨된 로또 등수를 알 수 있다`() {
        // given
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber))
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber))

        // when
        val rank = winningLotto.rank(lottoNumbers)

        // then
        assertThat(rank).isEqualTo(Rank.FIRST)
    }
}
