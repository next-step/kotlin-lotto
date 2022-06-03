package lotto

data class LottoNumbers(
    private val lottoNumbers: List<LottoNumber>
) {

    init {
        require(lottoNumbers.size == 6) {
            "로또는 숫자 6개로 이루어져야 합니다."
        }
        distinctCheck()
    }

    private fun distinctCheck() {
        if (lottoNumbers.distinct().size != lottoNumbers.size) {
            throw IllegalArgumentException("중복된 숫자가 존재합니다.")
        }
    }

    fun matches(otherNumbers: LottoNumbers): Int {
        return lottoNumbers.count { otherNumbers.match(it) }
    }

    private fun match(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(lottoNumber)
    }
}
