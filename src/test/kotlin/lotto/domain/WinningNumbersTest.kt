package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@Suppress("NonAsciiCharacters")
class WinningNumbersTest {

    @Test
    fun `당첨 번호와 티켓의 일치하는 갯수를 구한다`() {
        // given
        val winningNumbers = WinningNumbers(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), LottoNumber.valueOf(7))
        val ticket = LottoNumbers(listOf(4, 5, 6, 7, 8, 9))

        // when
        val result = winningNumbers.countSameNumber(ticket)

        // then
        assertThat(result).isEqualTo(3)
    }

    @ParameterizedTest
    @CsvSource(value = ["7,true", "8,false"])
    fun `티켓이 보너스 번호를 포함하는지 여부를 확인한다`(bonus: Int, expected: Boolean) {
        // given
        val winningNumbers = WinningNumbers(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), LottoNumber.valueOf(bonus))
        val ticket = LottoNumbers(listOf(2, 3, 4, 5, 6, 7))

        // when
        val result = winningNumbers.containsBonus(ticket)

        // then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `당첨 번호와 보너스 번호는 중복될 수 없다`() {
        // given
        val winning = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        val bonus = LottoNumber.valueOf(1)

        // when
        val create: () -> Unit = { WinningNumbers(winning, bonus) }

        // then
        assertThrows<IllegalArgumentException>(create)
    }
}
