package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RangeLottoFactoryTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,45", "4,30", "1,6", "3,10"])
    fun `RangeLottoFactory는 IntRange를 받아 그 범위 안의 숫자들로 Lotto를 만든다`(input: String) {
        val (from, to) = input.split(",").let {
            it[0].toInt() to it[1].toInt()
        }
        val range = from..to
        val rangeLottoFactory = RangeLottoFactory(range)
        val lotto = rangeLottoFactory.create()
        assertThat(range).containsAll(lotto.numbers.map { it.value })
    }
}
