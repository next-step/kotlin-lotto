package lotto.domain

import lotto.domain.LottoRule.LOTTO_NUMBER_COUNT
import java.util.stream.Collectors.toSet

class Lotto(numbers: Set<LottoNumber>) {
    val numbers: Set<LottoNumber> = numbers.sorted().toSet()

    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { "로또 번호는 ${LOTTO_NUMBER_COUNT}개여야 합니다." }
    }

    fun matchCount(winningNumbers: Set<LottoNumber>): Int {
        return numbers.intersect(winningNumbers).size
    }

    fun intersect(other: Lotto): Set<LottoNumber> {
        return numbers.intersect(other.numbers)
    }

    operator fun contains(number: BonusNumber): Boolean {
        return number.value in numbers
    }

    companion object {
        fun from(numbers: Set<Int>): Lotto {
            return Lotto(numbers.map { LottoNumber.of(it) }.toSet())
        }
    }
}
