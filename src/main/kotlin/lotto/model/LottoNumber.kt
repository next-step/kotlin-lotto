package lotto.model

data class LottoNumber(val num: Int) {
    init {
        require(num in 1..45) {
            "로또 숫자 범위는 1에서 45까지 입니다."
        }
    }
}
