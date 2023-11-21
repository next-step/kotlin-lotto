package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RandomLottoDispenserTest {

    @ParameterizedTest
    @CsvSource(value = ["999, 0", "1001, 1", "13000, 13", "123441, 123"])
    fun `입력 금액 만큼 로또 생성`(money: Int, expectSize: Int) {
        val sut = RandomLottoDispenser()

        val actualLottos = sut.issue(money)

        Assertions.assertThat(actualLottos).hasSize(expectSize)
    }
}
