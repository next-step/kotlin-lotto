package domain.winning

import domain.lotto.LottoNumber
import domain.lotto.lottoNumberOf
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class WinningNumbersTest {
    @Test
    fun `당첨번호는 로또숫자열 하나와 보너스를 위한 로또숫자 하나로 생성된다`() {
        assertDoesNotThrow {
            WinningNumbers(
                numbers = lottoNumberOf(1, 2, 3, 4, 5, 6),
                bonus = LottoNumber.parse(7)
            )
        }
    }
}
