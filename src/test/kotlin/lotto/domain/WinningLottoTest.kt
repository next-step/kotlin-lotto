package lotto.domain

import lotto.util.Assertions.assertWinningNumbers
import lotto.util.createLottoNumbers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WinningLottoTest {
    private lateinit var lottoNumbers: List<LottoNumber>
    private lateinit var invalidBonus: LottoNumber
    private lateinit var validBonus: LottoNumber

    @BeforeEach
    fun `set up`() {
        lottoNumbers = createLottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        invalidBonus = LottoNumber(1)
        validBonus = LottoNumber(7)
    }

    @DisplayName("당첨번호와 보너스 번호가 중복되는지 확인한다")
    @Test
    fun `bonus duplication`() {
        assertWinningNumbers(lottoNumbers).containBonus(invalidBonus)
    }

    @DisplayName("당첨번호가 다른 숫자와 일치하는지의 여부를 반환한다")
    @Test
    fun `contains`() {
        assertWinningNumbers(lottoNumbers).contain(LottoNumber(1))
        assertWinningNumbers(lottoNumbers).contain(LottoNumber(45))
    }
}
