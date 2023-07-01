package lotto

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLotto
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoCount
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoPurchase
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoPurchasePrice
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoPurchases
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoStore
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoType
import lotto.sixFortyFiveNumberLotto.SixFortyFiveNumber
import lotto.sixFortyFiveNumberLotto.SixFortyFiveWinningLotto
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LottoStoreTest {
    @Test
    fun `입력받은 숫자들을 통해 수동 로또를 생성합니다`() {
        val lottoStore = SixFortyFiveLottoStore()
        val manualLottoNumbers = listOf(
            SixFortyFiveNumber(1),
            SixFortyFiveNumber(2),
            SixFortyFiveNumber(3),
            SixFortyFiveNumber(4),
            SixFortyFiveNumber(5),
            SixFortyFiveNumber(6),
        )

        val manualLottoPurchase = SixFortyFiveLottoPurchase.ofManual(manualLottoNumbers)
        val manualLottoPurchases = SixFortyFiveLottoPurchases(manualLottoPurchase)
        val lottoes = lottoStore.purchase(manualLottoPurchases)

        with(lottoes.getList()) {
            forEach { lotto -> lotto.shouldBeInstanceOf<SixFortyFiveLotto>() }
            count { it.type == SixFortyFiveLottoType.MANUAL } shouldBe 1
        }
    }

    @Test
    fun `전체 구입 금액에서 수동 로또 수를 제외한 만큼 자동 로또를 생성합니다`() {
        val lottoStore = SixFortyFiveLottoStore()
        val purchasePrice = SixFortyFiveLottoPurchasePrice(10000)
        val purchaseLottoCount = lottoStore.getPurchaseCountByPrice(purchasePrice)
        val manualLottoCount = SixFortyFiveLottoCount(3)
        val manualLottoPurchases = SixFortyFiveLottoPurchases(
            (1..manualLottoCount.value).map {
                SixFortyFiveLottoPurchase(
                    SixFortyFiveLottoType.MANUAL,
                    getNumbers(),
                )
            },
        )

        val mergedLottoPurchases = SixFortyFiveLottoPurchases.ofAutoFromManual(purchaseLottoCount, manualLottoPurchases)
        val lottoes = lottoStore.purchase(mergedLottoPurchases)

        with(lottoes.getList()) {
            forEach { lotto -> lotto.shouldBeInstanceOf<SixFortyFiveLotto>() }
            count { it.type == SixFortyFiveLottoType.AUTO } shouldBe purchaseLottoCount.value - manualLottoCount.value
        }
    }

    @Test
    fun `로또의 당첨 여부를 계산합니다`() {
        val lotto = SixFortyFiveLotto(listOf(1, 2, 3, 7, 8, 9).map { SixFortyFiveNumber(it) })
        val winningNumber = SixFortyFiveLotto(listOf(1, 2, 3, 4, 5, 6).map { SixFortyFiveNumber(it) })
        val winningLotto = SixFortyFiveWinningLotto(winningNumber)

        val winningResult = winningLotto.matchCount(lotto.numbers)

        Assertions.assertEquals(winningResult.countOfMatch, 3)
        Assertions.assertEquals(winningResult.isMatchedBonus, false)
    }

    @Test
    fun `보너스 번호를 포함하여 로또의 당첨 여부를 계산합니다`() {
        val lotto = SixFortyFiveLotto(listOf(1, 2, 3, 7, 8, 9).map { SixFortyFiveNumber(it) })
        val winningNumber = SixFortyFiveLotto(listOf(1, 2, 3, 4, 5, 6).map { SixFortyFiveNumber(it) })
        val bonusNumber = SixFortyFiveNumber(7)
        val winningLotto = SixFortyFiveWinningLotto(winningNumber, bonusNumber)

        val winningResult = winningLotto.matchCount(lotto.numbers)

        Assertions.assertEquals(winningResult.countOfMatch, 3)
        Assertions.assertEquals(winningResult.isMatchedBonus, true)
    }

    private fun getNumbers(): List<SixFortyFiveNumber> {
        return listOf(
            SixFortyFiveNumber(1),
            SixFortyFiveNumber(2),
            SixFortyFiveNumber(3),
            SixFortyFiveNumber(4),
            SixFortyFiveNumber(5),
            SixFortyFiveNumber(6),
        )
    }
}
