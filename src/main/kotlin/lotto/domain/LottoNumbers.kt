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

    companion object {
        fun of(lottoNumbers: List<Int>): LottoNumbers {
            return LottoNumbers(lottoNumbers.map { LottoNumber(it) })
        }
    }
}

@JvmInline
value class LottoNumber(val number: Int)
