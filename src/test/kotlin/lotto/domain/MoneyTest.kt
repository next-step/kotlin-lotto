package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class MoneyTest {

    @Test
    fun `나누기 결과를 반환한다`() {
        val money = Money.from(1000)
        val other = Money.from(100)

        money.divide(other) shouldBe 10.toBigDecimal()
    }

    @Test
    fun `크기를 비교한다`() {
        val money = Money.from(1000)
        val other = Money.from(100)

        (money > other) shouldBe true
    }

    @Test
    fun `나머지를 반환한다`() {
        val money = Money.from(1000)
        val other = Money.from(100)

        (money % other) shouldBe 0.toBigDecimal()
    }
}
