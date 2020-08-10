package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class LottoTest {
    private lateinit var numbersWithLessSize: List<LottoNumber>
    private lateinit var numbersWithDuplication: List<LottoNumber>
    private lateinit var validNumbers: List<LottoNumber>
    private lateinit var lotto: Lotto
    private lateinit var winningNumbers: Lotto
    private lateinit var winningLotto: WinningLotto

    @BeforeEach
    fun `set up`() {
        numbersWithLessSize = listOf(LottoNumber(1))
        numbersWithDuplication = listOf(1,1,2,3,4,5).map { LottoNumber.of(it) }
        validNumbers = listOf(1,2,3,4,5,6).map { LottoNumber.of(it) }
        winningNumbers = Lotto(listOf(1,2,3,10,20,30).map { LottoNumber.of(it) })

        lotto = Lotto(validNumbers)
        winningLotto = WinningLotto(winningNumbers, LottoNumber(45))
    }

    @DisplayName("숫자의 개수가 6개인지 확인한다")
    @Test
    fun `numbers size`() {
        assertThatThrownBy {
            // when
            Lotto(numbersWithLessSize)

            // then
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Expected size is 6, but was 1")
    }

    @DisplayName("숫자가 중복되는지 확인한다")
    @Test
    fun `numbers duplication`() {
        assertThatThrownBy {
            // when
            Lotto(numbersWithDuplication)

            // then
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("1 duplicate has occurred")
    }

    @DisplayName("당첨번호와 일치하는 숫자 개수를 반환한다")
    @Test
    fun `match count`() {
        // when
        val countOfMatch = lotto.countOfMatch(winningLotto)

        // then
        assertThat(countOfMatch).isEqualTo(3)
    }

    @DisplayName("로또번호가 특정 숫자를 포함하는지의 여부를 반환한다")
    @Test
    fun contains() {
        // when
        val hasNumber = lotto.contains(LottoNumber(1))
        val hasNoSuchNumber = lotto.contains(LottoNumber(45))

        // then
        assertTrue(hasNumber)
        assertFalse(hasNoSuchNumber)
    }
}
