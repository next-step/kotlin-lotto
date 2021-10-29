package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottosTest {
    @DisplayName("quantity 갯수만큼 로또가 생성되어야 한다.")
    @ParameterizedTest
    @ValueSource(ints = [2, 3, 4, 5, 6])
    fun constructor(quantity: Int) {
        val numberGenerator = object : NumberGenerator {
            override fun getNumber() = 1
        }
        val expected = (1..quantity).map { Lotto((1..Lotto.SIZE).map { LottoNumber(1) }) }
        assertThat(Lottos.from(quantity, numberGenerator).list)
            .isEqualTo(expected)
    }

    @DisplayName("로또들의 번호가 일치하는 횟수가 몇회인지 계산되어야 한다.")
    @Test
    fun countMatches() {
        val expected = mapOf(
            Match.SIX to 1,
            Match.FIVE to 2,
            Match.FOUR to 3,
            Match.THREE to 4,
            Match.NONE to 5
        )
        assertThat(Fixture.lottos.countMatches(Fixture.winningLotto))
            .isEqualTo(expected)
    }
}
