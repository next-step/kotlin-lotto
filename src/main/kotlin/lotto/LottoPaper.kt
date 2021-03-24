package lotto

data class LottoPaper(val lottoNumbers: List<LottoNumber>) {

    val size: Int
        get() = lottoNumbers.size
}
