package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.collections.shouldHaveSize

class LottoBuyHelperTest : AnnotationSpec() {

    @Test
    fun `로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다`() {
        val lotteryGroup = LottoBuyHelper.buyLotto(14000)
        lotteryGroup.lotteries shouldHaveSize 14
        lotteryGroup.lotteries.shouldForAll {
            it.lottery shouldHaveSize 6
        }
    }

    @Test
    fun `1000원 이상의 경우만 구매할 수 있다 1000원 이하 0 음수포함 구매 불가능`() {
        shouldThrow<IllegalArgumentException> {
            LottoBuyHelper.buyLotto(0)
        }
        shouldThrow<IllegalArgumentException> {
            LottoBuyHelper.buyLotto(900)
        }
        shouldThrow<IllegalArgumentException> {
            LottoBuyHelper.buyLotto(-1500)
        }
    }
}
