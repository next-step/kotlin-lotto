package lotto

import lotto.domain.DuplicateFreeSequenceGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class DuplicateFreeSequenceGeneratorTest {

    @RepeatedTest(10)
    fun `생성된 수열에 중복된 수가 없어야 한다`() {
        DuplicateFreeSequenceGenerator(1, 20, 10)
            .groupingBy { it }
            .eachCount()
            .all {
                it.value == 1
            }
    }

    @ParameterizedTest
    @CsvSource(
        "0, 5",
        "1, 10",
        "-30, 50",
    )
    fun `지정된 범위 내의 숫자만 생성된 수열에 들어있어야 한다`(from: Int, to: Int) {
        assertThat(
            DuplicateFreeSequenceGenerator(from, to, 5)
                .none { it !in from..to }
        ).isEqualTo(true)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5, 10])
    fun `생성된 수열의 길이는 count여야 한다`(count: Int) {
        assertThat(
            DuplicateFreeSequenceGenerator(
                from = 1,
                to = 100,
                count = count
            ).size
        ).isEqualTo(count)
    }
}
