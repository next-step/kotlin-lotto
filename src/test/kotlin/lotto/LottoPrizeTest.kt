package lotto

import lotto.domain.LottoMatch
import lotto.domain.LottoPrize
import lotto.domain.enums.PrizeType
import lotto.domain.entity.user.Lotto
import lotto.domain.entity.winning.WinningLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoPrizeTest {

    @ParameterizedTest
    @CsvSource(value = ["1, 15, 22, 34, 41, 45|1, 22, 31, 38, 41, 44"], delimiterString = "|")
    fun `로또 매칭이 3개가 될 경우 3개의 당첨 금액인 5,000원이 전체 당첨 금액으로 나오는지 확인합니다`(
        winningLottoNumber: String,
        userLottoNumber: String
    ) {

        // given
        val userLotto: List<Lotto> = convertUserLotto(userLottoNumber)

        val winningLotto = convertWinningLotto(winningLottoNumber)

        // when
        val prizeMap = LottoMatch.match(userLotto, winningLotto)
        val lottoPrize = LottoPrize(prizeMap)

        // then
        assertThat(lottoPrize.totalPrizeMoney()).isEqualTo(PrizeType.THREE.money)
    }

    @ParameterizedTest
    @CsvSource(value = ["1, 15, 22, 34, 41, 45|1, 15, 22, 34, 43, 44"], delimiterString = "|")
    fun `로또 매칭이 4개가 될경우 4개의 당첨 금액인 50,000원이 전체 당첨 금액으로 나오는지 확인합니다`(
        winningLottoNumber: String,
        userLottoNumber: String
    ) {
        // given
        val userLotto: List<Lotto> = convertUserLotto(userLottoNumber)

        val winningLotto = convertWinningLotto(winningLottoNumber)

        // when
        val prizeMap = LottoMatch.match(userLotto, winningLotto)
        val lottoPrize = LottoPrize(prizeMap)

        assertThat(lottoPrize.totalPrizeMoney()).isEqualTo(PrizeType.FOUR.money)
    }

    @ParameterizedTest
    @CsvSource(value = ["1, 15, 22, 34, 41, 45|1, 15, 22, 34, 41, 44"], delimiterString = "|")
    fun `로또 매칭이 5개가 될경우 5개의 당첨 금액인 1,500,000 전체 당첨 금액으로 나오는지 확인합니다`(
        winningLottoNumber: String,
        userLottoNumber: String
    ) {
        // given
        val userLotto: List<Lotto> = convertUserLotto(userLottoNumber)

        val winningLotto = convertWinningLotto(winningLottoNumber)

        // when
        val prizeMap = LottoMatch.match(userLotto, winningLotto)
        val lottoPrize = LottoPrize(prizeMap)

        assertThat(lottoPrize.totalPrizeMoney()).isEqualTo(PrizeType.FIVE.money)
    }

    @ParameterizedTest
    @CsvSource(value = ["1, 15, 22, 34, 41, 45|1, 15, 22, 34, 41, 45"], delimiterString = "|")
    fun `로또 매칭이 5개가 될경우 6개의 당첨 금액인 2,000,000,000 전체 당첨 금액으로 나오는지 확인합니다`(
        winningLottoNumber: String,
        userLottoNumber: String
    ) {
        // given
        val userLotto: List<Lotto> = convertUserLotto(userLottoNumber)

        val winningLotto = convertWinningLotto(winningLottoNumber)

        // when
        val prizeMap = LottoMatch.match(userLotto, winningLotto)
        val lottoPrize = LottoPrize(prizeMap)

        assertThat(lottoPrize.totalPrizeMoney()).isEqualTo(PrizeType.SIX.money)
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
