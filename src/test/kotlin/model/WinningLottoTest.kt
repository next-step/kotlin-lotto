package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    @DisplayName("보너스 번호를 입력 받는다")
    fun `inputBonusNumber`() {
        val list: List<LottoNumber> = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) }
        val winningLotto = WinningLotto(list)
        winningLotto.bonusNumber = 7
        assertThat(winningLotto.bonusNumber).isNotNull()
    }
}
