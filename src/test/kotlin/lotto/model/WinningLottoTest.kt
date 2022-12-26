package lotto.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class WinningLottoTest {
    @Test
    fun `당첨 번호는 6개의 숫자로 구성된다`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)

        // when
        val winningLotto = WinningLotto(numbers)

        // then
        Assertions.assertThat(winningLotto.numbers).isEqualTo(numbers)
    }

    @Test
    fun `담청 번호는 6개의 숫자가 아니면 예외가 발생한다`() {
        val numbers = listOf(1, 2, 3, 4, 5).map(::LottoNumber)

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { WinningLotto(numbers) }
            .withMessage("당첨 번호는 6개의 숫자여야 합니다.")
    }

    @Test
    fun `담청 번호는 중복되는 숫자가 있으면 예외가 발생한다`() {
        val numbers = listOf(1, 2, 1, 4, 5, 6).map(::LottoNumber)

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { WinningLotto(numbers) }
            .withMessage("당첨 번호는 중복되는 숫자가 없어야 합니다.")
    }
}
