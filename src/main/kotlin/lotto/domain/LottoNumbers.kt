package lotto.domain

class LottoNumbers(val lottoNumbers: List<LottoNumber>) {
    fun intersectCount(other: LottoNumbers): Int {
        val thisNumbers = lottoNumbers.map { it.number }
        val otherNumbers = other.lottoNumbers.map { it.number }
        return thisNumbers.intersect(otherNumbers.toSet()).size
    }

    fun hasNumber(number: LottoNumber): Boolean {
        return lottoNumbers.contains(number)
    }
}

class LottoNumber(val number: Int) {
    override fun hashCode(): Int {
        return number
    }

    override fun equals(other: Any?): Boolean {
        if (other !is LottoNumber) return false

        return number == other.number
    }
}
