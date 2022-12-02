package nextstep.mission.lotto.vo

private fun Int.increaseIf(predicate: () -> Boolean) = when {
    predicate() -> this.inc()
    else -> this
}

@JvmInline
value class LottoNumbers(val numbers: List<LottoNumber>) {
    init {
        require(numbers.size == 6) { "로또 숫자는 6개여야 합니다." }
        require(numbers.toSet().size == 6) { "로또 숫자는 중복이 허용되지 않습니다." }
    }

    fun match(otherNumbers: LottoNumbers): Int {
        tailrec fun match(
            matchedCount: Int,
            otherNumbers: LottoNumbers,
            numbers: MutableList<LottoNumber>
        ): Int = when {
            numbers.isEmpty() -> matchedCount
            else -> {
                val currentCount: Int = matchedCount.increaseIf { numbers.removeFirst() in otherNumbers }
                match(currentCount, otherNumbers, numbers)
            }
        }
        return match(0, otherNumbers, this.numbers.toMutableList())
    }

    operator fun contains(lottoNumber: LottoNumber): Boolean = this.numbers.contains(lottoNumber)
}
