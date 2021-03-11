package lotto.model

import java.util.TreeSet

class LottoNumbers(private val lottoNumbers: Set<LottoNumber>) : Set<LottoNumber> by lottoNumbers {
    init {
        require(lottoNumbers.size == NUMBERS_SIZE) { "로또는 6개의 로또 숫자로 이루어져 있습니다!" }
        require(lottoNumbers is TreeSet) { "로또 숫자는 정렬되어 있어야 합니다!" }
    }

    constructor(numbers: List<Int>) : this(TreeSet(numbers.map { LottoNumber((it)) }))

    companion object {
        const val NUMBERS_SIZE = 6

        fun autoCreate() =
            LottoNumbers(
                List(LottoNumber.NUMBERS_MAXIMUM) { i -> i + 1 }
                    .shuffled()
                    .subList(0, NUMBERS_SIZE)
            )
    }
}
