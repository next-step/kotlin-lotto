package lotto

import io.kotest.matchers.shouldBe
import lotto.domain.Prize
import org.junit.jupiter.api.Test

class PrizeTest {
    @Test
    internal fun `로또 당첨 금액`() {
        Prize.FIRST.money shouldBe 2_000_000_000
        Prize.SECOND.money shouldBe 30_000_000
        Prize.THIRD.money shouldBe 1_500_000
        Prize.FOURTH.money shouldBe 50_000
        Prize.FIFTH.money shouldBe 5_000
        Prize.NONE.money shouldBe 0
    }

}
