package lotto.domain.rank

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BonusConditionTest {
    @Test
    fun `MATCH는 일치하는 경우에만 true를 반환한다`() {
        val bonusCondition = BonusCondition.NEED_MATCH

        val match = bonusCondition.match(false)

        match shouldBe false
    }

    @Test
    fun `NOT_MATCH는 일치하지 않는 경우에만 true를 반환한다`() {
        val bonusCondition = BonusCondition.NEED_NOT_MATCH

        val match = bonusCondition.match(true)

        match shouldBe false
    }

    @Test
    fun `NO_MATTER는 항상 true를 반환한다`() {
        val bonusCondition = BonusCondition.NO_MATTER

        val match = bonusCondition.match(false)

        match shouldBe true
    }
}
