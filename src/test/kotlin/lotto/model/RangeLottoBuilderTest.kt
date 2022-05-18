package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class RangeLottoBuilderTest {

    @Test
    fun `1~45 사이 숫자 중 6개를 랜덤하게 뽑아내어 로또를 만든다`() {

        val rangeOfNumbers = 1..45
        val countOfNumberToSelect = 6

        val lottoBuilder = RangeLottoBuilder(rangeOfNumbers, countOfNumberToSelect)
        val lotto = lottoBuilder.createLotto()

        assertAll(
            { assertThat(lotto.numbers.filter { it !in rangeOfNumbers }).isEmpty() },
            { assertThat(lotto.numbers.size).isEqualTo(countOfNumberToSelect) },
            { assertThat(lotto.numbers.distinct().size).isEqualTo(countOfNumberToSelect) }
        )
    }
}
