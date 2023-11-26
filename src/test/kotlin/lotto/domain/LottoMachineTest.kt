package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMachineTest {
    @ParameterizedTest
    @CsvSource(value = ["5000, 5", "14000, 14"])
    fun `구입한 금액에 대해 로또를 발급한다`(amount: Int, expectSize: Int) {
        val lottoNumberGenerator = LottoNumberGenerator()
        val lottos = LottoMachine.generateLotto(Buy(amount), lottoNumberGenerator)
        assertThat(lottos.size).isEqualTo(expectSize)
    }
}
