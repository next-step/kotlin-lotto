package nextstep.mission.lotto.io

import nextstep.mission.lotto.Lotto
import nextstep.mission.lotto.vo.LottoNumber
import nextstep.mission.lotto.vo.LottoNumbers
import nextstep.mission.lotto.vo.WinningResult

object ConsoleInput {
    fun inputPrice(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toInt() ?: 0
    }

    fun inputWinningNumbers2(): LottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readLine()?.split(",")?.map { LottoNumber(it.toInt()) }.let { LottoNumbers(it!!) }
    }
}

object ConsoleOutput {
    fun printLotto(lotto: Lotto) {
        println("${lotto.lottoNumbers.size}개를 구매했습니다.")
        lotto.lottoNumbers.forEach { println(it.numbers) }
    }

    fun printWinningResult(winningResult: WinningResult, rateOfReturn: Double) {
        println("==========")
        // println("3개 일치 (5000원) - ${winningResult.threeMatch}개")
        // println("4개 일치 (50000원) - ${winningResult.fourMatch}개")
        // println("5개 일치 (1500000원) - ${winningResult.fiveMatch}개")
        // println("6개 일치 (2000000000원) - ${winningResult.sixMatch}개")
        println("총 수익률은 ${String.format("%.2f", rateOfReturn)} 입니다.")
    }
}
