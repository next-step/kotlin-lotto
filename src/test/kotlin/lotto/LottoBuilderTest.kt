package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoBuilderTest {
    @ParameterizedTest
    @CsvSource(value = ["10, 10", "1, 1", "5, 5"])
    fun `주어진 개수만큼 로또를 발급한다`(count: Int, expect: Int) {
        assertThat(LottoBuilder().create(count).size).isEqualTo(expect)
    }
}
