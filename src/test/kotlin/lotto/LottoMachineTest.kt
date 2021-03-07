package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `로또머신은 생성 시 로또금액을 입력받는다`() {
        val lottoPrice = 1000
        val result = LottoMachine(lottoPrice = lottoPrice)
        assertThat(result).isNotNull
    }
}
