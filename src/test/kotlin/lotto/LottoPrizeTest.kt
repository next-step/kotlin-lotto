package lotto

import lotto.domain.LottoMatch
import lotto.domain.LottoPrize
import lotto.domain.enums.PrizeType
import lotto.domain.entity.user.Lotto
import lotto.domain.entity.winning.BonusNumber
import lotto.domain.entity.winning.WinningLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoPrizeTest {

    @ParameterizedTest
    @CsvSource(value = ["1, 15, 22, 34, 41, 45|1, 22, 31, 38, 41, 44|43"], delimiterString = "|")
    fun `로또 매칭이 3개가 될 경우 5등 당첨 금액인 5,000원이 전체 당첨 금액으로 나오는지 확인합니다`(
        winningLottoNumber: String,
        userLottoNumber: String,
        bonus: Int
    ) {

        // given
        val userLotto: List<Lotto> = convertUserLotto(userLottoNumber)
        val winningLotto = convertWinningLotto(winningLottoNumber)
        val bonusNumber = BonusNumber(bonus)

        // when
        val prizeMap = LottoMatch.match(userLotto, winningLotto, bonusNumber)
        val lottoPrize = LottoPrize(prizeMap)

        // then
        assertThat(lottoPrize.totalPrizeMoney()).isEqualTo(PrizeType.FIFTH_PLACE.money)
    }

    @ParameterizedTest
    @CsvSource(value = ["1, 15, 22, 34, 41, 45|1, 15, 22, 34, 43, 44|2"], delimiterString = "|")
    fun `로또 매칭이 4개가 될경우 4등 당첨 금액인 50,000원이 전체 당첨 금액으로 나오는지 확인합니다`(
        winningLottoNumber: String,
        userLottoNumber: String,
        bonus: Int
    ) {
        // given
        val userLotto: List<Lotto> = convertUserLotto(userLottoNumber)
        val winningLotto = convertWinningLotto(winningLottoNumber)
        val bonusNumber = BonusNumber(bonus)


        // when
        val prizeMap = LottoMatch.match(userLotto, winningLotto, bonusNumber)
        val lottoPrize = LottoPrize(prizeMap)

        assertThat(lottoPrize.totalPrizeMoney()).isEqualTo(PrizeType.FOURTH_PLACE.money)
    }

    @ParameterizedTest
    @CsvSource(value = ["1, 15, 22, 34, 41, 45|1, 15, 22, 34, 41, 44|2"], delimiterString = "|")
    fun `로또 매칭이 보너스 번호가 포함되지 않은 5개일경우 3등의 당첨 금액인 1,500,000 전체 당첨 금액으로 나오는지 확인합니다`(
        winningLottoNumber: String,
        userLottoNumber: String,
        bonus: Int
    ) {
        // given
        val userLotto: List<Lotto> = convertUserLotto(userLottoNumber)
        val winningLotto = convertWinningLotto(winningLottoNumber)
        val bonusNumber = BonusNumber(bonus)

        // when
        val prizeMap = LottoMatch.match(userLotto, winningLotto, bonusNumber)

        val lottoPrize = LottoPrize(prizeMap)

        assertThat(lottoPrize.totalPrizeMoney()).isEqualTo(PrizeType.THIRD_PLACE.money)
    }

    @ParameterizedTest
    @CsvSource(value = ["1, 11, 23, 34, 37, 45|1, 11, 23, 34, 36, 45|36"], delimiterString = "|")
    fun `로또 매칭이 보너스 번호가 포함된 5개일경우 2등의 당첨 금액인 30_000_000 전체 당첨 금액으로 나오는지 확인합니다`(
        winningLottoNumber: String,
        userLottoNumber: String,
        bonus: Int
    ) {
        // given
        val userLotto: List<Lotto> = convertUserLotto(userLottoNumber)
        val winningLotto = convertWinningLotto(winningLottoNumber)
        val bonusNumber = BonusNumber(bonus)

        // when
        val prizeMap = LottoMatch.match(userLotto, winningLotto, bonusNumber)

        val lottoPrize = LottoPrize(prizeMap)

        assertThat(lottoPrize.totalPrizeMoney()).isEqualTo(PrizeType.SECOND_PLACE.money)
    }

    @ParameterizedTest
    @CsvSource(value = ["1, 15, 22, 34, 41, 45|1, 15, 22, 34, 41, 45|2"], delimiterString = "|")
    fun `로또 매칭이 6개가 될경우 1등 당첨 금액인 2,000,000,000 전체 당첨 금액으로 나오는지 확인합니다`(
        winningLottoNumber: String,
        userLottoNumber: String,
        bonus: Int
    ) {
        // given
        val userLotto: List<Lotto> = convertUserLotto(userLottoNumber)
        val winningLotto = convertWinningLotto(winningLottoNumber)
        val bonusNumber = BonusNumber(bonus)

        // when
        val prizeMap = LottoMatch.match(userLotto, winningLotto, bonusNumber)
        val lottoPrize = LottoPrize(prizeMap)

        assertThat(lottoPrize.totalPrizeMoney()).isEqualTo(PrizeType.FIRST_PLACE.money)
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
