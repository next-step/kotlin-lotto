package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoMatchNumbersTest {

    @Test
    fun `모든 번호가 매칭된 경우`() {
        // given
        val lottoNumbers = (1..6).map { LottoNumber(it) }
        val lottoMatchNumbers = LottoMatchNumbers.of(lottoNumbers.map { it.number }, 7)

        // when
        val result = lottoMatchNumbers.match(lottoNumbers)

        // then
        assertAll({
            assertThat(result.matchCount).isEqualTo(6)
            assertThat(result.containsBonusNumber).isFalse()
        })
    }

    @Test
    fun `5개 번호와 보너스 번호가 매칭된 경우`() {
        // given
        val lottoNumbers = listOf(1, 2, 3, 4, 7, 8).map { LottoNumber(it) }
        val matchLottoNumbers = (1..6).map { LottoNumber(it) }
        val lottoMatchNumbers = LottoMatchNumbers.of(matchLottoNumbers.map { it.number }, 7)

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
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                LottoMatchNumbers(
                    setOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(5)
                    ),
                    LottoNumber(7)
                )
            }
    }
}
