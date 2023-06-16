package lotto.domain

class Lotto private constructor(val lottoList: List<LottoNumbers>) {

    companion object {
        private const val LOTTO_PRICE = 1000

        fun of(input: Int): Lotto {
            val count = input / LOTTO_PRICE
            val lottoList = List(count) { LottoNumbers.create() }
            return Lotto(lottoList)
        }
    }
}
