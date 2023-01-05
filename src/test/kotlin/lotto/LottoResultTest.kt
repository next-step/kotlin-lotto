package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.RANKING
import lotto.domain.StringNumbers
import lotto.domain.WinningLotto
import lotto.domain.WinningResult

class LottoResultTest : StringSpec({
    "5등." {
        val lottoString = StringNumbers("1,2,3,4,5,6")
        val lotto = Lotto(lottoString.numbers.map { LottoNumber(it.trim()) }.toSet())

        val winningLottoString = StringNumbers("1,2,3,7,8,9")
        val winningLotto = Lotto(winningLottoString.numbers.map { LottoNumber(it.trim()) }.toSet())
        val bonusNumber = LottoNumber(10)

        val winningResult = WinningResult(listOf(lotto), WinningLotto(winningLotto, bonusNumber))

        winningResult.getWinningResult(RANKING.FIFTH) shouldBe 1
    }

    "4등." {
        val lottoString = StringNumbers("1,2,3,4,5,6")
        val lotto = Lotto(lottoString.numbers.map { LottoNumber(it.trim()) }.toSet())

        val winningLottoString = StringNumbers("1,2,3,4,8,9")
        val winningLotto = Lotto(winningLottoString.numbers.map { LottoNumber(it.trim()) }.toSet())
        val bonusNumber = LottoNumber(10)

        val winningResult = WinningResult(listOf(lotto), WinningLotto(winningLotto, bonusNumber))

        winningResult.getWinningResult(RANKING.FOURTH) shouldBe 1
    }

    "3등." {
        val lottoString = StringNumbers("1,2,3,4,5,6")
        val lotto = Lotto(lottoString.numbers.map { LottoNumber(it.trim()) }.toSet())

        val winningLottoString = StringNumbers("1,2,3,4,5,9")
        val winningLotto = Lotto(winningLottoString.numbers.map { LottoNumber(it.trim()) }.toSet())
        val bonusNumber = LottoNumber(10)

        val winningResult = WinningResult(listOf(lotto), WinningLotto(winningLotto, bonusNumber))

        winningResult.getWinningResult(RANKING.THIRD) shouldBe 1
    }

    "1등." {
        val lottoString = StringNumbers("1,2,3,4,5,6")
        val lotto = Lotto(lottoString.numbers.map { LottoNumber(it.trim()) }.toSet())

        val winningLottoString = StringNumbers("1,2,3,4,5,6")
        val winningLotto = Lotto(winningLottoString.numbers.map { LottoNumber(it.trim()) }.toSet())
        val bonusNumber = LottoNumber(10)

        val winningResult = WinningResult(listOf(lotto), WinningLotto(winningLotto, bonusNumber))

        winningResult.getWinningResult(RANKING.FIRST) shouldBe 1
    }

    "2등." {
        val lottoString = StringNumbers("1,2,3,4,5,6")
        val lotto = Lotto(lottoString.numbers.map { LottoNumber(it.trim()) }.toSet())

        val winningLottoString = StringNumbers("1,2,3,4,5,9")
        val winningLotto = Lotto(winningLottoString.numbers.map { LottoNumber(it.trim()) }.toSet())
        val bonusNumber = LottoNumber(6)

        val winningResult = WinningResult(listOf(lotto), WinningLotto(winningLotto, bonusNumber))

        winningResult.getWinningResult(RANKING.SECOND) shouldBe 1
    }
})
