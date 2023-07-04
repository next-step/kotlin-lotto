package lotto

import lotto.domain.AutomaticLottoVendingMachine
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class AutomaticLottoVendingMachineTest {

    @Test
    fun `발급된 로또 번호는 6개여야 한다`() {
        Assertions.assertThat(
            AutomaticLottoVendingMachine.purchase(1)
                .first()
                .numbers
        ).hasSize(6)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 10])
    fun `주어진 개수 만큼 로또 번호를 생성해야 한다`(numberOfLotto: Int) {
        Assertions.assertThat(
            AutomaticLottoVendingMachine.purchase(numberOfLotto)
        ).hasSize(numberOfLotto)
    }
}
