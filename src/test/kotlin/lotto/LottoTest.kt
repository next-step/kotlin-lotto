package lotto

import lotto.domain.LottoCalculator
import lotto.domain.LottoGenerator
import lotto.domain.LottoResult
import lotto.domain.LottoResultManager
import lotto.model.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `{given} 로또 총 구매금액 1만 원 {when} calculateLottoCount() {then} 10 반환`() {
        val totalPurchaseAmount = 10000
        val pricePerAmount = 1000
        val lottoCalculator = LottoCalculator()
        val purchaseCount = lottoCalculator.calculateLottoCount(totalPurchaseAmount, pricePerAmount)
        assertEquals(10, purchaseCount)
    }

    @Test
    fun `{given} 로또 총 10장 구매 {when} generateRandomLottoNumbers() {then} 10개 리스트 반환, 각 리스트 요소 6개`() {
        val purchaseCount = 10
        val lottoGenerator = LottoGenerator(purchaseCount)
        val list = lottoGenerator.generate()
        assertEquals(10, list.size)
    }

    @Test
    fun `{given} 당첨번호 1, 2, 3, 4, 5, 6 {when} 3개 이상 일치 {then} 당첨`() {
        val winningNumber = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val testLottoNumberThree = Lotto(listOf(1, 2, 3, 9, 9, 9))
        val testLottoNumberFour = Lotto(listOf(1, 2, 3, 4, 9, 9))
        val testLottoNumberFive = Lotto(listOf(1, 2, 3, 4, 5, 9))
        val testLottoNumberSix = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val lottoNumberList =
            listOf(
                testLottoNumberThree,
                testLottoNumberFour,
                testLottoNumberFive,
                testLottoNumberSix,
            )

        val lottoResultManager = LottoResultManager(winningNumber, lottoNumberList)
        val isWinResult = lottoResultManager.getResult()
        assert(isWinResult == LottoResult(mapOf(3 to 1, 4 to 1, 5 to 1, 6 to 1)))
    }

    @Test
    fun `{given} 로또 4장 {when} 1개 당첨 {then} 수익률 4 분의 1`() {
        val winningNumber = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lottoNumberList =
            listOf(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(100, 200, 300, 400, 500),
                listOf(100, 200, 300, 400, 500),
                listOf(100, 200, 300, 400, 500),
            ).map { Lotto(it) }
        val lottoResultManager = LottoResultManager(winningNumber, lottoNumberList)
        val winningRate = lottoResultManager.calculateWinningRate()
        assertEquals(0.25, winningRate)
    }
}
