package lotto

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

class LottoWinningInfoTest {

    @Test
    fun `입력된 문자열을 통해 숫자 리스트를 출력해야한다`() {
        val winningNumberInput = "1,2,3,4,5,6"
        val winningInfo = LottoWinningInfo(winningNumberInput)

        winningInfo.getWinningNumbers().all { it is Int }
    }

    @Test
    fun `입력된 문자열을 리스트로 만들었을 때 길이는 항상 6이어야 한다`() {
        val winningNumberInput = "1,2,3,4,5,6,7"
        val winningInfo = LottoWinningInfo(winningNumberInput)

        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            winningInfo.getWinningNumbers()
        }

    }

    @Test
    fun `, 가 아닌 구분자는 허용할 수 없다`() {
        val winningNumberInput = "1*2*3*4*5*6"
        val winningInfo = LottoWinningInfo(winningNumberInput)

        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            winningInfo.getWinningNumbers()
        }
    }
}