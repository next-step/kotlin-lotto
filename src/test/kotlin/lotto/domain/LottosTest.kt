package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottosTest {

    object FakeLottoNumbers {
        fun lottoNumbers(): List<Set<LottoNumber>> {
            return listOf(
                getLottoNumbers("1 2 3 4 5 6"),
                getLottoNumbers("11 22 33 44 15 16")
            )
        }

        private fun getLottoNumbers(numbers: String): Set<LottoNumber> =
            numbers.split(" ").map { LottoNumber(it.toInt()) }.toSet()
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 3, 6])
    fun `로또의 갯수를 가진다`(count: Int) {
        val lottos = List(count) { Lotto() }
        assertThat(Lottos(lottos).count).isEqualTo(count)
    }

    @Test
    fun `로또 번호들로 로또 리스트를 반환한다`() {
        val fakeLottoNumbers = FakeLottoNumbers.lottoNumbers()
        assertThat(Lottos.of(fakeLottoNumbers).count).isEqualTo(fakeLottoNumbers.size)
    }

    @Test
    fun `로또 번호가 null이면 빈 리스트를 반환한다`() {
        assertThat(Lottos.of(null).count).isZero
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 3, 6])
    fun `두 개의 로또 리스트를 합할 수 있다`(count: Int) {
        val lottos1 = List(3) { Lotto() }
        val lottos2 = Lottos(List(count) { Lotto() })
        assertThat(Lottos(lottos1).join(lottos2).count).isEqualTo(lottos1.size + count)
    }
}
