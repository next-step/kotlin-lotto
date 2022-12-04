package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinningNumbersTest {
    @Test
    fun `로또 번호 + 보너스 번호 - 로또 번호와 보너스 번호가 중복되는 경우에 대한 예외처리 테스트`() {
        // given
        val lottoNumbers = LottoNumbers(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6)))
        val bonusNumber = LottoNumber(1)

        // when
        val exception = assertThrows<IllegalArgumentException> {
            WinningNumbers(lottoNumbers, bonusNumber)
        }

        // then
        assertThat(exception.message).isEqualTo("보너스 번호는 당첨 번호와 중복될 수 없습니다.")
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2,3,4,5,6:45:FIRST", "1,2,3,4,5,7:44:THIRD", "1,2,3,4,7,8:45:FOURTH", "1,2,3,7,8,9:45:FIFTH", "1,2,7,8,9,10:45:MISS", "1,7,8,9,10,11:45:MISS", "7,8,9,10,11,12:45:MISS"], delimiter = ':')
    fun `로또 번호 + 보너스 번호 - 순위 확인 테스트`(given: String, bonusNumber: Int, expected: String) {
        // given
        val winningNumbers = LottoNumbers(given.split(",").map { LottoNumber(it.toInt()) })
        val winningNumbersWithBonusNumber = WinningNumbers(winningNumbers, LottoNumber(bonusNumber))
        val lottoNumbers = LottoNumbers(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6)))

        // when
        val actual = winningNumbersWithBonusNumber.getLottoRank(lottoNumbers)

        // then
        assertThat(actual).isEqualTo(LottoRank.valueOf(expected))
    }
}
