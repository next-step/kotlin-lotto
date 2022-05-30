package lotto.domain

import lotto.domain.Lotto.Companion.LOTTO_NUMBER_RANGE
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RandomNumberGeneratorTest {

    private val tries = 10000
    private val numbers = 10
    private val extractMap: Map<Int, Int> = (1..tries)
        .flatMap { RandomNumberGenerator().getRandomNumbers(LOTTO_NUMBER_RANGE, numbers) }
        .groupingBy { it }
        .eachCount()

    @Test
    fun `의도한 갯수만큼 추출되는지 점검한다`() {
        Assertions.assertThat(extractMap.map { it.value }.sum()).isEqualTo(tries * numbers)
    }

    @Test
    fun `주어진 범위 내에서만 나오는지 확인한다`() {
        Assertions.assertThat(extractMap.count()).isSameAs(LOTTO_NUMBER_RANGE.last)
        Assertions.assertThat(extractMap.minOf { it.key }).isSameAs(LOTTO_NUMBER_RANGE.first)
        Assertions.assertThat(extractMap.maxOf { it.key }).isSameAs(LOTTO_NUMBER_RANGE.last)
    }

    @Test
    fun `주어진 구간의 숫자가 골고루 나오는지 점검한다`() {
        extractMap
            .forEach { (_, count) ->
                Assertions.assertThat(count).isGreaterThan(1000)
            }
    }
}
