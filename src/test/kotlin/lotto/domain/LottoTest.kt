package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoTest {

    @Test
    fun getMatchCountTest() {
        val sameNumbers = listOf(1, 2, 3)
        val numbers = listOf(4, 5, 6).plus(sameNumbers)
        val lotto = Lotto(numbers)

        val otherNumbers = listOf(7, 8, 9).plus(sameNumbers)
        val otherLotto = Lotto(otherNumbers)

        val count = lotto.getMatchCount(otherLotto)

        assertThat(count).isEqualTo(sameNumbers.count())
    }
}
