package lotto.view.inputconverter

import lotto.domain.model.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersConverterTest {
    @Test
    fun `WinningNumbersConverter는 string Input을 WinningNumbers로 변환한다`() {
        val winningNumbers = WinningNumbersConverter.convert("1, 2, 3, 4, 5, 6")
        val expected = setOf(
            LottoNumber[1],
            LottoNumber[2],
            LottoNumber[3],
            LottoNumber[4],
            LottoNumber[5],
            LottoNumber[6],
        )

        assertThat(winningNumbers).isEqualTo(expected)
    }

    @Test
    fun `Int로 변환할 수 없는 값이 입력값에 포함될 경우 NumberFormatException이 발생한다`() {
        assertThrows<NumberFormatException> {
            WinningNumbersConverter.convert("1, a, 2, 3, 4, 5")
        }
    }
}
