package lotto.domain

import lotto.domain.LottoStore.Companion.LOTTO_PRICE
import lotto.vo.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoCompanyTest {
    @Test
    @DisplayName("로또 회사는 당첨 번호를 입력 받는다")
    fun setWinnerNumberTest() {
        // given
        val comp = LottoCompany()
        val winnerNums = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        )
        // when
        comp.setWinnerNumber(winnerNums)
        // then
        assertThat(comp.winnerNumber).isEqualTo(WinnerLotto(winnerNums))
    }

    @Test
    @DisplayName("로또 회사는 당첨 번호를 구입한 로또와 비교하여 6match 당첨로또를 찾는다")
    fun findSixMatchWinnerLottoTest() {
        // given
        val manualLottoNumber = setOf(1, 2, 3, 4, 5, 6)
        val soldLotto = LottoBasket(listOf(Lotto.of(manualLottoNumber)))

        val comp = LottoCompany()
        val winnerNums = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        )

        // when
        comp.setWinnerNumber(winnerNums)
        val winners = comp.findWinners(soldLotto).winners
        // then
        assertThat(winners).containsExactly(LottoPrize.SIX_MATCH)
    }

    @Test
    @DisplayName("로또 회사는 당첨 번호를 구입한 로또와 비교하여 5match 당첨로또를 찾는다")
    fun findFiveMatchWinnerLottoTest() {
        // given
        val manualLottoNumber = setOf(1, 2, 3, 4, 5, 6)
        val soldLotto = LottoBasket(listOf(Lotto.of(manualLottoNumber)))

        val comp = LottoCompany()
        val winnerNums = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(7)
        )

        // when
        comp.setWinnerNumber(winnerNums)
        val winners = comp.findWinners(soldLotto).winners
        // then
        assertThat(winners).containsExactly(LottoPrize.FIVE_MATCH)
    }

    @Test
    @DisplayName("로또 회사는 당첨 번호를 구입한 로또와 비교하여 4match 당첨로또를 찾는다")
    fun findFourMatchWinnerLottoTest() {
        // given
        val manualLottoNumber = setOf(1, 2, 3, 4, 5, 6)
        val soldLotto = LottoBasket(listOf(Lotto.of(manualLottoNumber)))

        val comp = LottoCompany()
        val winnerNums = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(7),
            LottoNumber.from(8)
        )

        // when
        comp.setWinnerNumber(winnerNums)
        val winners = comp.findWinners(soldLotto).winners
        // then
        assertThat(winners).containsExactly(LottoPrize.FOUR_MATCH)
    }

    @Test
    @DisplayName("로또 회사는 당첨 번호를 구입한 로또와 비교하여 3match 당첨로또를 찾는다")
    fun findThreeMatchWinnerLottoTest() {
        // given
        val manualLottoNumber = setOf(1, 2, 3, 4, 5, 6)
        val soldLotto = LottoBasket(listOf(Lotto.of(manualLottoNumber)))

        val comp = LottoCompany()
        val winnerNums = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(7),
            LottoNumber.from(8),
            LottoNumber.from(9)
        )

        // when
        comp.setWinnerNumber(winnerNums)
        val winners = comp.findWinners(soldLotto).winners
        // then
        assertThat(winners).containsExactly(LottoPrize.THREE_MATCH)
    }

    @Test
    @DisplayName("로또 회사는 당첨 번호를 구입한 로또와 비교하여 꽝을 찾는다")
    fun findNotMatchWinnerLottoTest() {
        // given
        val manualLottoNumber = setOf(1, 2, 3, 4, 5, 6)
        val soldLotto = LottoBasket(listOf(Lotto.of(manualLottoNumber)))

        val comp = LottoCompany()
        val winnerNums = listOf(
            LottoNumber.from(7),
            LottoNumber.from(8),
            LottoNumber.from(9),
            LottoNumber.from(10),
            LottoNumber.from(11),
            LottoNumber.from(12)
        )

        // when
        comp.setWinnerNumber(winnerNums)
        val winners = comp.findWinners(soldLotto).winners
        // then
        assertThat(winners).containsExactly(LottoPrize.NOT_MATCH)
    }

    @Test
    @DisplayName("로또 회사는 당첨 번호를 구입한 로또와 비교하여 2개 당첨로또를 찾는다")
    fun findDualWinnerLottoTest() {
        // given
        val manualLottoNumber1 = setOf(1, 2, 3, 4, 5, 6)
        val manualLottoNumber2 = setOf(1, 2, 3, 4, 5, 7)
        val soldLotto = LottoBasket(
            listOf(
                Lotto.of(manualLottoNumber1), Lotto.of(manualLottoNumber2)
            )
        )

        val comp = LottoCompany()
        val winnerNums = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        )

        // when
        comp.setWinnerNumber(winnerNums)
        val winners = comp.findWinners(soldLotto).winners
        // then
        assertThat(winners).contains(LottoPrize.SIX_MATCH, LottoPrize.FIVE_MATCH)
    }

    @Test
    @DisplayName("로또 회사는 당첨 번호를 구입한 로또와 비교하여 3개 당첨로또를 찾는다")
    fun findTrippleWinnerLottoTest() {
        // given
        val manualLottoNumber1 = setOf(1, 2, 3, 4, 5, 6)
        val manualLottoNumber2 = setOf(1, 2, 3, 4, 5, 7)
        val manualLottoNumber3 = setOf(1, 2, 3, 4, 7, 8)
        val soldLotto = LottoBasket(
            listOf(
                Lotto.of(manualLottoNumber1), Lotto.of(manualLottoNumber2), Lotto.of(manualLottoNumber3)
            )
        )

        val comp = LottoCompany()
        val winnerNums = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        )

        // when
        comp.setWinnerNumber(winnerNums)
        val winners = comp.findWinners(soldLotto).winners
        // then
        assertThat(winners).contains(LottoPrize.SIX_MATCH, LottoPrize.FIVE_MATCH, LottoPrize.FOUR_MATCH)
    }

    @Test
    @DisplayName("로또 회사는 당첨 번호를 구입한 로또와 비교하여 4개 당첨로또를 찾는다")
    fun findQuadWinnerLottoTest() {
        // given
        val manualLottoNumber1 = setOf(1, 2, 3, 4, 5, 6)
        val manualLottoNumber2 = setOf(1, 2, 3, 4, 5, 7)
        val manualLottoNumber3 = setOf(1, 2, 3, 4, 7, 8)
        val manualLottoNumber4 = setOf(1, 2, 3, 7, 8, 9)
        val soldLotto = LottoBasket(
            listOf(
                Lotto.of(manualLottoNumber1),
                Lotto.of(manualLottoNumber2),
                Lotto.of(manualLottoNumber3),
                Lotto.of(manualLottoNumber4)
            )
        )

        val comp = LottoCompany()
        val winnerNums = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        )

        // when
        comp.setWinnerNumber(winnerNums)
        val winners = comp.findWinners(soldLotto).winners
        // then
        assertThat(winners).contains(
            LottoPrize.SIX_MATCH,
            LottoPrize.FIVE_MATCH,
            LottoPrize.FOUR_MATCH,
            LottoPrize.THREE_MATCH
        )
    }

    @Test
    @DisplayName("로또 회사는 당첨 발표 후 6match 로또의 수익율을 계산한다")
    fun calculateEarningRateSixMatchLottoTest() {
        // given
        val manualLottoNumber = setOf(1, 2, 3, 4, 5, 6)
        val soldLotto = LottoBasket(listOf(Lotto.of(manualLottoNumber)))

        val comp = LottoCompany()
        val winnerNums = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        )

        // when
        comp.setWinnerNumber(winnerNums)
        val winners = comp.findWinners(soldLotto)
        val earningRatio = comp.calculateEarningRate(winners, Money(soldLotto.lottos.size * LOTTO_PRICE.money))
        // then
        assertThat(earningRatio).isEqualTo(2000000.0)
    }

    @Test
    @DisplayName("로또 회사는 당첨 발표 후 5match 로또의 수익율을 계산한다")
    fun calculateEarningRateFiveMatchLottoTest() {
        // given
        val manualLottoNumber = setOf(1, 2, 3, 4, 5, 7)
        val soldLotto = LottoBasket(listOf(Lotto.of(manualLottoNumber)))

        val comp = LottoCompany()
        val winnerNums = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        )

        // when
        comp.setWinnerNumber(winnerNums)
        val winners = comp.findWinners(soldLotto)
        val earningRatio = comp.calculateEarningRate(winners, Money(soldLotto.lottos.size * LOTTO_PRICE.money))
        // then
        assertThat(earningRatio).isEqualTo(1500.0)
    }

    @Test
    @DisplayName("로또 회사는 당첨 발표 후 4match 로또의 수익율을 계산한다")
    fun calculateEarningRateFourMatchLottoTest() {
        // given
        val manualLottoNumber = setOf(1, 2, 3, 4, 7, 8)
        val soldLotto = LottoBasket(listOf(Lotto.of(manualLottoNumber)))

        val comp = LottoCompany()
        val winnerNums = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        )

        // when
        comp.setWinnerNumber(winnerNums)
        val winners = comp.findWinners(soldLotto)
        val earningRatio = comp.calculateEarningRate(winners, Money(soldLotto.lottos.size * LOTTO_PRICE.money))
        // then
        assertThat(earningRatio).isEqualTo(50.0)
    }

    @Test
    @DisplayName("로또 회사는 당첨 발표 후 3match 로또의 수익율을 계산한다")
    fun calculateEarningRateThreeMatchLottoTest() {
        // given
        val manualLottoNumber = setOf(1, 2, 3, 7, 8, 9)
        val soldLotto = LottoBasket(listOf(Lotto.of(manualLottoNumber)))

        val comp = LottoCompany()
        val winnerNums = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        )

        // when
        comp.setWinnerNumber(winnerNums)
        val winners = comp.findWinners(soldLotto)
        val earningRatio = comp.calculateEarningRate(winners, Money(soldLotto.lottos.size * LOTTO_PRICE.money))
        // then
        assertThat(earningRatio).isEqualTo(5.0)
    }

    @Test
    @DisplayName("로또 회사는 당첨 발표 후 3match 로또의 수익율을 소수점 둘째자리까지 계산한다")
    fun calculateEarningRateRoundOffLottoTest() {
        // given
        val manualLottoNumber1 = setOf(1, 2, 3, 14, 15, 16)
        val manualLottoNumber2 = setOf(11, 22, 33, 44, 15, 17)
        val manualLottoNumber3 = setOf(11, 22, 33, 44, 17, 18)
        val manualLottoNumber4 = setOf(11, 22, 33, 44, 18, 19)
        val manualLottoNumber5 = setOf(11, 22, 33, 44, 18, 19)
        val manualLottoNumber6 = setOf(11, 22, 33, 44, 18, 19)
        val soldLotto = LottoBasket(
            listOf(
                Lotto.of(manualLottoNumber1),
                Lotto.of(manualLottoNumber2),
                Lotto.of(manualLottoNumber3),
                Lotto.of(manualLottoNumber4),
                Lotto.of(manualLottoNumber5),
                Lotto.of(manualLottoNumber6)
            )
        )

        val comp = LottoCompany()
        val winnerNums = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        )
        // when
        comp.setWinnerNumber(winnerNums)
        val winners = comp.findWinners(soldLotto)
        val earningRatio = comp.calculateEarningRate(winners, Money(soldLotto.lottos.size * LOTTO_PRICE.money))
        // then
        assertThat(earningRatio).isEqualTo(0.83)
    }
}
