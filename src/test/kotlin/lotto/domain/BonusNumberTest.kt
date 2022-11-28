package lotto.domain

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class BonusNumberTest {

    private val winnerNumber = WinningNumber("1,2,3,4,5,6")

    @Test
    @DisplayName("보너스번호 입력이 지난주 당첨번호에 포함되어있을 경우 이루어져있을 경우 IllegalArgumentException 오류")
    fun `IllegalArgumentException error if the bonus number is included in last week winning number`() {
        val bonusNumberOfLastWeek = "1"
        assertThrows<IllegalArgumentException> { BonusNumber(bonusNumberOfLastWeek, winnerNumber) }
    }

    @Test
    @DisplayName("보너스번호 입력이 숫자가 아닌 다른 문자로 이루어져있을 경우 IllegalArgumentException 오류")
    fun `IllegalArgumentException error if the bonus number input consists of non-numeric characters`() {
        val bonusNumberOfLastWeek = "사십오"
        assertThrows<IllegalArgumentException> { BonusNumber(bonusNumberOfLastWeek, winnerNumber) }
    }

    @Test
    @DisplayName("보너스번호 입력이 공백일 경우 IllegalArgumentException 오류")
    fun `IllegalArgumentException error if bonus number input is blank`() {
        val bonusNumberOfLastWeek = ""
        assertThrows<IllegalArgumentException> { BonusNumber(bonusNumberOfLastWeek, winnerNumber) }
    }

    @Test
    @DisplayName("보너스번호 입력이 공백문자열일 경우 IllegalArgumentException 오류")
    fun `IllegalArgumentException error if bonus number input is a blank string`() {
        val bonusNumberOfLastWeek = "   "
        assertThrows<IllegalArgumentException> { BonusNumber(bonusNumberOfLastWeek, winnerNumber) }
    }
}
