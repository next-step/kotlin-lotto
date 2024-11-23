package lotto.statistics

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ProfitTest {
    private lateinit var profit: Profit

    @BeforeEach
    fun setup() {
        profit = Profit(winningAmount = 5_000, purchaseAmount = 14_000)
    }

    @Test
    fun `당첨금액과 구매급액으로 수익률을 계산한다`() {
        profit.yield() shouldBe 0.35
    }
}
