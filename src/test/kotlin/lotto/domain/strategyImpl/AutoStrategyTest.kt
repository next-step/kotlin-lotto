package lotto.domain.strategyImpl

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AutoStrategyTest {

    @Test
    fun `로또 추첨을 하면 6개의 무작위 숫자가 뽑혀야 한다`() {
        val autoStrategy = AutoStrategy()
        val draw = autoStrategy.draw()
        assertEquals(LOTTO_SIZE, draw.lotto.size)
    }

    companion object {
        private const val LOTTO_SIZE = 6
    }
}
