package lotto

import lotto.domain.LottoNumbers
import lotto.domain.ManualLottoCreator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또는 6개의 숫자로 이뤄져 있다`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { ManualLottoCreator(LottoNumbers(1, 2, 3, 4, 5, 6, 7)) }
    }

    @Test
    fun `로또는 1~45 사이의 숫자들이다`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { ManualLottoCreator(LottoNumbers(0, 1, 2, 3, 4, 5)) }
    }

    @Test
    fun `로또는 숫자들이 겹치면 안된다`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { ManualLottoCreator(LottoNumbers(1, 1, 2, 3, 4, 5)) }
    }
}
