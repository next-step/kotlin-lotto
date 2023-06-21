package lotto.domain

class LottoNumbers(
    val lottoNumbers: List<LottoNumber>
) {
    init {
        validateLottoNumbersCount()
        validateDistinct()
    }

    private fun validateLottoNumbersCount() {
        require(lottoNumbers.size == 6) {
            "로또 숫자가 6개가 아닙니다."
        }
    }

    private fun validateDistinct() {
        require(lottoNumbers.distinct().size == lottoNumbers.size) {
            "로또 숫자에 중복이 있습니다."
        }
    }

    fun contains(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(lottoNumber)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LottoNumbers

        if (lottoNumbers != other.lottoNumbers) return false

        return true
    }

    override fun hashCode(): Int {
        return lottoNumbers.hashCode()
    }

    override fun toString(): String {
        return lottoNumbers.joinToString(", ", "[", "]") { it.toString() }
    }
}
