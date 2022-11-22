package lotto.domain

class WinnerLottoTicket(
    lottoGenerateStrategy: LottoGenerateStrategy
) {
    private val winnerLottoNumbers: Set<LottoNumber> = lottoGenerateStrategy.generate()
    fun countMatchNumber(lottoNumber: Set<LottoNumber>): Int = lottoNumber.intersect(winnerLottoNumbers).size
}
