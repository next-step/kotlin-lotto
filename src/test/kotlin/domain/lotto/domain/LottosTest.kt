package domain.lotto.domain

import domain.lotto.strategy.LottoShuffleStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

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
}