package lotto.business

class LottoNumbersSorter {
    fun sort(lottoNumbers: List<LottoNumber>): List<LottoNumber> {
        return lottoNumbers.sortedBy { it.number }
    }
}
