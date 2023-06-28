package lotto.domain

import java.util.TreeSet

class LottoNumbers(numbers: Set<LottoNumber>) {
    var lottoNumbers = TreeSet<LottoNumber>()
        private set

    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) {
            "로또 번호는 ${LOTTO_NUMBER_COUNT}자리여야 합니다."
        }

        lottoNumbers = TreeSet<LottoNumber> { p1, p2 -> p1.value.compareTo(p2.value) }
        lottoNumbers.addAll(numbers)
    }

    fun removeAll(lottoNumbers: LottoNumbers) {
        this.lottoNumbers.removeAll(lottoNumbers.lottoNumbers)
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

        fun from(stringNumbers: String): LottoNumbers {
            return LottoNumbers(
                stringNumbers.split(SPLIT_SYMBOL)
                    .map { lottoNumber -> LottoNumber(lottoNumber.toInt()) }
                    .toSet()
            )
        }
    }
}
