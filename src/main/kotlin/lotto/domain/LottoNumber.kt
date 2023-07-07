package lotto.domain

data class LottoNumber(
    val number: Int
) {

    init {
        require(number in (MINIMUM_NUMBER..MAXIMUM_NUMBER)) { "허용되지 않는 범위의 로또번호 입니다." }
    }

    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
    }
}
