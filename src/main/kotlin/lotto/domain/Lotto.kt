package lotto.domain
class Lotto(lottoNumbers: List<LottoNumber>) {
    val lottoNumbers: List<LottoNumber>

    init {
        require(lottoNumbers.size == LOTTO_SIZE)
        hasNoDuplicatedNumbers(lottoNumbers)

        this.lottoNumbers = lottoNumbers.sortedBy { it.number }
    }

    fun getSameNumberCount(lotto: Lotto): Int {
        return (LOTTO_SIZE * 2) - (lottoNumbers + lotto.lottoNumbers).toSet().size
    }

    private fun hasNoDuplicatedNumbers(lottoNumbers: List<LottoNumber>) {
        require(lottoNumbers.toSet().size == LOTTO_SIZE)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Lotto) return false

        if (lottoNumbers != other.lottoNumbers) return false

        return true
    }

    override fun hashCode(): Int {
        return lottoNumbers.hashCode()
    }

    companion object {
        const val LOTTO_SIZE = 6

        fun of(lottoNumbers: List<Int>): Lotto = Lotto(lottoNumbers.map { LottoNumber(it) })
    }
}

data class LottoNumber(val number: Int) {
    init {
        require(MIN_LOTTO_NUMBER <= number)
        require(number <= MAX_LOTTO_NUMBER)
    }

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
    }
}
