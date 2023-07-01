package lotto.domain

import lotto.helper.LottoNumbersHelper
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoWinningNumbersTest {

    @Test
    fun `당첨번호의 수가 잘못되어 실패한다`() {
        // expect
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            LottoWinningNumbers.of(
                winningNumbers = listOf(1, 2, 3, 4, 5, 6, 7),
                bonusNumber = 8
            )
        }
    }

    @Test
    fun `LottoMatchCount 를 구하는데 성공한다`() {
        // given
        val lottoWinningNumbers = LottoWinningNumbers.of(
            winningNumbers = listOf(1, 2, 3, 4, 5, 6),
            bonusNumber = 7
        )

        val lottoNumbers = LottoNumbersHelper.generate(1, 2, 3, 4, 5, 6)

        // when
        val lottoMatchCount = lottoWinningNumbers.match(lottoNumbers)

        // then
        assertAll({
            assertThat(lottoMatchCount.matchCount).isEqualTo(6)
            assertThat(lottoMatchCount.containsBonusNumber).isFalse()
        })
    }

    @Test
    fun `보너스 숫자를 포함하는 경우 LottoMatchCount를 구하는데 성공한다`() {
        // given
        val lottoWinningNumbers = LottoWinningNumbers.of(
                winningNumbers = listOf(1, 2, 3, 4, 5, 6),
                bonusNumber = 7
        )

        val lottoNumbers = LottoNumbersHelper.generate(1, 2, 3, 4, 7, 10)

        // when
        val lottoMatchCount = lottoWinningNumbers.match(lottoNumbers)

        // then
        assertAll({
            assertThat(lottoMatchCount.matchCount).isEqualTo(5)
            assertThat(lottoMatchCount.containsBonusNumber).isTrue()
        })
    }
}
