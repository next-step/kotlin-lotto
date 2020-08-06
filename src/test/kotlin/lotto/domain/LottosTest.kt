package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottosTest {
    @ParameterizedTest
    @CsvSource(
        value = [
            "4, 4",
            "10,10"
        ]
    )
    fun `입력한 갯수 만큼 로또 번호 생성`(purchaseCount: Int, expected: Int) {
        Assertions.assertThat(Lottos.of(purchaseCount).lottos.size).isEqualTo(expected)
    }
}
