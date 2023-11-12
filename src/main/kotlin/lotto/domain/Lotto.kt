package lotto.domain

class Lotto private constructor(val lottoNumbers: List<LottoNumber>) {
    init {
        require(lottoNumbers.size == LOTTO_NUMBER_COUNT) {
            "로또 번호는 정확히 ${LOTTO_NUMBER_COUNT}개의 숫자로 이루어져야 합니다."
        }
        require(lottoNumbers.distinct().size == lottoNumbers.size) {
            "로또 번호에 중복된 숫자가 있습니다."
        }
    }

    fun match(anotherLotto: Lotto): Int {
        return lottoNumbers.intersect(anotherLotto.lottoNumbers.toSet()).count()
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_PRICE = 1000

        fun fromInts(lottoNumbers: List<Int>): Lotto {
            return Lotto(lottoNumbers.map { LottoNumber(it) })
        }

        fun fromLottoNumbers(lottoNumbers: List<LottoNumber>): Lotto {
            return Lotto(lottoNumbers)
        }
    }
}
