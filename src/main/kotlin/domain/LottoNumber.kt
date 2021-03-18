package domain

class LottoNumber(val value: Int) {
    init {
        if (value < 1 || value > 45) throw IllegalArgumentException()
    }
}
