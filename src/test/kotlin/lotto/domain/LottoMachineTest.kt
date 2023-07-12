package lotto.domain

import io.kotest.matchers.shouldBe
import lotto.fixture.generatorWithParameter
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `금액을 받아 로또 티켓을 생성한다`() {
        val lottoGenerator = generatorWithParameter(listOf(1, 2, 3, 4, 5, 6))
        val lottoMachine = LottoMachine(lottoGenerator)

        val lottoTicket = lottoMachine.generateTicket(Money.from(1000))

        lottoTicket shouldBe LottoTicket(listOf(Lotto.from(listOf(1, 2, 3, 4, 5, 6))))
    }

    @Test
    fun `당첨 번호와 보너스 번호를 받아 당첨 로또를 생성한다`() {
        val lottoMachine = LottoMachine()

        val winningLotto = lottoMachine.toWinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)

        winningLotto shouldBe WinningLotto.from(listOf(1, 2, 3, 4, 5, 6), 7)
    }

    @Test
    fun `수동 로또 번호 목록과 돈을 을 받아 로또 티켓을 생성한다`() {
        val manualLottos = listOf(
            listOf(7, 8, 9, 10, 11, 12),
            listOf(13, 14, 15, 16, 17, 18)
        )
        val autoLotto = listOf(1, 2, 3, 4, 5, 6)
        val lottoGenerator = generatorWithParameter(autoLotto)
        val lottoMachine = LottoMachine(lottoGenerator)
        val money = Money.from(3000)

        val lottoTicket = lottoMachine.generateTicket2(money, manualLottos)

        val expectedLottos = manualLottos + listOf(autoLotto)
        lottoTicket shouldBe LottoTicket(expectedLottos.map { Lotto.from(it) })
    }
}
