package lotto.domain

data class Lotto(val lottoNumbers: Set<LottoNumber>) {
    init {
        require(lottoNumbers.size == LOTTO_SIZE) { "로또는 6개의 숫자로 구성되어야 합니다." }
    }

    fun intersect(other: Lotto) = lottoNumbers.intersect(other.lottoNumbers).size

    operator fun contains(lottoNumber: LottoNumber) = lottoNumbers.contains(lottoNumber)

    companion object {
        const val LOTTO_SIZE = 6
    }
}
