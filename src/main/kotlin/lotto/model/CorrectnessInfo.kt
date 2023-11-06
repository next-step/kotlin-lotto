package lotto.model

data class CorrectnessInfo(
    val correctnessNumCount: Int,
    var correctLottoInfoCount: Int = 0,
    var winPrizeMoney: Int = 0,
)

fun List<CorrectnessInfo>.getTotalPrizeMoney(): Long {
    return this.sumOf { it.winPrizeMoney.toLong() * it.correctLottoInfoCount.toLong() }
}
