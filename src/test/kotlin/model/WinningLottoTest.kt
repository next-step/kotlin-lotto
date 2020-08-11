package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    @DisplayName("보너스 번호를 입력 받는다")
    fun `inputBonusNumber`() {
        val set: Set<LottoNumber> = setOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) }.toSet()
        val winningLotto = WinningLotto(set)
        winningLotto.bonusNumber = 7
        assertThat(winningLotto.bonusNumber).isNotNull()
    }
}
