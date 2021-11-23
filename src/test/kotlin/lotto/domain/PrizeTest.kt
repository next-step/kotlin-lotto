package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class PrizeTest {
    @CsvSource("3,5000", "4,50000", "5,1500000", "6,2000000000")
    @ParameterizedTest
    fun `맞춘 로또 번호 개수에 따라 상금이 정해진다`(count: Int, amount: Int) {
        assertThat(Prize.of(count).money).isEqualTo(Money.of(amount))
    }

    @ValueSource(ints = [0, 1, 2])
    @ParameterizedTest
    fun `3개보다 적게 맞추면 상금이 존재하지 않는다`(count: Int) {
        assertAll(
            { assertThat(Prize.of(count)).isEqualTo(Prize.NONE) },
            { assertThat(Prize.of(count).money).isEqualTo(Money.of(0)) },
        )
    }
}
