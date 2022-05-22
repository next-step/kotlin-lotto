package lotto

class ResultView() {

    fun purchaseLotto(issuanceLottoCount: Int, lottoRecord: List<LottoNumberSet>) {
        println("${issuanceLottoCount}개를 구매했습니다.")
        lottoRecord.forEach {
            println(it.lotto)
        }
    }

    fun printTitle() {
        println("당첨 통계")
        println("---------")
    }

    fun printResult(winningStaticsResponseDto: WinningStaticsResponseDto) {
        val winningLotto = winningStaticsResponseDto.winningLottoList
        winningLotto.forEach { (lottoWinningAmount, count) ->
            println("${lottoWinningAmount.winningAmount}개 일치 (${lottoWinningAmount.matchCount}원)- ${count}개")
        }
        println("총 수익률은 ${winningStaticsResponseDto.profitRatio}입니다.")
    }
}
