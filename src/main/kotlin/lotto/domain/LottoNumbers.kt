package lotto.domain

import java.util.*

class LottoNumbers(numbers: Set<LottoNumber>) {
    var lottoNumbers = TreeSet<LottoNumber>()
        private set

    constructor(stringNumbers: String) : this(stringNumbers.split(SPLIT_SYMBOL)
        .map { i -> LottoNumber.from(i.toInt()) }
        .toSet()
    )

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

    fun size() : Int{
        return lottoNumbers.size
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        const val SPLIT_SYMBOL = ","
    }
}
