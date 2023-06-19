package lotto

import lotto.vo.LottoNumber

class Lotto(
    val numbers: Set<LottoNumber>,
) {
    init {
        require(numbers.size == 6) { "로또 번호는 중복 없이 6개만 입력 가능합니다." }
    }

    fun countMatchingNumbersFrom(winningNumbers: List<LottoNumber>): Int {
        return winningNumbers
            .intersect(numbers)
            .size
    }

    companion object {

        fun from(numbers: Collection<LottoNumber>): Lotto {
            return Lotto(numbers.toSet())
        }
    }
}
