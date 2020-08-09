package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class LottoTest {
    private lateinit var numbersWithLessSize: List<LottoNumber>
    private lateinit var numbersWithDuplication: List<LottoNumber>
    private lateinit var normalNumbers: List<LottoNumber>
    private lateinit var lotto: Lotto
    private lateinit var winningNumbers: Lotto
    private lateinit var winningLotto: WinningLotto

    @BeforeEach
    fun `set up`() {
        numbersWithLessSize = listOf(LottoNumber(1))
        numbersWithDuplication = listOf(
            LottoNumber(1),
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5)
        )
        normalNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )
        winningNumbers = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(10),
                LottoNumber(20),
                LottoNumber(30)
            )
        )
        lotto = Lotto(normalNumbers)
        winningLotto = WinningLotto(winningNumbers, LottoNumber(45))
    }

    @DisplayName("숫자의 개수가 6개인지 확인한다")
    @Test
    fun `numbers size`() {
        Assertions.assertThatThrownBy {
            // when
            Lotto(numbersWithLessSize)

            // then
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid Lotto Numbers Size : 1 should be 6")
    }

    @DisplayName("숫자가 중복되는지 확인한다")
    @Test
    fun `numbers duplication`() {
        Assertions.assertThatThrownBy {
            // when
            Lotto(numbersWithDuplication)

            // then
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Lotto Numbers Duplication : 1 occurred")
    }

    @DisplayName("당첨번호와 일치하는 숫자 개수를 반환한다")
    @Test
    fun `match count`() {
        // when
        val countOfMatch = lotto.countOfMatch(winningLotto)

        // then
        assertThat(countOfMatch).isEqualTo(3)
    }

    @DisplayName("로또번호가 다른 한 개의 숫자를 포함하는지의 여부를 반환한다")
    @Test
    fun `contains`() {
        // when
        val hasNumber = lotto.contains(LottoNumber(1))
        val hasNoSuchNumber = lotto.contains(LottoNumber(45))

        // then
        assertTrue(hasNumber)
        assertFalse(hasNoSuchNumber)
    }
}
