package lotto.number

data class LottoNumber(
    val number: Int,
) {
    init {
        require(number in MIN_NUMBER..MAX_NUMBER) { "로또 번호는 ${MIN_NUMBER}와 ${MAX_NUMBER}사이여야 합니다." }
    }

    companion object {
        private const val COUNT = 6
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        val RANGE: List<LottoNumber> = (MIN_NUMBER..MAX_NUMBER)
            .map(::LottoNumber)
            .toList()
    }
}
