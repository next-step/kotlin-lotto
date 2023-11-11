package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `로또를 생성한다`() {
        val lottoMachine = LottoMachine(LottoMoney(1000), LottoNumbersGeneratorStub)
        assertThat(lottoMachine.getLottos()).hasSize(1)
    }

    @Test
    fun `로또는 구매한 금액에 따라 개수가 달라진다`() {
        val lottoMachine = LottoMachine(LottoMoney(14000), RandomLottoNumbersGenerator)
        assertThat(lottoMachine.getTotalCount()).isEqualTo(14)
    }

    @Test
    fun `수익률을 계산한다`() {
        val lottoMachine = LottoMachine(LottoMoney(1000), LottoNumbersGeneratorStub)
        val winningLotto = WinningLotto(
            Lotto(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(7),
                    LottoNumber(8),
                    LottoNumber(9)
                )
            )
        )
        assertThat(lottoMachine.getLottoResult(winningLotto).earningRate).isEqualTo(5.0)
    }
}
