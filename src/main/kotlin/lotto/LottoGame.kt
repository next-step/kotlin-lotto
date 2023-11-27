package lotto

import lotto.view.InputView
import lotto.view.ResultView

class LottoGame {
    fun match(
        userLotto: Set<Int>,
        winningLotto: Set<Int>,
    ): Int {
        val matchCount = userLotto.intersect(winningLotto.toSet()).size
        return rank(matchCount)
    }

    private fun rank(
        matchCount: Int,
    ): Int {
        return when (matchCount) {
            6 -> 1
            5 -> 2
            4 -> 3
            3 -> 4
            else -> 0
        }
    }
}

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val shop = LottoShop()
    val game = LottoGame()
    val money = inputView.get("구입금액을 입력해 주세요.")
    // 얼마를 살 수 있다. 
    val count = money / 1000
    val lottos = shop.buy(count)
    println("${count}개를 구매했습니다.")
    lottos.forEach { 
        println(it)
    }
    val winningLotto = inputView.getWinningLotto("지난 주 당첨 번호를 입력해 주세요.")
    // 맞춰 본다.
    val result = lottos.groupingBy {
        game.match(it, winningLotto)
    }.eachCount()
    
    val benefitCalculator = BenefitCalculator()
    val benefit = benefitCalculator.calculate(result)
    resultView.show(result, benefit)
}


