package lotto

import lotto.domain.BonusNumber
import lotto.domain.LastWeekNumber
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class BonusNumberTest {

    @Test
    fun `저번주 당첨 번호에 보너스 번호가 포함 되면 예외를 발생 시킨다`() {
        val lastWeekNumber = LastWeekNumber(listOf(1, 2, 3, 4, 5, 6))
        assertThatIllegalArgumentException().isThrownBy { BonusNumber(6, lastWeekNumber) }
    }
}
