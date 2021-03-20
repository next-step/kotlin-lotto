package lotto.vo

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class WinningLottoTest {
    @Test
    @DisplayName("보너스 번호는 당첨번호 6개와 중복될 수 없다")
    fun bonusNumShouldNotDuplicateWinningNumbers() {
        val winningLotto = setOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        )
        val bonusNumber = LottoNumber.from(6)

        assertThrows<IllegalArgumentException> {
            WinningLotto(winningLotto, bonusNumber)
        }
    }
}
