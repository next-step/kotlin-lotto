package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottosTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 3, 6])
    fun `로또의 갯수를 가진다`(count: Int) {
        val lottos = List(count) { Lotto() }
        assertThat(Lottos(lottos).count).isEqualTo(count)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 3, 6])
    fun `두 개의 로또 리스트를 합할 수 있다`(count: Int) {
        val lottos1 = List(3) { Lotto() }
        val lottos2 = Lottos(List(count) { Lotto() })
        assertThat(Lottos(lottos1).join(lottos2).count).isEqualTo(lottos1.size + count)
    }
}
