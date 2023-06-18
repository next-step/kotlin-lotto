package lotto

import io.kotest.matchers.types.shouldBeInstanceOf
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLotto
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoNumber
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoStore
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoWinningNumber
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
        val numbers = SixFortyFiveLottoNumber(listOf(1, 2, 3, 7, 8, 9))
        val winningNumber = SixFortyFiveLottoWinningNumber(listOf(1, 2, 3, 4, 5, 6))

        val winningResult = SixFortyFiveLotto(numbers).checkWinning(winningNumber)

        Assertions.assertEquals(winningResult.countOfMatch, 3)
        Assertions.assertEquals(winningResult.isMatchedBonus, false)
    }

    @Test
    fun `보너스 번호를 포함하여 로또의 당첨 여부를 계산합니다`() {
        val numbers = SixFortyFiveLottoNumber(listOf(1, 2, 3, 7, 8, 9))
        val winningNumber = SixFortyFiveLottoWinningNumber(listOf(1, 2, 3, 4, 5, 6))
        winningNumber.bonusNumber = 7

        val winningResult = SixFortyFiveLotto(numbers).checkWinning(winningNumber)

        Assertions.assertEquals(winningResult.countOfMatch, 4)
        Assertions.assertEquals(winningResult.isMatchedBonus, true)
    }
}
