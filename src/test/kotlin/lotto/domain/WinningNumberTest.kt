package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberTest {

    @Test
    fun `보너스 숫자가 기존 당첨번호와 중복되면 IllegalArgumentException을 throw한다`() {
        // given
        val lotteryPaper = LotteryPaper(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )

        // when
        val bonusNumber = LottoNumber(6)

        // then
        assertThrows<IllegalArgumentException> {
            WinningNumber(lotteryPaper, bonusNumber)
        }
    }

    @Test
    fun `로또 번호를 비교해서 몇개 맞았는지 검사한다`() {
        // given
        val lotteryPaper = LottoTestHelper.createLotteryPaper(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber(7)

        // when
        val answer = 6
        val purchasedLottoNumber = LottoTestHelper.createLotteryPaper(1, 2, 3, 4, 5, 6)
        val winningNumber = WinningNumber(lotteryPaper, bonusNumber)

        // then
        val actual = winningNumber.compareLottoNumber(purchasedLottoNumber.getLottoNumbers())
        assertThat(actual).isEqualTo(answer)
    }

    @Test
    fun `보너스 숫자가 맞았는지 검사한다`() {
        // given
        val lotteryPaper = LottoTestHelper.createLotteryPaper(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber(7)

        // when
        val answer = false
        val purchasedLottoNumber = LottoTestHelper.createLotteryPaper(1, 2, 3, 4, 5, 6)
        val winningNumber = WinningNumber(lotteryPaper, bonusNumber)

        // then
        val actual = winningNumber.isBonusNumberMatch(purchasedLottoNumber.getLottoNumbers())
        assertThat(actual).isEqualTo(answer)
    }
}
