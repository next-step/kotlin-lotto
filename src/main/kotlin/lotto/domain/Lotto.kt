package lotto.domain

class Lotto(private val numbers: LottoNumbers) {
    constructor(vararg numbers: Int) : this(LottoNumbers(*numbers))

    fun calculateMatchCount(otherLottoNumbers: LottoNumbers): Int {
        return numbers.count { number -> number in otherLottoNumbers }
    }

    fun contains(number: LottoNumber): Boolean {
        return number in numbers
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
