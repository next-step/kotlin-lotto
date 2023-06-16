package lotto

class LottoGame(val lottoNumbers: List<LottoNumbers>) {
    companion object {
        fun from(count: Int): LottoGame {
            val lottoNumbers = List(count) { LottoNumbers.generateRandom() }

            return LottoGame(lottoNumbers)
        }
    }
}
