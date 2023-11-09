package lotto.domain

data class Count(val count: Int) {
    init {
        require(count >= 0) { "로또 수는 최소 0 이상이어야만 합니다." }
    }
}
