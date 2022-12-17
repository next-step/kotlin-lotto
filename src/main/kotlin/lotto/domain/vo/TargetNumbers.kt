package lotto.domain.vo

class TargetNumbers(
    private val targetNumbers: Set<TargetNumber>
) {
    init {
        require(targetNumbers.size == TARGET_NUMBER_SIZE) { "로또의 추첨 번호는 ${TARGET_NUMBER_SIZE}개입니다." }
    }

    fun contains(targetNumber: TargetNumber): Boolean = this.targetNumbers.contains(targetNumber)

    companion object {
        const val TARGET_NUMBER_SIZE = 6
    }
}