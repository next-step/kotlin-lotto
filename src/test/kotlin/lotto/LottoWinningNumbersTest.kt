package lotto

import lotto.domain.LottoNumbers
import lotto.domain.LottoWinningNumbers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoWinningNumbersTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `보너스 번호가 유요한 범위 내의 숫자가 아니라면 throw IllegalArgumentException`(bonusNumber: Int) {
        assertThrows<IllegalArgumentException> {
            LottoWinningNumbers(LottoNumbers(setOf(1, 2, 3, 4, 5, 6)), bonusNumber)
        }
    }

    @Test
    fun `보너스 번호가 다른 로또 번호와 중복이라면 throw IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            LottoWinningNumbers(LottoNumbers(setOf(1, 2, 3, 4, 5, 6)), 1)
        }
    }

    @Test
    fun `로또 당첨 번호 생성이 exception 없이 잘 되어야 한다`() {
        assertDoesNotThrow {
            LottoWinningNumbers.generate()
        }
    }
}
