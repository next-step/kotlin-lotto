package lotto.view

import lotto.domain.LottoRank
import lotto.service.LottoResponses
import lotto.service.LottoResultResponse

private const val WINNING_LOTTO_DELIMITER = ","

object InputView {
    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요.")
        val inputMoney = readln()

        return inputMoney.toIntOrNull() ?: throw IllegalArgumentException("올바른 금액을 입력해 주세요. 입력: $inputMoney")
    }

    fun inputWinningLotto(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        return readln().split(WINNING_LOTTO_DELIMITER)
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("당첨 번호는 숫자만 입력하실 수 있습니다. 입력: $it") }
    }
}

object ResultView {
    fun printPurchaseLottos(purchaseLottos: LottoResponses) {
        purchaseLottos.lottos.forEach {
            println(it.numbers.joinToString(prefix = "[", postfix = "]"))
        }
    }

    fun printResult(calculateResult: LottoResultResponse) {
        println("당첨 통계")
        println("---------")
        (3..6).forEach {
            println("${it}개 일치 (${LottoRank.of(it).prize}원) - ${calculateResult.ranks.count { rank -> rank.matchCount == it }}개")
        }

        println("총 수익률은 ${calculateResult.profit}입니다. (기준이 1 이기 때문에 결과적으로 ${ if (calculateResult.profit >= 1) "이득이" else "손해" } 라는 의미임)")
    }
}
