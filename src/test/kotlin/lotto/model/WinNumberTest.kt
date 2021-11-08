package lotto.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WinNumberTest {
    @Test
    @DisplayName("지난주 당첨 번호 파싱하는 로직 확인")
    fun `check parsing logic of last win numbers`() {
        // given
        val input = "1,2,3,4,5,6"
        val expected = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )
        )

        // when
        val lottoNumber = WinNumber.parsingTextToLotto(input)

        // then
        Assertions.assertThat(lottoNumber).isEqualTo(expected)
    }

    @Test
    @DisplayName("당첨 번호 생성 확인")
    fun `check win numbers format`() {
        // given
        val numbers = "1,2,3,4,5,6"
        val bonusNumber = 9
        val expectedNumbers = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )
        )
        val expectedBonus = LottoNumber(bonusNumber)

        // when
        val lottoNumber = WinNumber.inputWinNumber(numbers, bonusNumber)

        // then
        Assertions.assertThat(lottoNumber.lastWinNumber).isEqualTo(expectedNumbers)
        Assertions.assertThat(lottoNumber.bonusNumber).isEqualTo(expectedBonus)
    }

    @Test
    @DisplayName("지난주 당첨 번호 입력값이 없는 경우")
    fun `null of last win number`() {
        // given
        val winNumber = null
        val bonus = 8

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { WinNumber.inputWinNumber(winNumber, bonus) }
    }

    @Test
    @DisplayName("보너스 번호 입력값이 없는 경우")
    fun `null of bonus number`() {
        // given
        val winNumber = "1,2,3,4,5,6"
        val bonus = null

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { WinNumber.inputWinNumber(winNumber, bonus) }
    }

    @Test
    @DisplayName("보너스 번호 입력값이 없는 경우")
    fun `overlap win numbers and bonus number`() {
        // given
        val winNumber = "1,2,3,4,5,6"
        val bonus = 2

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { WinNumber.inputWinNumber(winNumber, bonus) }
    }
}
