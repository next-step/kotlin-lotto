package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class WinningLottoTest {

    private val lottoNumbers = (1..6).toList().map { LottoNumber(it) }

    @ParameterizedTest
    @CsvSource(
        "1", "2", "3", "4", "5", "6",
    )
    fun `당첨번호와 중복된 보너스 번호를 확인합니다`(bonusNumber: Int) {
        assertThrows<IllegalArgumentException> {
            WinningLotto(lottoNumbers, LottoNumber(bonusNumber))
        }
    }

    @ParameterizedTest
    @CsvSource(
        "11", "12", "13", "14", "15", "16",
    )
    fun `중복된 보너스 번호가 없는 경우 동일한 로또 번호가 생성되는것을 확인한다`(bonusNumber: Int) {
        assertThat(WinningLotto(lottoNumbers, LottoNumber(bonusNumber))).isEqualTo(WinningLotto(lottoNumbers, LottoNumber(bonusNumber)))
    }

    @Test
    fun `일치하는 숫자가 3개인 로또가 한개인 경우 결과값 확인`() {
        assertThat(WinningPrizes(listOf(LottoResult.Prize.THIRD)).prizeResult).isEqualTo(
            listOf(
                Pair(LottoResult.Prize.THIRD, 1),
                Pair(LottoResult.Prize.FORTH, 0),
                Pair(LottoResult.Prize.FIFTH, 0),
                Pair(LottoResult.Prize.FIFTH_BONUS, 0),
                Pair(LottoResult.Prize.SIXTH, 0),
            )
        )
    }
    @Test
    fun `일치하는 숫자가 6개인 로또가 한개인 경우 통계데이터 확인`() {
        assertThat(WinningPrizes(listOf(LottoResult.Prize.SIXTH)).prizeResult).isEqualTo(
            listOf(
                Pair(LottoResult.Prize.THIRD, 0),
                Pair(LottoResult.Prize.FORTH, 0),
                Pair(LottoResult.Prize.FIFTH, 0),
                Pair(LottoResult.Prize.FIFTH_BONUS, 0),
                Pair(LottoResult.Prize.SIXTH, 1),
            )
        )
    }
}
