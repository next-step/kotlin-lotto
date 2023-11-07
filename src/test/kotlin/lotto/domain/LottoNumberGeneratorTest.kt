@file:Suppress("NonAsciiCharacters")

package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberGeneratorTest {
    @Test
    fun `발급된 로또 번호는 1~45 사이의 숫자이다`() {
        val actual = LottoNumberGenerator.generateNumbers()

        assertThat(actual).allMatch { it.number in (1..45) }
    }

    @Test
    fun `발급된 로또 번호는 중복될 수 없다`() {
        val actual = LottoNumberGenerator.generateNumbers()

        assertThat(actual).hasSameSizeAs(actual.toSet())
    }

    @Test
    fun `발급된 로또 번호는 오름차순 정렬되어 있다`() {
        val actual = LottoNumberGenerator.generateNumbers()

        assertThat(actual).containsExactlyElementsOf(actual.sortedBy { it.number })
    }
}
