package lotto

class LottoNumbers(private val lottoNumbers: List<LottoNumber>) : List<LottoNumber> by lottoNumbers {
    fun makeRankingCountMap(winLottoNumber: LottoNumber): Map<LottoRanking, Int> = lottoNumbers.groupingBy {
        it.getRanking(winLottoNumber)
    }.eachCount()
}
