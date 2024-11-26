package lotto

import lotto.domain.LottoCalculator
import lotto.domain.LottoGenerator
import lotto.domain.LottoResult
import lotto.domain.LottoResultManager
import lotto.model.Lotto
import lotto.view.InputView

fun main() {
    val inputView = InputView()
    val totalPurchaseAmount = inputView.readTotalPurchaseAmount().toInt()
    val totalPurchaseCount = LottoCalculator().calculateLottoCount(
        totalPurchaseAmount = totalPurchaseAmount,
        pricePerAmount = 1000
    )
    // resultView 필요
    println("$totalPurchaseCount 개를 구매했습니다.")

    val lottoGenerator = LottoGenerator(totalPurchaseCount)
    val lottoList = lottoGenerator.generate()

    //resultView 필요
    lottoList.forEach {
        println(it.numbers)
    }

    val winningLotto = inputView.readWinningLotto()

    val lottoResultManager = LottoResultManager(
        winningLotto = Lotto(winningLotto),
        lottoList = lottoList
    )

    when (val winResult = lottoResultManager.isWinResult()) {
        is LottoResult.Success -> {
            println("3개 일치 (5000원) - ${winResult.winThreeCount}")
            println("4개 일치 (50000원) - ${winResult.winFourCount}")
            println("5개 일치 (1500000원) - ${winResult.winFiveCount}")
            println("6개 일치 (20억원) - ${winResult.winSixCount}")
        }

        is LottoResult.Failure -> {
            println("꽝 출력")
        }
    }

    println(lottoResultManager.calculateWinningRate())
}