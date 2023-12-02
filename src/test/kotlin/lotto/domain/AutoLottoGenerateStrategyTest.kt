package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AutoLottoGenerateStrategyTest {
    @Test
    fun `번호를 6개가진 로또를 생성한다`() {
        val autoLottoGenerateStrategy = AutoLottoGenerateStrategy()

        val lotto = autoLottoGenerateStrategy.generate()

        assertThat(lotto.numbers.size).isEqualTo(6)
    }

    @Test
    fun `중복된 번호가 생성되지 않는다`() {
        val autoLottoGenerateStrategy = AutoLottoGenerateStrategy()

        val lotto = autoLottoGenerateStrategy.generate()

        assertThat(lotto.numbers.numbers.distinct().size).isEqualTo(6)
    }

    @Test
    fun `번호는 정렬되어 생성된다`() {
        val autoLottoGenerateStrategy = AutoLottoGenerateStrategy()

        val lotto = autoLottoGenerateStrategy.generate()

        assertThat(lotto.numbers.numbers).isSorted
    }
}
