package lotto.domain

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.doubles.shouldBeLessThan
import io.kotest.matchers.types.shouldBeTypeOf

class LottoMachineTest : AnnotationSpec() {

    @Test
    fun `전부 자동으로 구매를 해본다`() {
        val lotteryGroup = LottoMachine.buyLottery(14000, LotteryGroup())
        if (lotteryGroup != null) {
            lotteryGroup.lotteries shouldHaveSize 14
            lotteryGroup.lotteries.shouldForAll {
                it.lottery shouldHaveSize 6
            }
        }
    }
    @Test
    fun `전부 수동으로 구매를 해본다`() {
        val lotteries = mutableListOf<Lottery>()
        repeat(3) {
            lotteries.add(Lottery(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }))
        }
        val lotteryGroup = LottoMachine.buyLottery(3000, LotteryGroup(lotteries))
        if (lotteryGroup != null) {
            lotteryGroup.lotteries shouldHaveSize 3
        }
    }

    @Test
    fun `자동과 수동을 섞어서 구매를 해본다`() {
        val lotteries = mutableListOf<Lottery>()
        repeat(2) {
            lotteries.add(Lottery(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }))
        }
        val lotteryGroup = LottoMachine.buyLottery(3000, LotteryGroup(lotteries))
        if (lotteryGroup != null) {
            lotteryGroup.lotteries shouldHaveSize 3
        }
    }

    @Test
    fun `당첨결과를 설정할 수 있어야한다`() {
        LottoMachine.buyLottery(14000, LotteryGroup())
        val winNumber = Lottery(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val bonusNumber = LottoNumber(7)
        LottoMachine.setWinLotto(winNumber, bonusNumber)
        LottoMachine.generateRanking()
        LottoMachine.rateOfReturn shouldBeLessThan 1.0
    }

    @Test
    fun `당첨금을 계산해본다`() {
        LottoMachine.buyLottery(14000, LotteryGroup())
        val winNumber = Lottery(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val bonusNumber = LottoNumber(7)
        LottoMachine.setWinLotto(winNumber, bonusNumber)
        val ranking = LottoMachine.generateRanking()
        ranking.totalWinAmount.shouldBeTypeOf<Int>()
    }
}
