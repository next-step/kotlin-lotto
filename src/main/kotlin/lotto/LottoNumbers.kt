package lotto

class LottoNumbers(
    private val lottoNumbers: List<LottoNumber>
) {

    init {
        require(lottoNumbers.size == 6) {
            "로또는 숫자 6개로 이루어져야 합니다."
        }
    }
}
