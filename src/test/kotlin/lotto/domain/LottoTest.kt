package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {
    private lateinit var lotto: Lotto

    @BeforeEach
    fun `set up`() {
        lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
    }

    @DisplayName("로또의 번호와 당첨번호가 일치하는지 파악하여, 로또의 매칭성공 개수를 반환한다")
    @Test
    fun `has lucky numbers`() {
        assertThat(
            lotto.hasLuckyNumber(
                luckyNumbers = listOf(1, 2, 3, 10, 20, 30)
            )
        ).isEqualTo(3)
    }

    @DisplayName("toString()을 하면, 로또가 가지고 있는 번호를 반환한다")
    @Test
    fun `print toString()`() {
        assertThat(lotto.toString()).isEqualTo(listOf(1, 2, 3, 4, 5, 6).toString())
    }
}
