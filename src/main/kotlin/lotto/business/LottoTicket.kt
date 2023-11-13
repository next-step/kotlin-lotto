package lotto.business

class LottoTicket(lottoNumbers: Set<LottoNumber>) : LottoNumberSet(lottoNumbers) {

    fun matchCount(targetLottoNumbers: List<LottoNumber>): Int {
        return targetLottoNumbers.count(lottoNumbers::contains)
    }

    fun contains(targetLottoNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(targetLottoNumber)
    }
}
