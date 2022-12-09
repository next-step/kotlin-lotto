package lotto

data class LottoNumber(val number: Int) {
    constructor(numberStr: String) : this(numberStr.toInt()) {
        require(number in 1..45) { "lotto number out of range" }
    }
}
