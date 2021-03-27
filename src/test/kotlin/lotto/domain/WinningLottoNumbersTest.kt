package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class WinningLottoNumbersTest {
    @Test
    fun `당첨 번호 갯수와 번호 검증`() {
        val winningLottoNumbers = WinningLottoNumbers.of("1,2,3,4,5,6", 7)

        assertThat(winningLottoNumbers.lotto.numbers.size).isEqualTo(6)
        assertThat(winningLottoNumbers.lotto.numbers[0]).isEqualTo(LottoNumber.from(1))
        assertThat(winningLottoNumbers.lotto.numbers[1]).isEqualTo(LottoNumber.from(2))
        assertThat(winningLottoNumbers.lotto.numbers[2]).isEqualTo(LottoNumber.from(3))
        assertThat(winningLottoNumbers.lotto.numbers[3]).isEqualTo(LottoNumber.from(4))
        assertThat(winningLottoNumbers.lotto.numbers[4]).isEqualTo(LottoNumber.from(5))
        assertThat(winningLottoNumbers.lotto.numbers[5]).isEqualTo(LottoNumber.from(6))
    }

    @ParameterizedTest
    @CsvSource(
        "'1, 1, 2, 3, 4, 5', 6",
        "'1, 1, 1, 1, 1, 1', 2",
        "'45, 44, 43, 20, 20, 5', 4"
    )
    fun `중복 번호 검증`(stringWinningLottoNumbers: String, bonusNumber: Int) {
        assertThrows<IllegalArgumentException> {
            WinningLottoNumbers.of(stringWinningLottoNumbers, bonusNumber)
        }
    }

    @ParameterizedTest
    @CsvSource(
        "'1, 2, 3, 4, 5, 6', 6",
        "'45, 44, 43, 42, 41, 1', 1",
        "'30, 25, 17, 1, 2, 3', 17"
    )
    fun `보너스볼과 당첨번호 중복 번호 검증`(stringWinningLottoNumbers: String, bonusNumber: Int) {
        assertThrows<IllegalArgumentException> {
            WinningLottoNumbers.of(stringWinningLottoNumbers, bonusNumber)
        }
    }

    @ParameterizedTest
    @CsvSource(
        "'1,11,41,21,22,23', 1",
        "'1,2,41,21,22,23', 2",
        "'3,4,5,21,22,23', 3",
        "'4,5,6,21,22,3', 4",
        "'11,2,3,4,5,6', 5",
        "'1,2,3,4,5,6', 6"
    )
    fun `당첨로또 갯수 카운트`(lottoNumbers: String, expectedCount: Int) {
        val winningLottoNumbers = WinningLottoNumbers.of("1,2,3,4,5,6", 7)
        val lotto = Lotto.from(LottoNumberTokenizer.tokenize(lottoNumbers).map { LottoNumber.from(it) })
        assertThat(winningLottoNumbers.countWinningNumbers(lotto)).isEqualTo(expectedCount)
    }
}
