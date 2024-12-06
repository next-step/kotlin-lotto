package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal

class LottoCalculatorTest {
    @Test
    fun `총 구매 금액으로부터 구매한 로또의 총 개수를 계산한다`() {
        val totalLottoCount =
            LottoCalculator.calculateLottoCount(
                totalPurchaseAmount = BigDecimal(10000),
                pricePerAmount = BigDecimal(1000),
            )
        assertEquals(10, totalLottoCount)
    }

    @Test
    fun `총 구매 금액을 바탕으로 총 수익률을 계산한다`() {
        val totalProfitRate =
            LottoCalculator.calculateProfitRate(
                totalProfit = BigDecimal(10000),
                totalPurchaseAmount = BigDecimal(10000),
            )
        assertTrue(totalProfitRate == BigDecimal("1.00"))
    }

    @Test
    fun `{given} 단위 로또 가격이 0원일 경우 {when} calculateLottCount()  {then} IllegalArgumentException 발생`() {
        assertThrows<IllegalArgumentException> {
            LottoCalculator.calculateLottoCount(
                totalPurchaseAmount = BigDecimal(10000),
                pricePerAmount = BigDecimal.ZERO,
            )
        }
    }

    @Test
    fun `{given} 단위 로또 가격보다 총 구매 가격이 작은 경우 {when} calculateLottCount()  {then} IllegalArgumentException 발생`() {
        assertThrows<IllegalArgumentException> {
            LottoCalculator.calculateLottoCount(
                totalPurchaseAmount = BigDecimal(100),
                pricePerAmount = BigDecimal(10000),
            )
        }
    }

    @Test
    fun `{given} 총 구매 금액이 0원일 경우 {when} calculateTotalProfit()  {then} IllegalArgumentException 발생`() {
        assertThrows<IllegalArgumentException> {
            LottoCalculator.calculateProfitRate(
                totalProfit = BigDecimal(10000),
                totalPurchaseAmount = BigDecimal.ZERO,
            )
        }
    }
}
