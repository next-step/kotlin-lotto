package lotto.domain

@JvmInline
value class LottoNumber(
    val number: Int
) {
    init {
        require(number in (MIN..MAX)) {
            "$MIN 과 $MAX 사이의 값만 생성할 수 있습니다. input: [$number]"
        }
    }

    companion object {
        private const val MIN = 1
        private const val MAX = 45
    }
}
