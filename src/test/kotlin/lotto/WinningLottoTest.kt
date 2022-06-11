package lotto

import lotto.model.Lotto
import lotto.model.LottoNumber
import lotto.model.WinningLotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class WinningLottoTest {

    @Test
    fun `당첨 로또와 보너스 볼의 숫자가 중복되면 IllegalArgumentException 예외가 발생한다`() {
        val winLottoNumbers = Lotto(Fixtures.createSixLottoNumber(listOf(1, 2, 3, 4, 5, 10)))
        val bonusNumber = LottoNumber.from(10)

        assertThrows<IllegalArgumentException> { WinningLotto(winLottoNumbers, bonusNumber) }
    }
}
