package domain.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

@DisplayName("로또(Lotto)")
class LottoTest {

    @Test
    fun `셔플 전략을 통해 로또를 생성한다`() {
        val lotto: Lotto = Lotto.of(LottoShuffleStrategy)

        assertAll(
            { assertThat(lotto).isNotNull },
            { assertThat(lotto).isExactlyInstanceOf(Lotto::class.java) },
        )
    }
}
