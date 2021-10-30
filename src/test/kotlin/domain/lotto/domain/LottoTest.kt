package domain.lotto.domain

import domain.lotto.domain.LottoNumber.Companion.of
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

@DisplayName("로또(Lotto)")
class LottoTest {

    @Test
    fun `셔플 전략을 통해 로또를 생성한다`() {
        val expected = Lotto.of(
            sortedSetOf(
                of(1), of(2), of(3),
                of(4), of(5), of(6),
            )
        )
        val actual: Lotto = Lotto.of { it.sorted() }

        assertAll(
            { assertThat(actual).isNotNull },
            { assertThat(actual).isExactlyInstanceOf(Lotto::class.java) },
            { assertThat(actual).isEqualTo(expected) }
        )
    }
}
