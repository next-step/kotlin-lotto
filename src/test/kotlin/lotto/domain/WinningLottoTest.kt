package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class WinningLottoTest {
    private lateinit var winningNumbers: Lotto
    private lateinit var invalidBonusNumber: LottoNumber
    private lateinit var validBonusNumber: LottoNumber
    private lateinit var winningLotto: WinningLotto

    @BeforeEach
    fun `set up`() {
        winningNumbers = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        invalidBonusNumber = LottoNumber(1)
        validBonusNumber = LottoNumber(7)
    }

    @DisplayName("당첨번호와 보너스 번호가 중복되는지 확인한다")
    @Test
    fun `bonus duplication`() {
        Assertions.assertThatThrownBy {
            // when
            winningLotto = WinningLotto(winningNumbers, invalidBonusNumber)

            // then
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Bonus is Duplicate : 1 should be unique value")
    }

    @DisplayName("당첨번호가 다른 숫자와 일치하는지의 여부를 반환한다")
    @Test
    fun `contains`() {
        // given
        winningLotto = WinningLotto(winningNumbers, validBonusNumber)

        // when
        val hasNumber = winningLotto.contains(LottoNumber(1))
        val hasNoNumber = winningLotto.contains(LottoNumber(45))

        // then
        assertTrue(hasNumber)
        assertFalse(hasNoNumber)
    }
}
