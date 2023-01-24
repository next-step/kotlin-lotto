package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoAmountTest {
    @Test
    @DisplayName("로또를 구매하려는 총 수량이 수동으로 구매하려는 수보다 크거나 같다")
    fun `sut totalAmount is equal to or more than manualAmount`() {
        // Arrange
        val totalAmount = 10
        val manualAmount = 10

        // Act
        val actual = LottoAmount(
            totalAmount = totalAmount, manualAmount = manualAmount
        )

        // Assert
        assertThat(actual.totalAmount).isEqualTo(totalAmount)
        assertThat(actual.manualAmount).isEqualTo(manualAmount)
        assertThat(actual.autoAmount).isEqualTo(totalAmount - manualAmount)
    }

    @Test
    @DisplayName("로또를 구매하려는 총 수량이 수동으로 구매하려는 수보다 작으면 에러를 뱉는다")
    fun `sut manualAmount is equal to or more than totalAmount`() {
        // Arrange
        val totalAmount = 10
        val manualAmount = 12

        // Act & Assert
        val actual = assertThrows<IllegalArgumentException> {
            LottoAmount(
                totalAmount = totalAmount, manualAmount = manualAmount
            )
        }

        // Assert
        assertThat(actual.message).isEqualTo("수동 구매 수는 전체 구매 수 보다 작아야합니다.")
    }
}
