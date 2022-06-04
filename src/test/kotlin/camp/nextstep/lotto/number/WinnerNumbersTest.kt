package camp.nextstep.lotto.number

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class WinnerNumbersTest {

    @DisplayName("보너스 번호는 당첨 번호와 같을 수 없다.")
    @Test
    fun winnerNumbersShouldNotContainBonusNumber() {
        val winnerNumbers = LottoNumbers.of(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber.of(1)
        assertThrows<IllegalArgumentException> {
            WinnerNumbers(winnerNumbers, bonusNumber)
        }
    }
}
