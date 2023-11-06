package lotto.view

import lotto.domain.LottoNumbers
import lotto.domain.LottoResult
import lotto.dto.LottoNumber
import lotto.dto.LottoPrice
import lotto.dto.Money

object View {
    fun inputMoney(): Money {
        println("구입금액을 입력해 주세요.")
        return Money(readln().toIntOrNull() ?: 0)
    }

    fun inputWinningNumber(): LottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return LottoNumbers(
            readln().split(",").map {
                LottoNumber(it.trim().toInt())
            }
        )
    }

    fun inputBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        return LottoNumber(readln().toIntOrNull() ?: 0)
    }

    fun inputManualCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toIntOrNull() ?: 0
    }

    fun inputManualLottoNumbers(count: Int): List<LottoNumbers> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        val lottoNumbers = mutableListOf<LottoNumbers>()
        repeat(count) {
            lottoNumbers.add(
                LottoNumbers(
                    readln().split(",").map {
                        LottoNumber(it.trim().toInt())
                    }
                )
            )
        }
        return lottoNumbers
    }

    fun outputBuyCount(manualCount: Int, autoCount: Int) {
        println("수동으로 ${manualCount}장, 자동으로 ${autoCount}개를 구매했습니다.")
    }

    fun outputBuyLottoNumbers(lottoNumbers: List<LottoNumbers>) {
        lottoNumbers.forEach {
            println(it.numbers.joinToString(", ", "[", "]"))
        }
        println()
    }

    fun outputResult(money: Money, result: LottoResult) {
        println("당첨 통계")
        println("---------")
        for (rank in LottoPrice.rankOf()) {
            println("${rank.text} (${rank.price}원) - ${result.getExact(rank)}개")
        }
        println("총 수익률은 %.2f입니다.".format(money.getROR(result.getPrice())))
    }
}
