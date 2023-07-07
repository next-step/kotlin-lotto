package lotto.domain

import lotto.helper.LottoNumbersHelper
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoMatchNumbersTest {

    @Test
    fun `모든 번호가 매칭된 경우, 매칭된 건 수는 6이다`() {
        // given
        val lottoNumbers = LottoNumbersHelper.generate(1, 2, 3, 4, 5, 6)
        val lottoMatchNumbers = LottoWinningNumbers.of(lottoNumbers.lottoNumbers.map { it.number }, 7)

        // when
        val result = lottoMatchNumbers.match(lottoNumbers)

        // then
        assertAll({
            assertThat(result.matchCount).isEqualTo(6)
            assertThat(result.containsBonusNumber).isFalse()
        })
    }

    @Test
    fun `5개 번호와 보너스 번호가 매칭된 경우, 매칭된 건 수는 4이고 보스너번호 포함여부는 true이다`() {
        // given
        val lottoNumbers = LottoNumbersHelper.generate(1, 2, 3, 4, 5, 7)
        val lottoMatchNumbers = LottoWinningNumbers.of((1..6).map { it }, 7)

        // when
        val result = lottoMatchNumbers.match(lottoNumbers)

        // then
        assertAll({
            assertThat(result.matchCount).isEqualTo(5)
            assertThat(result.containsBonusNumber).isTrue()
        })
    }

    @Test
    fun `당첨번호가 6개가 아닌 경우 실패한다`() {
        // expect
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            LottoWinningNumbers(
                LottoNumbersHelper.generate(1, 2, 3, 4, 5, 5),
                LottoNumber(7)
            )
        }
    }
}
