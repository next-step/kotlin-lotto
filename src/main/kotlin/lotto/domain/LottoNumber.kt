package lotto.domain

data class LottoNumber(val value: Int) {

    init {
        require(isValidLottoNumberRange()) { "로또번호를 생성할 수 없는 값이다. value: $value" }
    }

    private fun isValidLottoNumberRange(): Boolean {
        return value in 1..45
    }
}
