package lotto

import lotto.domain.LottoVendingMachine
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoVendingMachineTest {

    @ParameterizedTest
    @CsvSource(
        "14000, 14",
        "1300, 1",
        "500, 0",
    )
    fun `금액에 맞는 개수 만큼 로또 번호를 생성해야 한다`(money: Int, numOfLotto: Int) {
        Assertions.assertThat(
            LottoVendingMachine()
                .purchase(money)
                .size
        ).isEqualTo(numOfLotto)
    }
}
