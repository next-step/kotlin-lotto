package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.RANKING
import lotto.domain.StringNumbers
import lotto.domain.WinningLotto
import lotto.domain.WinningResult
import lotto.domain.WinningStatistics
import org.assertj.core.api.Assertions

class WinningLottoTest : StringSpec({
    "입력 받은 문자열의 6개 당첨 숫자에 중복이 없어야 한다" {

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { WinningLotto(StringNumbers("1, 2, 3, 4, 6, 6".split(",")), LottoNumber(8)) }
    }

    "발행한 로또에 대해서 당첨 통계: 6개 일치된 경우가 몇 장인지와 금액을 반환 한다." {
        val lottoMachine = LottoMachine(1000)
        val lottoList = lottoMachine.publishLotto()

        val firstLotto = lottoList[0]
        val bonusNumber = getBonusNumber(firstLotto)
        val winningLotto = WinningLotto(firstLotto, bonusNumber)
        val winningResult = WinningResult(lottoList, winningLotto)

        winningResult.getWinningResult(RANKING.FIRST) shouldBe 1
    }

    "발행한 금액과 당첨 금액을 통해 수익률을 반환한다." {
        val lottoMachine = LottoMachine(1000)
        val lottoList = lottoMachine.publishLotto()

        val firstLotto = lottoList[0]
        val bonusNumber = getBonusNumber(firstLotto)
        val winningLotto = WinningLotto(firstLotto, bonusNumber)
        val winningResult = WinningResult(lottoList, winningLotto)
        val winningStatistics = WinningStatistics(lottoMachine.price)

        winningStatistics.rateOfReturn(winningResult.getWinningPrice()) shouldBe RANKING.FIRST.winningPrice.toFloat() / lottoMachine.price.toFloat()
    }

    "수익율을 통해 손익에 대한 결과를 반환 한다." {
        val lottoMachine = LottoMachine(1000)
        val lottoList = lottoMachine.publishLotto()

        val firstLotto = lottoList[0]
        val bonusNumber = getBonusNumber(firstLotto)
        val winningLotto = WinningLotto(firstLotto, bonusNumber)
        val winningResult = WinningResult(lottoList, winningLotto)
        val winningStatistics = WinningStatistics(lottoMachine.price)

        if (winningStatistics.rateOfReturn(winningResult.getWinningPrice()) >= 1) "이익" shouldBe "이익"
    }
}) {
    companion object {
        fun getBonusNumber(lotto: Lotto): LottoNumber {
            return LottoNumber(
                LottoNumber.RANGE.subtract(lotto.numbers.map { it.number }.toSet()).random()
            )
        }
    }
}
