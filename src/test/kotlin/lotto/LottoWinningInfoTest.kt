package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoWinningInfoTest {

    @Test
    fun `입력된 문자열을 통해 숫자 리스트를 출력해야한다`() {
        val winningNumberInput = "1,2,3,4,5,6"
        val winningInfo = LottoWinningInfo(winningNumberInput, "7")

        winningInfo.winningNumbers.all { it is Int }
    }

    @Test
    fun `입력된 문자열을 리스트로 만들었을 때 길이는 항상 6이어야 한다`() {
        val winningNumberInput = "1,2,3,4,5,6,7"
        assertThrows<IllegalArgumentException> {
            val winningInfo = LottoWinningInfo(winningNumberInput, "7")
        }
    }

    @Test
    fun `, 가 아닌 구분자는 허용할 수 없다`() {
        val winningNumberInput = "1*2*3*4*5*6"
        assertThrows<IllegalArgumentException> {
            val winningInfo = LottoWinningInfo(winningNumberInput, "7")
        }
    }

    @Test
    fun `bonus 숫자는 winning number에 포함되면 안된다`() {
        val winningNumberInput = "1,2,3,4,5,6"
        assertThrows<IllegalArgumentException> {
            val winningInfo = LottoWinningInfo(winningNumberInput, "6")
        }
    }
}
