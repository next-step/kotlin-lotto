package lotto

import io.kotest.matchers.shouldBe
import lotto.fixture.generatorWithParameter
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `금액을 받아 로또 티켓을 생성한다`() {
        val lottoGenerator = generatorWithParameter(listOf(1, 2, 3, 4, 5, 6))
        val lottoMachine = LottoMachine(lottoGenerator)

        val lottoTicket = lottoMachine.generateTicket(1000)

        lottoTicket shouldBe LottoTicket(listOf(Lotto.from(listOf(1, 2, 3, 4, 5, 6))))
    }
}
