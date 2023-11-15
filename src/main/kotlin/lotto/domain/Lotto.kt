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

    fun containsBonusBall(bonusBall: LottoNumber): Boolean {
        return lottoNumbers.contains(bonusBall)
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_PRICE = 1000

        fun fromInts(lottoNumbers: List<Int>): Lotto = Lotto(lottoNumbers.map { number ->
            LottoNumbers.LOTTO_NUMBERS.find { it.number == number } ?: LottoNumber(number)
        })

        fun fromLottoNumbers(lottoNumbers: List<LottoNumber>): Lotto = Lotto(lottoNumbers)
    }
}
