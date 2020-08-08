package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class LuckyNumbersTest {
    private lateinit var lottoNumbers: LottoNumbers
    val luckyNumbers = LuckyNumbers(listOf(1, 2, 3, 10, 20, 30))

    @Test
    fun `numbers size`() {
        Assertions.assertThatThrownBy {
            // when
            LuckyNumbers(listOf(1, 2, 3, 4))

            // then
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid lucky numbers size : 4")
    }

    @Test
    fun `numbers duplication`() {
        Assertions.assertThatThrownBy {
            // when
            LuckyNumbers(listOf(1, 1, 3, 4, 5, 6))

            // then
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("There is duplication in lucky numbers : [1, 3, 4, 5, 6]")
    }

    @Test
    fun `matched count`() {
        // given
        lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))

        // when
        val matchedCount = luckyNumbers.getMatchedCount(lottoNumbers)

        // then
        assertThat(matchedCount).isEqualTo(3)
    }
}
