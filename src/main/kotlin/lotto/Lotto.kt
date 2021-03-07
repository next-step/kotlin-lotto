package lotto

class Lotto(lottoNumbers: List<LottoNumber>) {
    
    init {
        require(lottoNumbers.size == 6) { "로또번호 개수가 6개가 아닙니다." }
    }
}
