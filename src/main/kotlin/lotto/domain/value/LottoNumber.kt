package lotto.domain.value

data class LottoNumber(private val number: Int) {
    init {
        if (number !in 1..45) throw IllegalArgumentException("로또는 1~45사이의 숫자만 생성가능합니다.")
    }

    fun getNumber() = number

    override fun toString() = "$number"
}
