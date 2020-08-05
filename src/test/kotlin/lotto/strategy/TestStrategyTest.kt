package lotto.strategy

import lotto.domain.value.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TestStrategyTest {
    private val testStrategy = TestStrategy()

    @Test
    fun shuffle() {
        val list = List(45) { i -> LottoNumber(i + 1) }
        val actual = testStrategy.shuffle(list.subList(0, 6))
        val expect = List(6) { i -> LottoNumber(i + 1) }
        assertThat(actual).isEqualTo(expect)
    }
}
