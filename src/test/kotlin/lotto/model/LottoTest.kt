package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

internal class LottoTest {

    @Test
    fun `로또 번호는 6개의 숫자로 구성된다`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)

        // when
        val lotto = Lotto(numbers)

        // then
        assertThat(lotto.numbers).isEqualTo(numbers)
    }

    @Test
    fun `로또 번호는 6개의 숫자가 아니면 예외가 발생한다`() {
        val numbers = listOf(1, 2, 3, 4, 5).map(::LottoNumber)

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lotto(numbers) }
            .withMessage("로또 번호는 6개의 숫자로 구성되어야 합니다.")
    }
}
