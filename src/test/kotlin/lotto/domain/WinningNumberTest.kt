package lotto.domain

import lotto.domain.lotto.LottoNumber
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class WinningNumberTest {

    @Test
    @DisplayName("지난주 당첨번호 수가 로또번호 보다 적을 경우 IllegalArgumentException 오류")
    fun `IllegalArgumentException error if the number of winning numbers last week is less than the lotto number`() {
        val number = "1,2,3,4,5"
        assertThrows<IllegalArgumentException> { WinningNumber(number) }
    }

    @Test
    @DisplayName("지난주 당첨번호 수가 로또번호 보다 많을 경우 IllegalArgumentException 오류")
    fun `IllegalArgumentException error if the number of winning numbers last week is higher than the lotto number`() {
        val number = "1,2,3,4,5,6,7"
        assertThrows<IllegalArgumentException> { WinningNumber(number) }
    }

    @Test
    @DisplayName("지난주 당첨번호 수가 1,2,3,4,5,6 경우 배열 [1,2,3,4,5,6]을 반환")
    fun `If the number of winning numbers from last week is 1 2 3 4 5 6  return the array 1 2 3 4 5 6`() {
        val number = "1,2,3,4,5,6"
        val winningNumber = WinningNumber(number)
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        Assertions.assertThat(winningNumber.winnerNumber).isEqualTo(winningLotto)
    }

    @Test
    @DisplayName("지난주 당첨번호 입력이 숫자와 쉼표(,)가 아닌 다른 문자로 이루어져있을 경우 IllegalArgumentException 오류")
    fun `IllegalArgumentException error if last week's winning number entry consists of a number and a character other than a comma`() {
        val number = "1,2,3,4;5,6"
        assertThrows<IllegalArgumentException> { WinningNumber(number) }
    }

    @Test
    @DisplayName("지난주 당첨번호 입력이 공백일 경우 IllegalArgumentException 오류")
    fun `IllegalArgumentException error if last week's winning number is blank`() {
        val number = ""
        assertThrows<IllegalArgumentException> { WinningNumber(number) }
    }

    @Test
    @DisplayName("당첨 번호가 중복으로 입력됬을 경우 IllegalArgumentException 오류")
    fun `IllegalArgumentException error if the winning number is entered in duplicate`() {
        val number = "1,2,3,4,5,5"
        assertThrows<IllegalArgumentException> { WinningNumber(number) }
    }
}
