package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.collections.shouldHaveSize
import java.lang.IllegalStateException

class LottoBuyHelperTest : AnnotationSpec() {

    @Test
    fun `로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다`() {
        val lotteryGroup = LottoBuyHelper.buyLottoByMachine(14000)
        lotteryGroup.lotteries shouldHaveSize 14
        lotteryGroup.lotteries.shouldForAll {
            it.lottery shouldHaveSize 6
        }
    }

    @Test
    fun `1000원 이상의 경우만 구매할 수 있다 1000원 이하 0 음수포함 구매 불가능`() {
        shouldThrow<IllegalArgumentException> {
            LottoBuyHelper.buyLottoByMachine(0)
        }
        shouldThrow<IllegalArgumentException> {
            LottoBuyHelper.buyLottoByMachine(900)
        }
        shouldThrow<IllegalArgumentException> {
            LottoBuyHelper.buyLottoByMachine(-1500)
        }
    }
    @Test
    fun `구매할 금액으로 살 수 있는 로또의 수보다 수동으로 구매한 로또의 갯수가 많은 경우`() {
        val lotteries = mutableListOf<Lottery>()
        repeat(3) {
            lotteries.add(Lottery(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }))
        }
        shouldThrow<IllegalStateException> {
            LottoBuyHelper.buyLottoByMachine(2000, LotteryGroup(lotteries))
        }
    }
}
