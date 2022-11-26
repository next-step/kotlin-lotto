package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions

class LottoTest : StringSpec({

    "로또 1장의 가격은 1000원 이다" {

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { LottoMachine(100) }
    }

    "1-45 사이의 난수 6개 생성" {
        val lottoMachine = LottoMachine(1000)
        val lottoList = lottoMachine.publishLotto()

        lottoList[0].publishNumbers.size shouldBe 6
        lottoList[0].publishNumbers.forEach { num ->
            num shouldBeInRange IntRange(1, 45)
        }
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
        val winningMachine = WinningMachine("1, 2, 3, 4, 5, 6")

        winningMachine.winningNumbers.size shouldBe 6
    }

    "발행한 로또에 대해서 당첨 통계: 3개 일치된 경우가 몇 장인지와 금액을 반환 한다." {
        val lottoMachine = LottoMachine(1000)

        val lottoList = lottoMachine.publishLotto()
        val winningStatistics = WinningStatistics(lottoList, lottoList[0].publishNumbers.take(3))

        winningStatistics.winningCheck().containsKey(WinningStatistics.RANKING.FOURTH) shouldBe true
        winningStatistics.winningCheck()[WinningStatistics.RANKING.FOURTH] shouldBe 1
    }

    "발행한 로또에 대해서 당첨 통계: 4개 일치된 경우가 몇 장인지와 금액을 반환 한다." {
        val lottoMachine = LottoMachine(1000)

        val lottoList = lottoMachine.publishLotto()
        val winningStatistics = WinningStatistics(lottoList, lottoList[0].publishNumbers.take(4))

        winningStatistics.winningCheck().containsKey(WinningStatistics.RANKING.THIRD) shouldBe true
        winningStatistics.winningCheck()[WinningStatistics.RANKING.THIRD] shouldBe 1
    }

    "발행한 로또에 대해서 당첨 통계: 5개 일치된 경우가 몇 장인지와 금액을 반환 한다." {
        val lottoMachine = LottoMachine(1000)

        val lottoList = lottoMachine.publishLotto()
        val winningStatistics = WinningStatistics(lottoList, lottoList[0].publishNumbers.take(5))

        winningStatistics.winningCheck().containsKey(WinningStatistics.RANKING.SECOND) shouldBe true
        winningStatistics.winningCheck()[WinningStatistics.RANKING.SECOND] shouldBe 1
    }

    "발행한 로또에 대해서 당첨 통계: 6개 일치된 경우가 몇 장인지와 금액을 반환 한다." {
        val lottoMachine = LottoMachine(1000)

        val lottoList = lottoMachine.publishLotto()
        val winningStatistics = WinningStatistics(lottoList, lottoList[0].publishNumbers.take(6))

        winningStatistics.winningCheck().containsKey(WinningStatistics.RANKING.FIRST) shouldBe true
        winningStatistics.winningCheck()[WinningStatistics.RANKING.FIRST] shouldBe 1
    }

    "발행한 금액과 당첨 금액을 통해 수익률을 반환한다." {
        val lottoMachine = LottoMachine(1000)

        val lottoList = lottoMachine.publishLotto()
        val winningStatistics = WinningStatistics(lottoList, lottoList[0].publishNumbers.take(3))
        winningStatistics.winningCheck()

        winningStatistics.rateOfReturn() shouldBe 5f
    }

    "수익율을 통해 손익에 대한 결과를 반환 한다." {
        val lottoMachine = LottoMachine(1000)

        val lottoList = lottoMachine.publishLotto()
        val winningStatistics = WinningStatistics(lottoList, lottoList[0].publishNumbers.take(3))
        winningStatistics.winningCheck()

        if (winningStatistics.rateOfReturn() < 1) "손해" else "이익" shouldBe "이익"
    }
})
