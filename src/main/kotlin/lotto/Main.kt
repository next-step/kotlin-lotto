package lotto

import calculator.StringParser
import calculator.parseToInt

fun main() {
    println("구입 금액을 입력해 주세요")
    val purchasePrice = readln()

    val lottos = LottoPurchase().buyLotto(parseToInt(purchasePrice))

    println("${lottos.size}개를 구매했습니다.")

    for (lotto in lottos) {
        println(lotto.numbers)
    }

    println("지난 주 당첨 번호를 입력해 주십시오.")
    val lastLottoWinnerNumbers = StringParser.getNumberStrings(readln())

    println("당첨통계")
    println("----------")
}
