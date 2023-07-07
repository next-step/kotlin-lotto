package lotto.ui

import lotto.domain.LottoNumber

class InputView {

    fun getPurchasingAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getManualBuyAmount(): Int {
        println()
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun getManualBuyNumber(manualBuyAmount: Int): List<String> {
        println()
        println("수동으로 구매할 번호를 입력해 주세요.")
        val manualNumberTextList = mutableListOf<String>()
        repeat(manualBuyAmount) {
            val inputText = readln()
            manualNumberTextList.add(inputText)
        }
//        val lotteryPaperList = mutableListOf<LotteryPaper>()
//        repeat(manualBuyAmount) {
//            val inputText = readln()
//            val lotteryPaper = LotteryPaper(parseLottoNumberText(inputText))
//            lotteryPaperList.add(lotteryPaper)
//        }
        return manualNumberTextList.toList()
    }

    fun getWinningNumber(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
    }

    fun getBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        return LottoNumber(readln().toInt())
    }
}
