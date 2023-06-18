package lotto

enum class ProfitState(val message: String) {
    PROFIT("이익"),
    SAME("본전"),
    LOSS("손해"),
}

fun Double.toProfitState(): ProfitState {
    return when {
        this > 1.0 -> ProfitState.PROFIT
        this == 1.0 -> ProfitState.SAME
        else -> ProfitState.LOSS
    }
}
