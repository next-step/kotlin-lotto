package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoStoreTest {

    @DisplayName("로또 구매 테스트")
    @ParameterizedTest(name = "배열 {0}원으로 {1}장의 로또를 구매할 수 있다")
    @MethodSource("valueSource")
    fun `1000원 당 한장의 로또가 발행된다`(value: Value, numberOfLotto: Int) {
        val lottos = LottoStore().sell(value)
        assertThat(lottos.size).isEqualTo(numberOfLotto)
    }

    companion object {
        @JvmStatic
        fun valueSource(): List<Arguments> {
            return listOf(
                Arguments.of(Value(1000), 1),
                Arguments.of(Value(2000), 2),
                Arguments.of(Value(3000), 3),
                Arguments.of(Value(4000), 4),
                Arguments.of(Value(5000), 5),
                Arguments.of(Value(6000), 6),
            )
        }
    }
}
