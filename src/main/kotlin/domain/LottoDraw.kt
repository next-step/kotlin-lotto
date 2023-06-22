package domain

data class LottoDraw(val winningNums: Set<Int>, val bonusBall: Int) {
    init {
        require(bonusBall in 1..45) { "보너스 볼은 1부터 45사이의 값이여야합니다: $bonusBall" }
    }
}
