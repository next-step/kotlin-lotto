package stringAddCalculator

data class LottoNumber(val number: Int) {
    init {
        require(number in 1..45) { "로또는 1~45사이의 숫자만 생성가능합니다." }
    }

    override fun toString() = "$number"
}
