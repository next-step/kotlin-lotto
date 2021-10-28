package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottosTest {
    @DisplayName("quantity 갯수만큼 로또가 생성되는지 확인.")
    @ParameterizedTest
    @ValueSource(ints = [2, 3, 4, 5, 6])
    fun constructor(quantity: Int) {
        val numberGenerator = object : NumberGenerator {
            override fun getNumber() = 1
        }
        val expectedLottos = (1..quantity).map { Lotto((1..Lotto.SIZE).map { LottoNumber(1) }) }
        assertThat(Lottos(quantity, numberGenerator).lottos)
            .isEqualTo(expectedLottos)
    }
}
