package lotto.domain

class Lotto(private val lottoNumbers: List<LottoNumber>) {
    init {
        require(lottoNumbers.size == LOTTO_NUMBER_COUNT) {
            "로또 번호는 정확히 ${LOTTO_NUMBER_COUNT}개의 숫자로 이루어져야 합니다."
        }
        require (lottoNumbers.distinct().size == lottoNumbers.size) {
            "로또 번호에 중복된 숫자가 있습니다."
        }
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
    }
}
