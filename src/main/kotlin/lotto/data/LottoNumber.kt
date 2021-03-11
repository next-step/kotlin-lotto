package lotto.data

data class LottoNumber(
    val lottoNumber: Int
) {
    init {
        require(lottoNumber in 1..45) { "로또 숫자는 1에서 45사이의 숫자여야 합니다." }
    }
}
