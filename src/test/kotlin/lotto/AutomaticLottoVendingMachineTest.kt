package lotto

import lotto.domain.AutomaticLottoVendingMachine
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class AutomaticLottoVendingMachineTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 10])
    fun `주어진 개수 만큼 로또 번호를 생성해야 한다`(numberOfLotto: Int) {
        Assertions.assertThat(
            AutomaticLottoVendingMachine.purchase(numberOfLotto)
        ).hasSize(numberOfLotto)
    }
}
