package lotto.model

class Lotto(numbers: Set<LottoNumber>) {

    val numbers: Set<LottoNumber> = numbers.toSet()

    init {
        require(numbers.size == SIZE) {
            "lottoTicket must be $SIZE numbers. but provided numbers(`$numbers`)"
        }
    }

    infix fun matchedCountBy(other: Lotto): Int {
        return numbers.count { other.numbers.contains(it) }
    }

    operator fun contains(number: LottoNumber): Boolean {
        return number in numbers
    }

    companion object {
        const val SIZE: Int = 6
    }
}
