package lotto

import lotto.domain.BonusBall
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BonusBallTest {

    @DisplayName("지난주 당첨 번호에 BonusBall 넘버가 포함되면 Exception을 던진다.")
    @Test
    fun `지난주 당첨 번호에 BonusBall 넘버가 포함되면 Exception을 던진다`() {
        val winningLottoNumbers = (1..6).map { LottoNumber.from(it) }
        val winningLotto = Lotto.from(winningLottoNumbers)

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            BonusBall("3", winningLotto)
        }.withMessage(BonusBall.WINNING_LOTTO_CONTAIN_BONUS_NUMBER_EXCEPTION)
    }
}