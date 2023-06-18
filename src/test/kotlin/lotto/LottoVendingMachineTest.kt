package lotto

import lotto.domain.LottoVendingMachine
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoVendingMachineTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 10])
    fun `주어진 개수 만큼 로또 번호를 생성해야 한다`(numberOfLotto: Int) {
        Assertions.assertThat(
            LottoVendingMachine.purchase(numberOfLotto)
        ).hasSize(numberOfLotto)
    }
}
