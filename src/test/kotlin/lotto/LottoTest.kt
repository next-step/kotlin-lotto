package lotto

import lotto.domain.LottoCalculator
import lotto.domain.LottoGenerator
import lotto.domain.LottoResult
import lotto.domain.LottoResultManager
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
    fun `{given} 당첨번호 1, 2, 3, 4, 5, 6 {when} 3개 미만 일치 {then} 당첨 아님`() {
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val testLottoNumber = listOf(1, 2, 3, 9, 9, 9)
        val lottoNumberList = listOf(testLottoNumber)
        val lottoResultManager = LottoResultManager(winningNumber, lottoNumberList)
        val isWinResult = lottoResultManager.isWinResult()
        assert(isWinResult is LottoResult.Failure) // kotlin Result 클래스 활용 ?
    }

    @Test
    fun `{given} 당첨번호 1, 2, 3, 4, 5, 6 {when} 3개 이상 일치 {then} 당첨`() {
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)

        val testLottoNumberThree = listOf(1, 2, 3, 9, 9, 9)
        val testLottoNumberFour = listOf(1, 2, 3, 4, 9, 9)
        val testLottoNumberFive = listOf(1, 2, 3, 4, 5, 9)
        val testLottoNumberSix = listOf(1, 2, 3, 4, 5, 6)

        val lottoNumberList = listOf(
            testLottoNumberThree,
            testLottoNumberFour,
            testLottoNumberFive,
            testLottoNumberSix
        )

        val lottoResultManager = LottoResultManager(winningNumber, lottoNumberList)
        val isWinResult = lottoResultManager.isWinResult()
        assert(isWinResult == LottoResult.Success(1, 1, 1, 1)) // 일치한 개수를 데이터로 반환
    }

    @Test
    fun `{given} 로또 4장 {when} 1개 당첨 {then} 수익률 4 분의 1`() {
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val lottoNumberList = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(100, 200, 300, 400, 500),
            listOf(100, 200, 300, 400, 500),
            listOf(100, 200, 300, 400, 500),
        )
        val lottoResultManager = LottoResultManager(winningNumber, lottoNumberList)
        val winningRate = lottoResultManager.calculateWinningRate()
        assertEquals(0.25, winningRate)
    }
}