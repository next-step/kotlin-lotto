package lotto.model.lotto

data class LottoNumber(val number: Int) {
    init {
        validation()
    }

    private fun validation() {
        require(Lotto.isLottoNumberRange(this)) { "잘못된 숫자입니다." }
    }
}

fun String.toLottoNumber() = LottoNumber(this.toInt())

fun Int.toLottoNumber() = LottoNumber(this)

fun List<Int>.toLottoNumbers() = this.map(Int::toLottoNumber)
