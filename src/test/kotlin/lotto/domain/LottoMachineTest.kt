package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `요청한 개수만큼 로또를 생성한다`() {
        val ticket = LottoMachine.generateTickets(5)

        ticket.shouldHaveSize(5)
    }

    @Test
    fun `로또를 생성하지 않으면 예외가 발생한다`() {
        shouldThrow<IllegalStateException> { LottoMachine.generateTickets(0) }
            .message shouldBe "로또 생성 개수는 1개 이상이어야 합니다."
    }
}
