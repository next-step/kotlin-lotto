package lotto

import lotto.model.Lotto
import lotto.model.LottoPrize
import lotto.service.LottoTicketCountCalculator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoPlayTest {
    @DisplayName(value = "로또는 한장당 천원")
    @ParameterizedTest
    @ValueSource(ints = [14000])
    fun getCountLottoTicket(inputAmount: Int) {
        Assertions.assertThat(LottoTicketCountCalculator.getCount(inputAmount)).isEqualTo(14)
    }

    @DisplayName(value = "로또는 당첨번호는 1부터 45까지 이뤄져있다")
    @Test
    fun checkLottoNumberRange() {
        Assertions.assertThat(Lotto().purchasedLottoNumbers.all { it <= 45 })
        Assertions.assertThat(Lotto().purchasedLottoNumbers.all { it >= 1 })
    }

    @DisplayName(value = "로또 번호 6개 끼리 중복이 없다")
    @Test
    fun testWinning() {
        Assertions.assertThat(Lotto().purchasedLottoNumbers.toHashSet().size).isEqualTo(6)
        Assertions.assertThat(Lotto().purchasedLottoNumbers.toHashSet().size).isEqualTo(6)
    }

    @DisplayName(value = "지난주 당첨 번호와 2개 이하 일치시 상금 0 원")
    @ParameterizedTest
    @ValueSource(ints = [2])
    fun testNotPrizeAmount(matchingCount: Int) {
        Assertions.assertThat(LottoPrize.getLottoPrize(matchingCount).prizeAmount).isEqualTo(0)
    }

    @DisplayName(value = "지난주 당첨 번호와 3개 일치 상금 5000원 ")
    @ParameterizedTest
    @ValueSource(strings = ["5000"])
    fun testFourthPrizeAmount(matchingCount: String) {
        val winningLottoNumber = Lotto()
        val lastWeekWinningLottoNumber = winningLottoNumber.purchasedLottoNumbers.toMutableList()

        Assertions.assertThat(winningLottoNumber.setLottoPrize(lastWeekWinningLottoNumber.subList(0,3)).prizeAmount)
            .isEqualTo(matchingCount.toLong())
    }

    @DisplayName(value = "지난주 당첨 번호와 4개 일치 상금 50000원 ")
    @ParameterizedTest
    @ValueSource(strings = ["50000"])
    fun testThirdPrizeAmount(matchingCount: String) {
        val winningLottoNumber = Lotto()
        val lastWeekWinningLottoNumber = winningLottoNumber.purchasedLottoNumbers.toMutableList()

        Assertions.assertThat(winningLottoNumber.setLottoPrize(lastWeekWinningLottoNumber.subList(0,4)).prizeAmount)
            .isEqualTo(matchingCount.toLong())
    }

    @DisplayName(value = "지난주 당첨 번호와 5개 일치 상금 1500000원")
    @ParameterizedTest
    @ValueSource(strings = ["1500000"])
    fun testSecondPrizeAmount(matchingCount: String) {
        val winningLottoNumber = Lotto()
        val lastWeekWinningLottoNumber = winningLottoNumber.purchasedLottoNumbers.toMutableList()

        Assertions.assertThat(winningLottoNumber.setLottoPrize(lastWeekWinningLottoNumber.subList(0,5)).prizeAmount)
            .isEqualTo(matchingCount.toLong())
    }

    @DisplayName(value = "지난주 당첨 번호와 6개 일치 상금 2000000000원")
    @ParameterizedTest
    @ValueSource(strings = ["2000000000"])
    fun testFirstPrizeAmount(matchingCount: String) {
        val winningLottoNumber = Lotto()
        val lastWeekWinningLottoNumber = winningLottoNumber.purchasedLottoNumbers.toList()
        Assertions.assertThat(winningLottoNumber.setLottoPrize(lastWeekWinningLottoNumber).prizeAmount)
            .isEqualTo(matchingCount.toLong())
    }

}
