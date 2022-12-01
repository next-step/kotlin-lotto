package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class ManualPurchaseResultTest {

    @Test
    @DisplayName("수동 게임 횟수의 입력이 공백 열이 들어올 경우 IllegalArgumentException 오류")
    fun `IllegalArgumentException error if input of manual game count is blank`() {
        val number = "  "
        assertThrows<IllegalArgumentException> { ManualPurchaseResult(number) }
    }

    @Test
    @DisplayName("수동 게임 횟수의 입력이 숫자가 아닌 문자가 들어올 경우 IllegalArgumentException 오류")
    fun `IllegalArgumentException error if non-numeric characters are entered for manual game count`() {
        val number = "aaaaa"
        assertThrows<IllegalArgumentException> { ManualPurchaseResult(number) }
    }

    @Test
    @DisplayName("수동 게임 횟수의 입력이 -1이 들어올 경우 IllegalArgumentException 오류")
    fun `IllegalArgumentException error if input of number of manual games is -1`() {
        val number = "-1"
        assertThrows<IllegalArgumentException> { ManualPurchaseResult(number) }
    }

    @Test
    @DisplayName("수동 게임 횟수의 입력이 10이 들어올 경우 수동 게임 횟수는 10")
    fun `If the input of the number of manual games is 10, the number of manual games is 10`() {
        val number = "10"
        val purchaseResult = ManualPurchaseResult(number)
        assertThat(purchaseResult.numberOfGames).isEqualTo(10)
    }
}
