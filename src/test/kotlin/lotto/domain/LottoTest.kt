package lotto.domain

import lotto.util.Assertions.assertLotto
import lotto.util.createLotto
import lotto.util.createLottoNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {
    private lateinit var lessSizeNumbers: List<LottoNumber>
    private lateinit var duplicateNumbers: List<LottoNumber>
    private lateinit var normalNumbers: List<LottoNumber>
    private lateinit var normalLotto: Lotto
    private lateinit var winningLotto: WinningLotto

    @BeforeEach
    fun `set up`() {
        lessSizeNumbers = createLottoNumbers(listOf(1, 2))
        duplicateNumbers = createLottoNumbers(listOf(1, 1, 3, 4, 5, 6))
        normalNumbers = createLottoNumbers(listOf(1, 2, 3, 4, 5, 6))

        normalLotto = createLotto(normalNumbers)
        winningLotto = WinningLotto(normalLotto, LottoNumber(10))
    }

    @DisplayName("숫자의 개수가 6개인지 확인한다")
    @Test
    fun `numbers size`() {
        assertLotto(lessSizeNumbers).validateSize()
    }

    @DisplayName("숫자가 중복되는지 확인한다")
    @Test
    fun `numbers duplication`() {
        assertLotto(duplicateNumbers).validateDuplication()
    }

    @DisplayName("당첨번호와 일치하는 숫자 개수를 반환한다")
    @Test
    fun `match count`() {
        // when
        val count = normalLotto.countOfMatch(winningLotto)

        // then
        assertThat(count).isEqualTo(6)
    }

    @DisplayName("다른 숫자를 포함하는지의 여부를 반환한다")
    @Test
    fun `contains`() {
        // when
        val hasNumber = normalLotto.contains(LottoNumber(1))
        val hasNoSuchNumber = normalLotto.contains(LottoNumber(45))

        // then
        assertTrue(hasNumber)
        assertFalse(hasNoSuchNumber)
    }
}
