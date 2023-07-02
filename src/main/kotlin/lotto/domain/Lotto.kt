package lotto.domain

class Lotto(numbers: Set<LottoNumber>) {

    var lottoNumbers: MutableSet<LottoNumber>
        private set

    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) {
            "로또 번호는 ${LOTTO_NUMBER_COUNT}자리여야 합니다."
        }

        lottoNumbers = numbers.sortedWith { p1, p2 ->
            p1.value.compareTo(p2.value)
        }.toMutableSet()
    }

    fun removeAll(lotto: Lotto) {
        this.lottoNumbers.removeAll(lotto.lottoNumbers)
    }

    fun size(): Int {
        return lottoNumbers.size
    }

    fun contains(bonusNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(bonusNumber)
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        private const val SPLIT_SYMBOL = ","

        fun from(stringNumbers: String): Lotto {
            return Lotto(
                stringNumbers.split(SPLIT_SYMBOL)
                    .map { lottoNumber -> LottoNumber(lottoNumber.toInt()) }
                    .toSet()
            )
        }
    }
}
