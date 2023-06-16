package lotto.domain

class Lotto private constructor(val lottoList: List<LottoNumbers>) {

    fun getSize(): Int {
        return lottoList.size
    }

    companion object {
        const val PER_LOTTO_PRICE = 1000

        fun of(input: Int): Lotto {
            val count = input / PER_LOTTO_PRICE
            val lottoList = List(count) { LottoNumbers.create() }
            return Lotto(lottoList)
        }
    }
}
