package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class PrizeTest {
    @Test
    internal fun `로또 당첨 금액`() {
        Prize.FIRST.money shouldBe 2_000_000_000
        Prize.SECOND.money shouldBe 1_500_000
        Prize.THIRD.money shouldBe 50_000
        Prize.FOURTH.money shouldBe 5_000
        Prize.NONE.money shouldBe 0
    }

    @Test
    internal fun `일치하는 개수에 맞는 등수`() {
        Prize.from(6) shouldBe Prize.FIRST
        Prize.from(5) shouldBe Prize.SECOND
        Prize.from(4) shouldBe Prize.THIRD
        Prize.from(3) shouldBe Prize.FOURTH
        Prize.from(2) shouldBe Prize.NONE
        Prize.from(1) shouldBe Prize.NONE
        Prize.from(0) shouldBe Prize.NONE
    }
}
