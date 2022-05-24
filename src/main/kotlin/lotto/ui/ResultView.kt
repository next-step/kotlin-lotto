package lotto.ui

class ResultView {

    fun buyCount(count: Int) {
        println("$count" + BUY_COUNT_TEXT)
    }

    companion object {
        private const val BUY_COUNT_TEXT = "개를 구매했습니다."
    }
}
