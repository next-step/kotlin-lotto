package lotto.domain

data class LottoNumber(val value: Int) {

    init {
        require(LottoGenerator.DEFAULT_RANGE.contains(value)) {
            "로또의 숫자는 1 - 45 사이의 값이어야 합니다."
        }
    }

    override fun toString(): String {
        return value.toString()
    }
}
