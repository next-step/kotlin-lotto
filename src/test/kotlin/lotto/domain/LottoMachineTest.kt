package lotto.domain

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

    @Test
    fun `당첨 번호를 받아 당첨 로또를 생성한다`() {
        val lottoMachine = LottoMachine()

        val winningLotto = lottoMachine.toWinningLotto("1, 2, 3, 4, 5, 6")

        winningLotto shouldBe Lotto.from(listOf(1, 2, 3, 4, 5, 6))
    }
}
