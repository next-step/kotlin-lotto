package com.nextstep.jngcii.lotto.model

class Lotto(lottoNumbers: List<LottoNumber>) {
    val numbers = lottoNumbers
        .map { it.value }
        .toSortedSet()

    init {
        require(numbers.size == LOTTO_SIZE) { "중복없는 ${LOTTO_SIZE}개의 숫자가 아닙니다." }
    }

    fun getSameCount(comparison: Lotto): Int {
        return numbers.intersect(comparison.numbers).count()
    }

    fun contains(bonusNumber: BonusNumber) = numbers.contains(bonusNumber.value)

    companion object {
        private const val LOTTO_SIZE = 6
    }
}
