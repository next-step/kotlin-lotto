package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.matchers.shouldBe
import lotto.domain.enums.LottoCompensationStrategy
import org.junit.jupiter.api.Test

class LottoUserTest {
    @Test
    fun `사용자는 구매금액을 가지고 있는다`() {
        val lottoPurchaseAmount = LottoPurchaseAmount(1000)

        val lottoUser = LottoUser(lottoPurchaseAmount)

        lottoUser.lottoPurchaseAmount shouldBe lottoPurchaseAmount
    }

    @Test
    fun `사용자는 지불한 금액만큼의 로또를 가지고 있는다`() {
        val lottoPurchaseAmount = LottoPurchaseAmount(1000)

        val lottoUser = LottoUser(lottoPurchaseAmount)

        lottoUser.lotteries.size shouldBe lottoPurchaseAmount.calculateLottoCount()
    }

    @Test
    fun `사용자는 로또별 당첨금액을 체크할 수 있다`() {
        val lottoPurchaseAmount = LottoPurchaseAmount(10000)
        val lottoUser = LottoUser(lottoPurchaseAmount)
        val inputs = List(6) { it }.toSet()

        val correctNumbers = CorrectNumbers(inputs)

        lottoUser.checkLotteries(correctNumbers)

        lottoUser.lotteries.forEach {
            shouldNotThrowAny {
                it.markedCorrectCount
            }
        }
    }

    @Test
    fun `사용자는 당첨금액을 알고 있다`() {
        val lottoPurchaseAmount = LottoPurchaseAmount(10000)
        val lottoUser = LottoUser(lottoPurchaseAmount) {
            (1..6).toSet()
        }

        val inputs = (1..6).toSet()
        val correctNumbers = CorrectNumbers(inputs)

        lottoUser.checkLotteries(correctNumbers)

        lottoUser.compensation shouldBe LottoCompensationStrategy.`6개`.compensation * lottoPurchaseAmount.calculateLottoCount()
    }
}
