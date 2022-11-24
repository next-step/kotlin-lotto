package lotto.domain


data class LottoNumber(
    val value: Int
) {

    init {
        require(value in MIN_NUMBER..MAX_NUMBER) { "$value 값은 1 ~ 45 까지만 허용됩니다." }
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }
}
