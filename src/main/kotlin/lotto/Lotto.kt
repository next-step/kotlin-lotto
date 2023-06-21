package lotto

import lotto.vo.LottoNumber

data class Lotto(
    val numbers: Set<LottoNumber>,
) {
    init {
        require(numbers.size == 6) { "로또 번호는 중복 없이 6개만 입력 가능합니다." }
    }

    fun countMatchingNumbersFrom(targetNumbers: List<LottoNumber>): Int {
        return targetNumbers
            .intersect(numbers)
            .size
    }

    companion object {
        fun from(numbers: Collection<LottoNumber>): Lotto {
            return Lotto(numbers.toSet())
        }
    }
}
