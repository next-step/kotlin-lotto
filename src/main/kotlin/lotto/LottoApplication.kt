package lotto

import lotto.ui.LottoController

fun main() {
    try {
        LottoController.runLotteryRound()
    } catch (e: IllegalArgumentException) {
        println("\n${e.message} 재실행합니다...")
        main()
    }
}
