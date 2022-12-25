package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.assertj.core.api.Assertions

class LottoTest : StringSpec({

    "로또 1장의 가격은 1000원 이다" {

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { LottoMachine(100) }
    }

    "로또 하나의 숫자는 6개 이다" {
        val numbers = (1..7).map { LottoNumber(it) }

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lotto(numbers.toSet()) }
    }

    "생성한 난수 6개는 중복이 없어야 한다." {
        val lottoMachine = LottoMachine(1000)
        val lottoList = lottoMachine.publishLotto()

        lottoList.size shouldBe lottoList.distinct().size
    }

    "로또 n장에 따라 난수 6개씩 n개 생성" {
        val lottoMachine = LottoMachine(14000)

        val lottoList = lottoMachine.publishLotto()

        lottoList.size shouldBe lottoMachine.purchaseCount
    }

    "입력 받은 문자열을 , 구분자를 통해 6개의 당첨 숫자로 반환한다" {
        val winningLotto = WinningLotto("1, 2, 3, 4, 5, 6", LottoNumber(7))

        winningLotto.winningLottoNumbers.size shouldBe 6
    }

    "입력 받은 문자열의 6개 당첨 숫자에 중복이 없어야 한다" {
        val winningLotto = WinningLotto("1, 2, 3, 4, 6, 6", LottoNumber(7))

        winningLotto.winningLottoNumbers.size shouldNotBe 6
    }

    "발행한 로또에 대해서 당첨 통계: 6개 일치된 경우가 몇 장인지와 금액을 반환 한다." {
        val lottoMachine = LottoMachine(1000)
        val lottoList = lottoMachine.publishLotto()

        val firstLottoString = lottoList[0].toString()
        val winningLotto = WinningLotto(firstLottoString.replace("[", "").replace("]", ""), LottoNumber(7))
        val winningResult = WinningResult(lottoList, winningLotto)

        winningResult.getWinningResult(RANKING.FIRST) shouldBe 1
    }

    "발행한 금액과 당첨 금액을 통해 수익률을 반환한다." {
        val lottoMachine = LottoMachine(1000)
        val lottoList = lottoMachine.publishLotto()

        val firstLottoString = lottoList[0].toString()
        val winningLotto = WinningLotto(firstLottoString.replace("[", "").replace("]", ""), LottoNumber(7))
        val winningResult = WinningResult(lottoList, winningLotto)
        val winningStatistics = WinningStatistics(lottoMachine.price)

        winningStatistics.rateOfReturn(winningResult.getWinningPrice()) shouldBe RANKING.FIRST.winningPrice.toFloat() / lottoMachine.price.toFloat()
    }

    "수익율을 통해 손익에 대한 결과를 반환 한다." {
        val lottoMachine = LottoMachine(1000)
        val lottoList = lottoMachine.publishLotto()

        val firstLottoString = lottoList[0].toString()
        val winningLotto = WinningLotto(firstLottoString.replace("[", "").replace("]", ""), LottoNumber(7))
        val winningResult = WinningResult(lottoList, winningLotto)
        val winningStatistics = WinningStatistics(lottoMachine.price)

        if (winningStatistics.rateOfReturn(winningResult.getWinningPrice()) < 1) "손해" else "이익" shouldBe "이익"
    }
})
