package lotto

import lotto.domain.*
import lotto.model.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `{given} 로또 총 구매금액 1만 원 {when} LottoCalculator calculateLottoCount() {then} 10 반환`() {
        val totalPurchaseAmount = 10000
        val pricePerAmount = 1000
        val lottoCalculator = LottoCalculator(totalPurchaseAmount, pricePerAmount)
        val purchaseCount = lottoCalculator.calculateLottoCount()
        assertEquals(10, purchaseCount)
    }

    @Test
    fun `{given} 로또 총 10장 구매 {when} LottoGenerator generate() {then} 10개 리스트 반환`() {
        val purchaseCount = 10
        val lottoGenerator = LottoGenerator(purchaseCount)
        val list = lottoGenerator.generate()
        assertEquals(10, list.size)
    }

    @Test
    fun `{given} 당첨번호와 일치하는 숫자 3개, 4개, 5개, 6개 있을 때 {when} LottoResultManager getResult() {then} 각 등수당 1개씩 당첨`() {
        val winningNumber = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val threeMatchingNumber = listOf(1, 2, 3, 9, 9, 9)
        val fourMatchingNumber = listOf(1, 2, 3, 4, 9, 9)
        val fiveMatchingNumber = listOf(1, 2, 3, 4, 5, 9)
        val sixMatchingNumber = listOf(1, 2, 3, 4, 5, 6)

        val lottoNumberList =
            listOf(
                threeMatchingNumber,
                fourMatchingNumber,
                fiveMatchingNumber,
                sixMatchingNumber,
            ).map(::Lotto)

        val lottoResultStore = LottoResultStore(winningNumber, lottoNumberList)
        val actualResult = lottoResultStore.getResult()
        val everyPlaceHasOneWinningExpected = LottoResult(
            mapOf(
                LottoWinPlace.FOURTH to 1,
                LottoWinPlace.THIRD to 1,
                LottoWinPlace.SECOND to 1,
                LottoWinPlace.FIRST to 1,
            ),
        )
        assertEquals(everyPlaceHasOneWinningExpected, actualResult)
    }

    @Test
    fun `{given} 로또 4장 이고 1개 당첨인 경우 {when} LottoResultStore calculateWinningRateFromResult() {then} 수익률 4 분의 1`() {
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val lottoNumberList =
            listOf(
                winningNumber,
                listOf(100, 200, 300, 400, 500),
                listOf(100, 200, 300, 400, 500),
                listOf(100, 200, 300, 400, 500),
            ).map { Lotto(it) }
        val lottoResultStore = LottoResultStore(Lotto(winningNumber), lottoNumberList)
        val fakeCalculator = LottoCalculator(lottoNumberList.size, 1000)
        val winningRate = fakeCalculator.calculateWinningRateFromResult(lottoResultStore.getResult().getSum())

        assertEquals(0.25, winningRate)
    }
}
