package lotto.controller

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class GeneratorRandomNumbersTest {
    @Test
    fun `로또 티켓을 한장 랜덤 생성한다`() {
        val tickets = GeneratorRandomNumbers.generateNumbers()
        tickets.size shouldBe 6
    }
}
