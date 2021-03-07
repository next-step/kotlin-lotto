package lotto

class Lotto(lottoNumbers: List<LottoNumber>) {
    
    init {
        require(lottoNumbers.size == VALID_LOTTO_NUMBER_COUNT) { "로또번호 개수가 6개가 아닙니다." }
    }
    
    companion object {
        private const val VALID_LOTTO_NUMBER_COUNT = 6
    }
}
