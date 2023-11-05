package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DefaultLottoGenerateStrategyTest {
    @Test
    fun `번호를 6개 생성한다`() {
        val defaultLottoGenerateStrategy = DefaultLottoGenerateStrategy()

        val numbers = defaultLottoGenerateStrategy.generate()

        assertThat(numbers.size).isEqualTo(6)
    }

    @Test
    fun `중복된 번호가 생성되지 않는다`() {
        val defaultLottoGenerateStrategy = DefaultLottoGenerateStrategy()

        val numbers = defaultLottoGenerateStrategy.generate()
        val numbersSet = numbers.toSet()

        assertThat(numbers.size).isEqualTo(numbersSet.size)
    }

    @Test
    fun `번호는 정렬되어 생성된다`() {
        val defaultLottoGenerateStrategy = DefaultLottoGenerateStrategy()

        val numbers = defaultLottoGenerateStrategy.generate()

        assertThat(numbers).isSorted
    }
}
