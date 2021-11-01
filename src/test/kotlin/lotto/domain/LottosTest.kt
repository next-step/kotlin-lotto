package lotto.domain

import lotto.exception.IllegalLottosException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottosTest {
    @DisplayName("quantity 갯수만큼 로또가 생성되어야 한다.")
    @ParameterizedTest
    @ValueSource(ints = [2, 3, 4, 5, 6])
    fun constructor(quantity: Int) {
        val expected = (1..quantity).map { Lotto((1..Lotto.SIZE).map { LottoNumber(it) }) }
        assertThat(Lottos.of(quantity, Fixture.generatorFactory).lottos)
            .isEqualTo(expected)
    }

    @DisplayName("로또의 수량은 음수일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = [-1, -11, -111, -1111, -11111])
    fun negativeQuantity(quantity: Int) {
        assertThatExceptionOfType(IllegalLottosException::class.java)
            .isThrownBy { Lottos.of(quantity, Fixture.generatorFactory) }
    }

    @DisplayName("Lottos 를 머지하면, 양쪽의 로또를 전부 갖고 있어야 한다.")
    @Test
    fun merge() {
        val quantity = 2
        val autoLottos = Lottos.of(quantity, Fixture.generatorFactory)
        assertThat(autoLottos.merge(Fixture.manualLottos).lottos)
            .isEqualTo(autoLottos.lottos + Fixture.manualLottos.lottos)
    }

    @DisplayName("로또들의 번호가 일치하는 횟수가 몇회인지 계산되어야 한다.")
    @Test
    fun countMatches() {
        val expected = mapOf(
            Match.SIX to 1,
            Match.BONUS to 1,
            Match.FIVE to 2,
            Match.FOUR to 3,
            Match.THREE to 4,
            Match.NONE to 5
        )
        assertThat(Fixture.lottos.countMatches(Fixture.winningLotto, Fixture.bonus))
            .isEqualTo(expected)
    }
}
