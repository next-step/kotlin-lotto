package lotto

object ResultView {
    fun showPurchasedLotto(lottoList: List<Lotto>) {
        println("${lottoList.count()}개를 구매했습니다.")
        lottoList.forEach {
            println(it.numbers)
        }
        println()
    }

    fun showLottoStatResult(lottoStatResult: LottoStatResult) {
        println()
        println("당첨 통계")
        println("---------")
        println("3개 일치 (${LottoStatResult.FIFTH_PLACE_REWARD}원)- ${lottoStatResult.fifthCount}개")
        println("4개 일치 (${LottoStatResult.FOURTH_PLACE_REWARD}원)- ${lottoStatResult.fourthCount}개")
        println("5개 일치 (${LottoStatResult.THIRD_PLACE_REWARD}원)- ${lottoStatResult.thirdCount}개")
        println("6개 일치 (${LottoStatResult.FIRST_PLACE_REWARD}원)- ${lottoStatResult.firstCount}개")
    }
}
