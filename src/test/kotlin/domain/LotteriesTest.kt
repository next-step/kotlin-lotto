package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class LotteriesTest {
    @Test
    fun `입력 개수만큼 로또를 생성한다`() {
        val lotteries = Lotteries.of(5)

        assertThat(lotteries.lotteries).hasSize(5)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, -20])
    fun `입력 개수가 0보다 작은경우 생성되지 않는다`(wrongCount: Int) {
        assertThrows<IllegalArgumentException> {
            Lotteries.of(wrongCount)
        }
    }
}
