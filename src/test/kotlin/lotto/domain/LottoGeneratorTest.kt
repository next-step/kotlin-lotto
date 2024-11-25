package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeUnique
import io.kotest.matchers.shouldBe

class LottoGeneratorTest : StringSpec({
    "should generate a valid lotto ticket" {
        val lotto = LottoGenerator.generateTicket()
        lotto.getNumbers().size shouldBe 6
        lotto.getNumbers().shouldBeUnique()
        lotto.getNumbers().all { it in 1..45 } shouldBe true
    }
})
