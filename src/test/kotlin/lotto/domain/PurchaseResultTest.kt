package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class PurchaseResultTest {

    @Test
    @DisplayName("숫자가 아닌 문자를 입력 받았을 경우 IllegalArgumentException 오류")
    fun `IllegalArgumentException error when non-numeric characters are entered`() {
        val purchaseAmount = "14aaaa"
        assertThrows<IllegalArgumentException> { PurchaseResult(purchaseAmount) }
    }

    @Test
    @DisplayName("최소 구매 비용이 1000이고 최소 구매 비용보다 낮은 값을 입력 받았을 경우 IllegalArgumentException 오류")
    fun `IllegalArgumentException error when minimum purchase cost is 1000 and a value lower than minimum purchase cost is entered`() {
        val purchaseAmount = "500"
        assertThrows<IllegalArgumentException> { PurchaseResult(purchaseAmount) }
    }

    @Test
    @DisplayName("최소 구매 비용이 1000이고 입력 값이 13500일 경우 잔돈은 500을 반환")
    fun `If the minimum purchase cost is 1000 and the input value is 13500, the change returns 500`() {
        val purchaseAmount = "13500"
        val purchaseResult = PurchaseResult(purchaseAmount)
        Assertions.assertThat(purchaseResult.change).isEqualTo(500)
    }

    @Test
    @DisplayName("최소 구매 비용이 1000이고 입력 값이 13500일 경우 게임 횟수 13을 반환")
    fun `Return 13 games if minimum purchase cost is 1000 and input value is 13500`() {
        val purchaseAmount = "13500"
        val purchaseResult = PurchaseResult(purchaseAmount)
        Assertions.assertThat(purchaseResult.numberOfGames).isEqualTo(13)
    }
}
