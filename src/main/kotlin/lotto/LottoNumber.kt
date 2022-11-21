package lotto

private const val MIN_NUMBER = 1
private const val MAX_NUMBER = 45

data class LottoNumber(
    val value: Int
) {

    init {
        require(value in MIN_NUMBER..MAX_NUMBER) { "$value 값은 1 ~ 45 까지만 허용됩니다." }
    }
}
