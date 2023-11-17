package lottoAuto.domain

data class Lotto (
    val lottoNumbers: List<LottoNumber>
) {
    init {
        require(lottoNumbers.size == LOTTO_SIZE) { "로또 번호는 ${LOTTO_SIZE}개여야 합니다." }
        require(lottoNumbers.distinct().size == LOTTO_SIZE) { "로또 번호는 중복되지 않아야 합니다." }
    }
    companion object {
        const val LOTTO_SIZE = 6
    }
}
