package lotto

import lotto.domain.LottoMatch
import lotto.domain.entity.user.Lotto
import lotto.domain.entity.winning.BonusNumber
import lotto.domain.entity.winning.WinningLotto
import lotto.domain.enums.PrizeType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMatchTest {

    @ParameterizedTest
    @CsvSource(
        value = ["1,2,3,11,22,33|1,2,3,14,24,35|41|3", "1,11,22,33,41,45|1,11,22,33,40,44|43|4", "3,5,15,28,31,43|3,5,15,28,31,45|45|5", "9,19,29,31,35,42|9,19,29,31,35,42|45|6"],
        delimiterString = "|"
    )
    fun `로또 번호가 3이상 매칭될경우 값이 카운팅(1) 되는걸 확인한다`(
        userLottoNumber: String,
        winningLottoNumber: String,
        bonus: Int,
        matchCount: Int
    ) {

        // given
        val userLotto = convertUserLotto(userLottoNumber)
        val winningLotto = convertWinningLotto(winningLottoNumber)
        val bonusNumber = BonusNumber(bonus)

        // when
        val match = LottoMatch.match(userLotto, winningLotto, bonusNumber)
        val prizeType = PrizeType.findPrize(matchCount, false)

        // then
        assertThat(match[prizeType]).isEqualTo(1)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["1,2,3,4,5,6|11,13,24,35,44,45|7|0", "1,11,22,33,41,45|1,12,23,34,42,44|43|1", "1,11,22,33,41,45|1,11,24,34,35,40|43|2"],
        delimiterString = "|"
    )
    fun `로또 번호가 3개 미만으로 매칭될경우 0개가 카운팅 되는걸 확인한다`(
        userLottoNumber: String,
        winningLottoNumber: String,
        bonus: Int,
        matchCount: Int
    ) {

        // given
        val userLotto = convertUserLotto(userLottoNumber)
        val winningLotto = convertWinningLotto(winningLottoNumber)
        val bonusNumber = BonusNumber(bonus)

        // when
        val match = LottoMatch.match(userLotto, winningLotto, bonusNumber)
        val prizeType = PrizeType.findPrize(matchCount, false)

        // then
        assertThat(match[prizeType]).isEqualTo(0)
    }

    private fun convertUserLotto(userLottoNumber: String): List<Lotto> = listOf(
        Lotto(
            userLottoNumber
                .split(",")
                .map { it.trim().toInt() }
                .toList()
        )
    )

    private fun convertWinningLotto(winningLottoNumber: String): WinningLotto = WinningLotto(
        winningLottoNumber
            .split(",")
            .map { it.trim().toInt() }
            .toList()
    )
}
