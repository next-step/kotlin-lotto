package lotto

enum class ProfitState {
    PROFIT,
    SAME,
    LOSS,
}

fun Double.toProfitState(): ProfitState {
    return when {
        this > 1.0 -> ProfitState.PROFIT
        this == 1.0 -> ProfitState.SAME
        else -> ProfitState.LOSS
    }
}
