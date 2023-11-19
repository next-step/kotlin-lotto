package lotto.domain

class Lotto(val numbers: Set<LottoNumber>) {

    init {
        require(this.numbers.size == 6) { "로또는 유일한 숫자 6개로 구성해야합니다." }
    }

    constructor(vararg numbers: Int) : this(numbers.map { LottoNumber(it) }.toSet())

    fun matchedCount(other: Lotto): Int {
        return numbers.filter { other.contains(it) }.size
    }

    fun contains(number: LottoNumber): Boolean {
        return number in numbers
    }

    companion object {
        fun random(): Lotto {
            val randomNumbers = (1..45).shuffled().subList(0, 6).toList().toIntArray()
            return Lotto(*randomNumbers)
        }
    }
}
