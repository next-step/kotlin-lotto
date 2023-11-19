package lotto.domain

data class LottoNumber(val value: Int) {

    init {
        require(value in 1..45) { "로또 번호는 1 ~ 45 숫자입니다." }
    }
}
