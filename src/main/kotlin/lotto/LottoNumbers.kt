package lotto

class LottoNumbers(private var lottoNumbers: MutableList<LottoNumber>) {

    init {
        val shuffled = lottoNumbers.shuffled()
        lottoNumbers = shuffled as MutableList<LottoNumber>
        lottoNumbers.sort()
    }
}