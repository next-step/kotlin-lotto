package lotto

class LottoNumbers(var lottoNumbers: List<LottoNumber>) {

    init {
        val shuffled = lottoNumbers.shuffled()
        lottoNumbers = shuffled as MutableList<LottoNumber>
        lottoNumbers = lottoNumbers.sorted()
    }

    override fun toString(): String {
        return "$lottoNumbers"
    }
}