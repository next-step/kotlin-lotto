package service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CalculateServiceTest {
    @Test
    @DisplayName("수익률을 반환한다")
    fun `getEarningRate`() {
        val data = listOf(Pair(4, 1), Pair(5, 1))
        val calculateService = CalculateService(data)
        assertThat(calculateService.getEarningRate(1_000)).isGreaterThan(0.0)
    }
    @Test
    @DisplayName("로또 당첨 수익 목록 반환한다")
    fun `prizeStatList`() {
        val data = listOf(Pair(4, 1), Pair(5, 1))
        val calculateService = CalculateService(data)
        assertThat(calculateService.prizeStatList).isNotEmpty
    }
}
