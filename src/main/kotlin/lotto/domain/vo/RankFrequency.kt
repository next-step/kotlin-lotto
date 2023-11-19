package lotto.domain.vo

@JvmInline
value class RankFrequency private constructor(val value: Int) {
    init {
        require(value >= 0) { "각 등수의 빈도수는 0 이상이어야 합니다." }
    }

    operator fun plus(other: RankFrequency) =
        RankFrequency(value + other.value)

    companion object {
        fun of(value: Int) = RankFrequency(value)
    }
}
