package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoMachineTest {
    @ParameterizedTest
    @ValueSource(ints = [14000, 14100, 14500, 14999])
    fun `돈을 넣으면, 예산만큼 살 수 있는 로또 갯수를 반환한다`(budget: Int) {
        // given
        val lottoMachine = LottoMachine()
        val money = Money(budget)

        // when
        lottoMachine.insertMoney(money)

        // then
        val lottoCount = lottoMachine.getAvailableCount()
        assertThat(lottoCount).isEqualTo(14)
    }

    @Test
    fun `로또 넘버 풀을 인자로 주면, 로또가 발행된다`() {
        // given
        val lottoMachine = LottoMachine()
        val money = Money(15000)
        lottoMachine.insertMoney(money)
        val lottoNumberPool = LottoNumberPool

        // when
        val myLottos: Lottos = lottoMachine.buy(lottoNumberPool)

        // then
        assertThat(myLottos.lottos.size).isEqualTo(15)
    }

    @Test
    fun `WinningLotto를 인자로 주면, 로또 결과를 반환한다`() {
        // given
        val money = Money(15000)
        val lottoMachine = getTestLottoMachine(money)
        val winningLotto = getTestWinningLotto()

        // when
        val result = lottoMachine.getResult(winningLotto)

        // then
        assertThat(result.size).isEqualTo(5)
    }

    private fun getTestWinningLotto(): WinningLotto {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val winningLotto = Lotto(winningNumbers)
        val bonusNumber = LottoNumber(7)

        return WinningLotto(winningLotto, bonusNumber)
    }

    private fun getTestLottoMachine(money: Money): LottoMachine {
        val lottoMachine = LottoMachine()
        lottoMachine.insertMoney(money)

        val lottoNumberPool = LottoNumberPool
        lottoMachine.buy(lottoNumberPool)

        return lottoMachine
    }
}
