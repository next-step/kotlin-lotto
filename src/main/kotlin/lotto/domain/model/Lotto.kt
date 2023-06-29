package lotto.domain.model

@JvmInline
value class Lotto(val numbers: List<LottoNumber>) {

    init {
        require(numbers.size == NUMBER_COUNT) {
            "${NUMBER_COUNT}개의 번호가 필요합니다"
        }
    }

    companion object {
        const val NUMBER_COUNT = 6
        const val PRICE = 1_000
    }
}
