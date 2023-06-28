package lotto

import io.kotest.assertions.throwables.shouldThrow
import lotto.domain.LottoNumber
import lotto.domain.WinningLotto
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    fun `당첨번호와 보너스번호가 중복되면 예외를 리턴한다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        val bonusNumber = LottoNumber(6)

        shouldThrow<IllegalStateException> {
            WinningLotto(winningNumbers, bonusNumber)
        }
    }
}
