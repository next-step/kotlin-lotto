package lotto

import io.kotest.matchers.types.shouldBeInstanceOf
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLotto
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoStore
import lotto.sixFortyFiveNumberLotto.SixFortyFiveNumber
import lotto.sixFortyFiveNumberLotto.SixFortyFiveWinningLotto
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LottoStoreTest {
    @Test
    fun `구매 개수 만큼 로또를 생성합니다`() {
        val purchaseCount = 3
        val lottoStore = SixFortyFiveLottoStore()

        val lottoList = lottoStore.purchase(purchaseCount)

        lottoList.forEach { lotto -> lotto.shouldBeInstanceOf<SixFortyFiveLotto>() }
    }

    @Test
    fun `로또의 당첨 여부를 계산합니다`() {
        val numbers = listOf(1, 2, 3, 7, 8, 9).map { SixFortyFiveNumber(it) }
        val winningNumber = listOf(1, 2, 3, 4, 5, 6).map { SixFortyFiveNumber(it) }
        val winningLotto = SixFortyFiveWinningLotto(SixFortyFiveLotto(winningNumber))

        val winningResult = SixFortyFiveLotto(numbers).checkWinning(winningLotto)

        Assertions.assertEquals(winningResult.countOfMatch, 3)
        Assertions.assertEquals(winningResult.isMatchedBonus, false)
    }

    @Test
    fun `보너스 번호를 포함하여 로또의 당첨 여부를 계산합니다`() {
        val numbers = listOf(1, 2, 3, 7, 8, 9).map { SixFortyFiveNumber(it) }
        val winningNumber = listOf(1, 2, 3, 4, 5, 6).map { SixFortyFiveNumber(it) }
        val bonusNumber = SixFortyFiveNumber(7)
        val winningLotto = SixFortyFiveWinningLotto(SixFortyFiveLotto(winningNumber), bonusNumber)

        val winningResult = SixFortyFiveLotto(numbers).checkWinning(winningLotto)

        Assertions.assertEquals(winningResult.countOfMatch, 4)
        Assertions.assertEquals(winningResult.isMatchedBonus, true)
    }
}
