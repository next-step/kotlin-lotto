package lotto.business

class RandomLottoPicker {
    fun pick(lottoNumbers: List<LottoNumber>, count: Int): Set<LottoNumber> {
        return lottoNumbers.shuffled().take(count).toSet()
    }
}
