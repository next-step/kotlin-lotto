package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `로또를 생성한다`(){
        val lottoMachine = LottoMachine(LottoMoney(1000), LottoNumbersGeneratorStub)
        assertThat(lottoMachine.getLottos()).hasSize(1)
    }

    @Test
    fun `로또는 구매한 금액에 따라 개수가 달라진다`(){
        val lottoMachine = LottoMachine(LottoMoney(14000), RandomLottoNumbersGenerator)
        assertEquals(lottoMachine.getTotalCount(), 14)
    }

}
