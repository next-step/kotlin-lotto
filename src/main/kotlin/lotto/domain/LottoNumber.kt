package lotto.domain

class LottoNumber private constructor(val numbers: List<Int>) {
    infix fun countSameNumberWith(other: LottoNumber): Int {
        return numbers.count { other.numbers.contains(it) }
    }

    infix fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    companion object {
        fun of(numbers: List<Int>): LottoNumber {
            return LottoNumber(numbers)
        }
    }
}
