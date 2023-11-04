package lotto.view

import lotto.dto.LottoNumbers
import lotto.dto.LottoResult

object View {
    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toIntOrNull() ?: 0
    }

    fun inputWinningNumber(): LottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return LottoNumbers(readln().split(",").map { it.trim().toInt() })
    }

    fun outputBuyCount(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    fun outputBuyLottoNumbers(lottoNumbers: List<LottoNumbers>) {
        lottoNumbers.forEach {
            println(it.numbers.joinToString(", ", "[", "]"))
        }
        println()
    }

    fun outputResult(money: Int, result: LottoResult) {
        println("당첨 통계")
        println("---------")
        for (i in 3..6) {
            println("${i}개 일치 (${result.getPrice(i)}원) - ${result.getExact(i)}개")
        }
        println("총 수익률은 %.2f입니다.".format(result.getRatio(money)))
    }
}
