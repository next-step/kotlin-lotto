package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoTest {
    private lateinit var lotto: Lotto

    @BeforeEach
    fun `set up`() {
        lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `has lucky numbers`() {
        assertThat(
            lotto.hasLuckyNumber(
                luckyNumbers = listOf(1, 2, 3, 10, 20, 30)
            )
        ).isEqualTo(3)
    }

    @Test
    fun `print toString`() {
        assertThat(lotto.toString()).isEqualTo(listOf(1, 2, 3, 4, 5, 6).toString())
    }
}
