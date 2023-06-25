package lotto.domain

import java.util.*

class LottoNumbers(numbers: Set<LottoNumber>) {
    var lottoNumbers = TreeSet<LottoNumber>()
        private set

    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) {
            "로또 번호는 6자리여야 합니다."
        }

        lottoNumbers = TreeSet<LottoNumber> { p1, p2 -> p1.value.compareTo(p2.value) }
        lottoNumbers.addAll(numbers)
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
    }
}
