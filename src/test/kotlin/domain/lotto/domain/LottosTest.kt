package domain.lotto.domain

import domain.lotto.strategy.LottoShuffleStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

@DisplayName("로또들(Lottos)")
class LottosTest {

    @Test
    fun `숫자와 셔플 전략을 입력하면 로또를 생성한다`() {
        val size = 1
        val lottoShuffleStrategy = LottoShuffleStrategy { it.sorted() }

        val expected = Lottos.of(listOf(Lotto.of(lottoShuffleStrategy)))
        val actual: Lottos = Lottos.from(size, lottoShuffleStrategy)

        assertAll(
            { assertThat(actual).isNotNull },
            { assertThat(actual).isExactlyInstanceOf(Lottos::class.java) },
            { assertThat(actual).isEqualTo(expected) }
        )
    }

    // @Test
    // fun `당첨 로또를 입력하면 당첨 결과를 반환한다`() {
    //     val expected = MatchBoard.valuesExcludedMiss().associateWith { 0 }.toMutableMap()
    //     expected[MatchBoard.FIRST] = 1
    //
    //     val lottos: Lottos = Lottos.from(1) { it.sorted() }
    //     val lotto = Lotto.of("1, 2, 3, 4, 5, 6") { it.split(", ") }
    //
    //     val actual = lottos.match(lotto)
    //     assertThat(actual).isEqualTo(expected)
    // }
}
