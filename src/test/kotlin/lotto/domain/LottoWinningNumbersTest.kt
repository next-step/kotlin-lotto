package lotto.domain

import lotto.helper.LottoNumbersHelper
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoWinningNumbersTest {

    @Test
    fun `7개의 번호와 1개의 보너스볼로, 당첨번호를 만들면, 실패한다`() {
        // expect
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            LottoWinningNumbers.of(
                winningNumbers = listOf(1, 2, 3, 4, 5, 6, 7),
                bonusNumber = 8
            )
        }
    }

    @Test
    fun `당첨번호와 보너스번호가 겹치는 경우 실패한다`() {
        // expect
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            LottoWinningNumbers.of(
                winningNumbers = listOf(1, 2, 3, 4, 5, 6),
                bonusNumber = 6
            )
        }
    }

    @Test
    fun `모든 번호가 매칭되고 보너스 번호는 포함하지 않는 경우 매칭 수는 6이고 보너스 번호 포함 여부는 false 이다`() {
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
    fun `4개 번호가 매칭되고 보너스 번호를 포함하는 경우 매칭 수는 4이고 보너스 번호 포함 여부는 true 이다`() {
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
            assertThat(lottoMatchCount.matchCount).isEqualTo(4)
            assertThat(lottoMatchCount.containsBonusNumber).isTrue()
        })
    }
}
