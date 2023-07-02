package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoRank
import lotto.domain.WinningLotto
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    fun `당첨번호와 보너스번호가 중복되면 예외를 리턴한다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        val bonusNumber = LottoNumber(6)

        shouldThrow<IllegalArgumentException> {
            WinningLotto(winningNumbers, bonusNumber)
        }
    }

    @Test
    fun `당첨번호가 6개 모두 동일하면 1등을 리턴한다`() {
        val lotto = Lotto(arrayOf(1, 2, 3, 4, 5, 6))

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        val bonusNumber = LottoNumber(10)

        WinningLotto(winningNumbers, bonusNumber).getLottoRank(lotto) shouldBe LottoRank.FIRST
    }

    @Test
    fun `당첨번호가 5개 동일하고 보너스번호가 맞으면 2등을 리턴한다`() {
        val lotto = Lotto(arrayOf(1, 2, 3, 4, 5, 10))

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        val bonusNumber = LottoNumber(10)

        WinningLotto(winningNumbers, bonusNumber).getLottoRank(lotto) shouldBe LottoRank.SECOND
    }

    @Test
    fun `당첨번호가 5개 동일하고 보너스번호가 틀리면 3등을 리턴한다`() {
        val lotto = Lotto(arrayOf(1, 2, 3, 4, 5, 16))

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        val bonusNumber = LottoNumber(10)

        WinningLotto(winningNumbers, bonusNumber).getLottoRank(lotto) shouldBe LottoRank.THIRD
    }

    @Test
    fun `당첨번호가 4개가 동일하면 4등을 리턴한다`() {
        val lotto = Lotto(arrayOf(1, 2, 3, 4, 15, 16))

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        val bonusNumber = LottoNumber(10)

        WinningLotto(winningNumbers, bonusNumber).getLottoRank(lotto) shouldBe LottoRank.FOURTH
    }

    @Test
    fun `당첨번호가 3개가 동일하면 5등을 리턴한다`() {
        val lotto = Lotto(arrayOf(1, 2, 3, 14, 15, 16))

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        val bonusNumber = LottoNumber(10)

        WinningLotto(winningNumbers, bonusNumber).getLottoRank(lotto) shouldBe LottoRank.FIFTH
    }
}
