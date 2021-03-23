package domain.lotto

import domain.money.Money

class Lotto(val numbers: LottoNumbers) {
    fun countMatchedBy(winningNumbers: LottoNumbers): Int {
        return numbers.countIntersection(winningNumbers)
    }

    constructor(numbers: List<Int>) : this(LottoNumbers.fromList(numbers.map { LottoNumber.parse(it) }))

    constructor(n1: Int, n2: Int, n3: Int, n4: Int, n5: Int, n6: Int) : this(listOf(n1, n2, n3, n4, n5, n6))

    companion object {
        val PRICE = Money(1000)
    }
}
