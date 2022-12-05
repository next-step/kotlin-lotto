package lotto.domain

import lotto.util.ErrorCode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class WinningLottoTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6])
    fun `지난 주 당첨 번호에 보너스 볼이 포함되는 경우 BONUS_LOTTO_NUMBER_EXCEPTION 예외 발생`(number: Int) {
        val previousWinningLottoNumbers =
            listOf(1, 2, 3, 4, 5, 6)
                .map { LottoNumber(it) }.toMutableSet()
        val previousWinningLotto = Lotto(previousWinningLottoNumbers)
        val bonusLottoNumber = LottoNumber(number)

        val exception = assertThrows<IllegalArgumentException> {
            WinningLotto(winningLotto = previousWinningLotto, bonusLottoNumber = bonusLottoNumber)
        }

        assertThat(exception.message).isEqualTo(ErrorCode.BONUS_LOTTO_NUMBER_EXCEPTION.errorMessage)
    }

    @Test
    fun `지난 주 당첨 로또와 하나의 로또를 비교하여, Lotto Rank 반환`() {
        val previousWinningLotto =
            listOf(1, 2, 3, 4, 5, 6)
                .map { LottoNumber(it) }.toMutableSet()
                .let { Lotto(it) }

        val bonusLottoNumber = LottoNumber(7)

        val lotto = listOf(1, 2, 3, 7, 9, 10)
            .map { LottoNumber(it) }.toMutableSet()
            .let { Lotto(it) }

        val resultLottoRank =
            WinningLotto(winningLotto = previousWinningLotto, bonusLottoNumber = bonusLottoNumber)
                .compare(lotto)

        assertThat(resultLottoRank).isEqualTo(LottoRank.FIFTH_PLACE)
    }

    @Test
    fun `당첨 로또와 다른 로또를 비교하였을 때, 로또 개수에 따른 다른 등수(MISS) 반환`() {
        val previousWinningLotto =
            listOf(1, 2, 3, 4, 5, 6)
                .map { LottoNumber(it) }.toMutableSet()
                .let { Lotto(it) }

        val bonusLottoNumber = LottoNumber(7)

        val lotto = listOf(7, 8, 9, 10, 11, 12)
            .map { LottoNumber(it) }.toMutableSet()
            .let { Lotto(it) }

        val resultLottoRank =
            WinningLotto(winningLotto = previousWinningLotto, bonusLottoNumber = bonusLottoNumber)
                .compare(lotto)

        assertThat(resultLottoRank).isEqualTo(LottoRank.MISS)
    }
}
