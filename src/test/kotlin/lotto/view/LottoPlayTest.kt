package lotto.view

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
        Assertions.assertThat(Lotto().winningNumber.all { it <= 45 })
        Assertions.assertThat(Lotto().winningNumber.all { it >= 1 })
    }

    @DisplayName(value = "로또 번호 6개 끼리 중복이 없다")
    @Test
    fun testWinning() {
        Assertions.assertThat(Lotto().winningNumber.toHashSet().size).isEqualTo(6)
        Assertions.assertThat(Lotto().winningNumber.toHashSet().size).isEqualTo(6)
    }

    @DisplayName(value = "지난주 당첨 번호와 2개 이하 일치시 상금 0 원")
    @ParameterizedTest
    @ValueSource(ints = [2])
    fun testNotPrizeAmount(matchingCount: Int) {
        Assertions.assertThat(LottoPrize.getPrizeAmount(matchingCount)).isEqualTo(0)
    }

    @DisplayName(value = "지난주 당첨 번호와 3개 일치 상금 5000원 winning")
    @ParameterizedTest
    @ValueSource(strings = ["3"])
    fun testFourthPrizeAmount(matchingCount: String) {
        Assertions.assertThat(LottoPrize.getPrizeAmount(matchingCount.toInt())).isEqualTo(5000)
    }

    @DisplayName(value = "지난주 당첨 번호와 4개 일치 상금 50000원 winning")
    @ParameterizedTest
    @ValueSource(strings = ["4"])
    fun testThirdPrizeAmount(matchingCount: String) {
        Assertions.assertThat(LottoPrize.getPrizeAmount(matchingCount.toInt())).isEqualTo(50000)
    }

    @DisplayName(value = "지난주 당첨 번호와 5개 일치 상금 1500000원")
    @ParameterizedTest
    @ValueSource(strings = ["5"])
    fun testSecondPrizeAmount(matchingCount: String) {
        println(LottoPrize.getPrizeAmount(matchingCount.toInt()))
        Assertions.assertThat(LottoPrize.getPrizeAmount(matchingCount.toInt())).isEqualTo(1500000)
    }

    @DisplayName(value = "지난주 당첨 번호와 6개 일치 상금 2000000000원")
    @ParameterizedTest
    @ValueSource(strings = ["6"])
    fun testFirstPrizeAmount(matchingCount: String) {
        Assertions.assertThat(LottoPrize.getPrizeAmount(matchingCount.toInt())).isEqualTo(2000000000)
    }
}
